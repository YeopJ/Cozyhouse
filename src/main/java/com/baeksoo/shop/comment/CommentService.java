package com.baeksoo.shop.comment;

import com.baeksoo.shop.item.Item;
import com.baeksoo.shop.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
/*
    public void saveComment(String username, String displayName, String comment, Long parentId){
        Comment newcomment = new Comment();
        newcomment.setUsername(username);
        newcomment.setDisplayName(displayName);
        newcomment.setComment(comment);
        newcomment.setParentId(parentId);

        commentRepository.save(newcomment);
    }
*/
    public void saveComment(Member member, Item item, String commentContent){
        Comment newComment = new Comment();
        newComment.setMember(member);     // Member 엔터티 직접 저장
        newComment.setItem(item);         // Item 엔터티 직접 저장
        newComment.setComment(commentContent);

        commentRepository.save(newComment);
    }

}
