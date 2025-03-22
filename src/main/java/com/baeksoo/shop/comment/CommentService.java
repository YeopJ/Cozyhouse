package com.baeksoo.shop.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveComment(String username, String displayName, String comment, Long parentId){
        Comment newcomment = new Comment();
        newcomment.setUsername(username);
        newcomment.setDisplayName(displayName);
        newcomment.setComment(comment);
        newcomment.setParentId(parentId);

        commentRepository.save(newcomment);
    }
}
