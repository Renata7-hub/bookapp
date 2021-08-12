package com.homework.bookapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;


@Getter
@Setter
@Entity
public class AncientBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book;

    @Max(value = 1900, message = "Release year should not be greater than 1900")
    private int releaseYear;

}
