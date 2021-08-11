package com.homework.bookapp.service;

import com.homework.bookapp.model.ScienceJournal;
import com.homework.bookapp.model.ScienceJournalDTO;
import com.homework.bookapp.repository.ScienceJournalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ScienceJournalService {

    private final ScienceJournalRepository scienceJournalRepository;

    public ScienceJournalService(@Qualifier("journal") ScienceJournalRepository scienceJournalRepository) {
        this.scienceJournalRepository = scienceJournalRepository;
    }

    public ScienceJournal journalRegistration(ScienceJournalDTO scienceJournalDTO) {
        ScienceJournal scienceJournal = new ScienceJournal();
        scienceJournal.setBook(scienceJournalDTO.getBook());
        scienceJournal.setScienceIndex(scienceJournalDTO.getScienceIndex());
        scienceJournalRepository.save(scienceJournal);
        return scienceJournal;
    }
}
