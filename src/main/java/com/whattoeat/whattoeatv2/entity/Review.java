package com.whattoeat.whattoeatv2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_comment;
    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user_review")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference(value = "restaurant_review")
    private Restaurant restaurant;
}
