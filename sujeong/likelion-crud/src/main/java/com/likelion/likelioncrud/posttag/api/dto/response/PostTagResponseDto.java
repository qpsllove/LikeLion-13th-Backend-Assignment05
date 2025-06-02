package com.likelion.likelioncrud.posttag.api.dto.response;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.tag.domain.Tag;
import lombok.Builder;
import lombok.Getter;

@Builder
public record PostTagResponseDto (
        String title,
        String contents,
        String writer,
        String name

) {
    public static PostTagResponseDto from(Post post, Tag tag) {
        return PostTagResponseDto.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .writer(post.getMember().getName())
                .name(tag.getName())
                .build();
    }


}

