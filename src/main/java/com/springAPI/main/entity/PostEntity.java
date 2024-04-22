package com.springAPI.main.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_post", schema = "NEOIB")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class PostEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true )
    private UserEntity user;

    @Column(name = "category", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'etc'")
    private String category;

    @Column(name = "title", nullable = false )
    private String title;

    @Column(name = "content", nullable = false )
    private String content;

    @Column(name = "link", nullable = false )
    private String link;

    @Column(name = "post_id" , nullable = false)
    private String postId;

    @Column(name = "post_date" , nullable = false)
    private LocalDateTime postDate;

    @Column(name = "last_id" , nullable = false)
    private String lastId;

    @Column(name = "last_date" , nullable = false)
    private LocalDateTime lastDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerEntity> answerList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostReactionEntity> postReactions;

    @Column(name = "delete_yn", nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String deleteYn;
}