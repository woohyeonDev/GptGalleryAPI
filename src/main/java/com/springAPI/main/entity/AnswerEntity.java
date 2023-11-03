package com.springAPI.main.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
}