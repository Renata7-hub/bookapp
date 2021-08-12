package com.homework.bookapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScienceJournalDTO extends BookDTO {

    private Book book;

    private int scienceIndex;
}
