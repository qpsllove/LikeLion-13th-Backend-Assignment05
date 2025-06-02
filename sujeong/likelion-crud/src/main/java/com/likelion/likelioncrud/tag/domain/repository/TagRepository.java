package com.likelion.likelioncrud.tag.domain.repository;

import com.likelion.likelioncrud.posttag.domain.PostTag;
import com.likelion.likelioncrud.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String tagName);
}
