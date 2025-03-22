package com.baeksoo.shop.item;

import com.baeksoo.shop.Notification;
import com.baeksoo.shop.NotificationRepository;
import com.baeksoo.shop.comment.CommentRepository;
import com.baeksoo.shop.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    //repository 등록
    private final ItemRepository itemRepository;
/* Lombok 없이 repository 등록하는 원래 코드
    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
*/
    //ItemService 오브젝트 미리 만들어두고 API에서 사용. API에서 요청받을때마다 만들면 컴퓨터에 부담될 수 있음
    private final ItemService itemService;
    private final NotificationRepository notificationRepository;
    private final S3Service s3Service;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/list")
    String list(Model model){
        //item 테이블 가져오기
        List<Item> result = itemService.findAllItem();

        model.addAttribute("items", result);

        return "list.html";
    }
    @GetMapping("/list/page/{page}")
    String getListPage(@PathVariable Integer page, Model model){
        Page<Item> result = itemRepository.findPageBy(PageRequest.of(page-1, 5));
        //result.getTotalPages();
        model.addAttribute("items", result);
        model.addAttribute("pages", result.getTotalPages());

        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }
    @PostMapping("/add")
    String addPost(@RequestParam(name = "title") String title,//@RequestParam()은 일반적으로 생략 가능
                   @RequestParam(name = "price") Integer price,
                   @RequestParam(name = "imgURL") String img,
                   Authentication auth){//여러 개의 input 받고 싶으면 Map을 이용해 한 변수에 모두 저장 가능

        System.out.println(title);
        System.out.println(price);
        System.out.println(img);
        if(auth.isAuthenticated()){
            itemService.saveItem(title, price, img, auth.getName());
        }

        return "redirect:/list/page/1";//list 페이지로 다시 돌아가게 하기
    }
    @GetMapping("/presigned-url")
    @ResponseBody
    String getURL(@RequestParam String filename){

        var imgURL = s3Service.createPresignedUrl("shop/" + filename);
        System.out.println(imgURL);

        return imgURL;
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){
        //optional 타입 쓰는 이유: result가 비어있을 수도 있음
        Optional<Item> result = itemRepository.findById(id);
        var r = commentRepository.findAllByParentId(id);
        //result 값이 존재할 때만 작동
        if(result.isPresent()){
            model.addAttribute("id", result.get());
            model.addAttribute("comments", r);
            return "detail.html";
        }
        else{
          return "redirect:/list/page/1";
        }
    }

    @GetMapping("/update/{id}")
    String update(@PathVariable Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);

        if(result.isPresent()){
            model.addAttribute("id", result.get());
            return "update.html";
        }
        else{
            return "redirect:/list/page/1";
        }

    }
    @PostMapping("/update-item/{id}")
    String updateItem(@PathVariable Long id, String title, Integer price) throws Exception {

        //데이터 수정하는 함수
        itemService.updateItem(id, title, price);

        return "redirect:/list/page/1";//list 페이지로 다시 돌아가게 하기
    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id){
        //System.out.println("삭제요청");
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제되었습니다.");
    }

    @GetMapping("/notify")
    String notify(Model model){
        List<Notification> result = notificationRepository.findAll();
        model.addAttribute("notification", result);

        return "notify.html";
    }

    @PostMapping("/search")
    String postSearch(@RequestParam String searchText, Model model) {
        //Item테이블에서 searchText가 들어있는거 찾아서 가져와주세요
        //var result = itemRepository.findAllByTitleContains(searchText);
        List<Item> result = itemRepository.rawQuery1(searchText);
        model.addAttribute("items", result);
        System.out.println(result);
        return "search.html";
    }

}
