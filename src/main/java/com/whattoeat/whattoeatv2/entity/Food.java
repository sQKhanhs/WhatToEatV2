package com.whattoeat.whattoeatv2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    private int calories;
    private String cuisine;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user_foods")
    private User user;

    @OneToMany(mappedBy = "food")
    @JsonManagedReference(value = "restaurants_foods1")
    private List<RestaurantFood> restaurantFoods;

}
