package com.likelion.likelioncrud.post.api.dto.response;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PostInfoResponseDto(
        String title,
        String contents,
        String writer,
        List<TagInfoResponseDto> tags
) {
    public static PostInfoResponseDto from(Post post) {
        return PostInfoResponseDto.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .writer(post.getMember().getName())
                .tags(
                        post.getPostTags().stream()
                                .map(postTag -> TagInfoResponseDto.from(postTag.getTag()))
                                .toList()
                )
                .build();
    }
}


