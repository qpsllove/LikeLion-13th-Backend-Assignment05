package com.likelion.likelioncrud.tag.application;

import com.likelion.likelioncrud.member.api.dto.response.MemberInfoResponseDto;
import com.likelion.likelioncrud.member.api.dto.response.MemberListResponseDto;
import com.likelion.likelioncrud.member.domain.Member;
import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.post.domain.repository.PostRepository;
import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.domain.Tag;
import com.likelion.likelioncrud.tag.domain.repository.TagRepository;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    // 태그 저장
    @Transactional
    public void tagSave(TagSaveRequestDto tagSaveRequestDto) {
        Tag tag = Tag.builder()
                .name(tagSaveRequestDto.name())
                .build();
        tagRepository.save(tag);
    }

    // 태그 모두 조회
    public TagListResponseDto tagFindAll() {
        List<Tag> tags = tagRepository.findAll();
        List<TagInfoResponseDto> tagInfoResponseDtoList = tags.stream()
                .map(TagInfoResponseDto::from)
                .toList();
        return TagListResponseDto.from(tagInfoResponseDtoList);
    }


   // 태그 단건 조회
    public TagInfoResponseDto tagFindOne(Long tagId) {
        Tag tag = tagRepository
                .findById(tagId)
                .orElseThrow(IllegalArgumentException::new);

        return TagInfoResponseDto.from(tag);
    }

    // 태그 수정
    @Transactional
    public void tagUpdate(Long tagId,
            TagUpdateRequestDto tagUpdateRequestDto) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);

        tag.update(tagUpdateRequestDto);
    }

    // 태그 삭제
    @Transactional
    public void tagDelete(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);

        tagRepository.delete(tag);
    }
}