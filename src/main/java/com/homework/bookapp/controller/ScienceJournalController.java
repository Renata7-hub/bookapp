package com.homework.bookapp.controller;

import com.homework.bookapp.model.ScienceJournal;
import com.homework.bookapp.model.ScienceJournalDTO;
import com.homework.bookapp.service.ScienceJournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping(value = "/journal")
@RestController
public class ScienceJournalController{

    private final ScienceJournalService scienceJournalService;


    public ScienceJournalController(ScienceJournalService scienceJournalService) {
        this.scienceJournalService = scienceJournalService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ScienceJournal journalRegistration(@RequestBody ScienceJournalDTO scienceJournalDTO) {
        return scienceJournalService.journalRegistration(scienceJournalDTO);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ScienceJournal> getAllJournals() {
        return scienceJournalService.getAllJournals();
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<ScienceJournal> getJournalByBarcode(@PathVariable String barcode) {
        if (scienceJournalService.findJournalByBarcode(barcode) != null)
            return new ResponseEntity(scienceJournalService.findJournalByBarcode(barcode), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{barcode}")
    public ResponseEntity<ScienceJournal> updateJournalByBarcode(@PathVariable String barcode,
                                                                 @RequestBody ScienceJournalDTO scienceJournalDTO) {
        if (scienceJournalService.findJournalByBarcode(barcode) != null)
            return new ResponseEntity(scienceJournalService.updateJournalByBarcode(barcode, scienceJournalDTO),
                    HttpStatus.OK);
        else
            return new ResponseEntity(scienceJournalService.journalRegistration(scienceJournalDTO), HttpStatus.CREATED);
    }

    @GetMapping("/price/{barcode}")
    public ResponseEntity<ScienceJournal> getJournalTotalPriceByBarcode(@PathVariable String barcode) {
        if (scienceJournalService.findJournalByBarcode(barcode) != null)
            return new ResponseEntity(scienceJournalService.getJournalTotalPriceByBarcode(barcode), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
