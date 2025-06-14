package com.baeksoo.shop;

import com.baeksoo.shop.item.Item;
import com.baeksoo.shop.item.ItemRepository;
import com.baeksoo.shop.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;



import java.util.List;


@Controller
@RequiredArgsConstructor
public class BasicController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/")
    String getMainPage(Model model){
        List<Item> result = itemService.findAllItem();

        model.addAttribute("items", result);

        return "index.html";
    }
}
