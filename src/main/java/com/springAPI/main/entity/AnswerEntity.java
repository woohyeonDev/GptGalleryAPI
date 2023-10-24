package com.springAPI.main.entity;

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
    private LocalDateTime lastId;

    @Column(name = "last_date" , nullable = false)
    private LocalDateTime lastDate;
}
