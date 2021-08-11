package com.homework.bookapp.repository;


import com.homework.bookapp.model.ScienceJournal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScienceJournalRepository extends JpaRepository<ScienceJournal, Long> {

}
