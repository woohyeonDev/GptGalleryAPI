package com.springAPI.main.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_answer", schema = "NEOIB")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class AnswerEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true )
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false )
    private PostEntity post;

    @Column(name = "content", nullable = false )
    private String content;

    @Column(name = "answer_date" , nullable = false)
    private LocalDateTime answerDate;

    @Column(name = "last_id" , nullable = false)
    private String lastId;  // Assuming this should be a String. If it's a reference to an entity, it should be an entity type.

    @Column(name = "last_date" , nullable = false)
    private LocalDateTime lastDate;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerReactionEntity> answerReactions;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AnswerEntity parent; // 부모 댓글

    @OneToMany(mappedBy = "parent")
    private List<AnswerEntity> replies; // 이 댓글의 대댓글들

    @Column(name = "delete_yn", nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String deleteYn;
}