package com.likelion.likelioncrud.tag.api.dto;

import com.likelion.likelioncrud.common.error.SuccessCode;
import com.likelion.likelioncrud.common.template.ApiResTemplate;
import com.likelion.likelioncrud.member.api.dto.response.MemberListResponseDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.application.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    // 태그 저장
    @PostMapping("/save")
    public ResponseEntity<String> tagSave(@RequestBody TagSaveRequestDto tagSaveRequestDto) {
        tagService.tagSave(tagSaveRequestDto);
        return new ResponseEntity<>("태그 저장!", HttpStatus.CREATED);
    }

    // 태그 전체 조회
    @GetMapping("/all")
    public ResponseEntity<TagListResponseDto> tagFindAll() {
        TagListResponseDto tagListResponseDto = tagService.tagFindAll();
        return new ResponseEntity<>(tagListResponseDto, HttpStatus.OK);
    }


   // 태그 id를 기준으로 태그 목록 조회
    @GetMapping("/{tagId}")
    public ResponseEntity<TagInfoResponseDto> TagFindOne(@PathVariable("tagId") Long tagId) {
        TagInfoResponseDto tagInfoResponseDto = tagService.tagFindOne(tagId);
        return new ResponseEntity<>(tagInfoResponseDto, HttpStatus.OK);
    }

    // 태그 id를 기준으로 태그 수정
    @PatchMapping("/{tagId}")
    public ResponseEntity<String> tagUpdate(
            @PathVariable("tagId") Long tagId,
            @RequestBody TagUpdateRequestDto tagUpdateRequestDto) {
        tagService.tagUpdate(tagId, tagUpdateRequestDto);
        return new ResponseEntity<>("태그 수정", HttpStatus.OK);
    }

    // 태그 id를 기준으로 태그 삭제
    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> tagDelete(
            @PathVariable("tagId") Long tagId) {
        tagService.tagDelete(tagId);
        return new ResponseEntity<>("태그 삭제", HttpStatus.OK);
    }
}