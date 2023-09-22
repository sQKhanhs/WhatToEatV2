package com.whattoeat.whattoeatv2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable=false, unique=true)
    private String email;
    private String image;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user_foods")
    private List<Food> foods;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user_review")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();
}
