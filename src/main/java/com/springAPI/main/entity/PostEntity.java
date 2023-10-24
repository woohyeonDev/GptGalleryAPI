package com.springAPI.main.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_post", schema = "NEOIB")
@Getter
@Setter
public class PostEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true )
    private UserEntity user;

    @Column(name = "title", nullable = false )
    private String title;

    @Column(name = "content", nullable = false )
    private String content;

    @Column(name = "post_date" , nullable = false)
    private LocalDateTime postDate;

    @Column(name = "last_id" , nullable = false)
    private LocalDateTime lastId;

    @Column(name = "last_date" , nullable = false)
    private LocalDateTime lastDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<AnswerEntity> answerList;
}