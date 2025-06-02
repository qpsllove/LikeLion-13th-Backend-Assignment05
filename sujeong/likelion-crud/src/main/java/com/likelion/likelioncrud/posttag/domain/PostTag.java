package com.likelion.likelioncrud.posttag.domain;

import com.likelion.likelioncrud.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;
import com.likelion.likelioncrud.tag.domain.Tag;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class PostTag {

    @Id
    @Column(name = "post_tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 다대일 관계, 여러 PostTag가 하나의 Post에 연결 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // 다대일 관계, 여러 PostTag가 하나의 Tag에 연결 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }
}
