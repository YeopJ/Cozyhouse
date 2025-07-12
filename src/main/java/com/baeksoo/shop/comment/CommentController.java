package com.baeksoo.shop.comment;


import com.baeksoo.shop.item.Item;
import com.baeksoo.shop.item.ItemRepository;
import com.baeksoo.shop.member.Member;
import com.baeksoo.shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /*
    @PostMapping("/comment")
    String addComment(@RequestParam(name = "comment") String comment,
                      @RequestParam(name = "id") Long parentId,
                      Authentication auth){
        if (auth.isAuthenticated()) {
            String username = auth.getName(); // 현재 로그인한 사용자의 username 가져오기
            Optional<Member> memberOptional = memberRepository.findByUsername(username);

            if (memberOptional.isPresent()) {
                String displayName = memberOptional.get().getDisplayName(); // displayName 가져오기
                commentService.saveComment(username, displayName, comment, parentId);
            }
        }

        return "redirect:/detail/" + parentId;
    }
*/
    @PostMapping("/comment")
    String addComment(@RequestParam(name = "comment") String comment,
                      @RequestParam(name = "id") Long parentId,
                      Authentication auth) {
        if (auth.isAuthenticated()) {
            String username = auth.getName();
            Member member = memberRepository.findByUsername(username).orElseThrow();
            Item item = itemRepository.findById(parentId).orElseThrow();

            commentService.saveComment(member, item, comment);
        }
        return "redirect:/detail/" + parentId;
    }

}
