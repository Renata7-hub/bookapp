package com.homework.bookapp.service;

import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.ScienceJournal;
import com.homework.bookapp.model.ScienceJournalDTO;
import com.homework.bookapp.repository.BookRepository;
import com.homework.bookapp.repository.ScienceJournalRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScienceJournalService {

    private final ScienceJournalRepository scienceJournalRepository;
    private final BookRepository bookRepository;

    public ScienceJournalService(ScienceJournalRepository scienceJournalRepository, BookRepository bookRepository) {
        this.scienceJournalRepository = scienceJournalRepository;
        this.bookRepository = bookRepository;
    }

    public ScienceJournal journalRegistration(ScienceJournalDTO scienceJournalDTO) {
        ScienceJournal scienceJournal = new ScienceJournal();
        scienceJournal.setBook(scienceJournalDTO.getBook());
        scienceJournal.setScienceIndex(scienceJournalDTO.getScienceIndex());
        scienceJournalRepository.save(scienceJournal);
        return scienceJournal;
    }

    public List<ScienceJournal> getAllJournals() {
        return scienceJournalRepository.findAll();
    }

    public ScienceJournal findJournalByBarcode(String barcode) {
        return scienceJournalRepository.findJournalByBook(bookRepository.findBookByBarcode(barcode));
    }

    public ScienceJournal updateJournalByBarcode(String barcode, ScienceJournalDTO scienceJournalDTO) {
        ScienceJournal updatedJournal = scienceJournalRepository
                .findJournalByBook(bookRepository.findBookByBarcode(barcode));
        updatedJournal.setBook(scienceJournalDTO.getBook());
        updatedJournal.setScienceIndex(scienceJournalDTO.getScienceIndex());
        scienceJournalRepository.save(updatedJournal);
        return updatedJournal;
    }

    public String getJournalTotalPriceByBarcode(String barcode) {
        BigDecimal totalPrice = null;
        ScienceJournal journal = scienceJournalRepository
                .findJournalByBook(bookRepository.findBookByBarcode(barcode));
        Book book = bookRepository.findBookByBarcode(barcode);
                   totalPrice = new BigDecimal(book.getPricePerUnit() * book.getQuantity()*journal.getScienceIndex());
             return "Total price = " + totalPrice + ", when barcode = " + barcode;
    }
}
