package com.homework.bookapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@Setter
@Entity
public class ScienceJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book;

    @Min(value = 1, message = "Science index should not be less than 1")
    @Max(value = 10, message = "Science index should not be greater than 10")
    private int scienceIndex;

}
