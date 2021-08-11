package com.homework.bookapp.controller;

import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.ScienceJournalDTO;
import com.homework.bookapp.service.ScienceJournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/journal")
@RestController
//@AllArgsConstructor
public class ScienceJournalController{

    private final ScienceJournalService scienceJournalService;

    public ScienceJournalController(ScienceJournalService scienceJournalService) {
        this.scienceJournalService = scienceJournalService;
    }

    @PostMapping
    public ResponseEntity<Book> journalRegistration(@RequestBody ScienceJournalDTO scienceJournalDTO) {
        return new ResponseEntity(scienceJournalService.journalRegistration(scienceJournalDTO), HttpStatus.CREATED);
    }

}
