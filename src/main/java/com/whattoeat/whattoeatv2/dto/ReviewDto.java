package com.whattoeat.whattoeatv2.dto;

import com.whattoeat.whattoeatv2.entity.Restaurant;
import com.whattoeat.whattoeatv2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String user_comment;
    private int score;
    private User user;
    private Restaurant restaurant;
}
