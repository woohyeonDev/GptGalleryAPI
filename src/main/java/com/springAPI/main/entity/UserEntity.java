package com.springAPI.main.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_info", schema = "NEOIB")
@Getter
@Setter
public class UserEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "join_date" , nullable = false)
    private LocalDateTime joinDate;

    @Column(name = "last_date" , nullable = false)
    private LocalDateTime lastDate;

    @OneToMany(mappedBy = "user")
    private List<PostEntity> postList;
}
