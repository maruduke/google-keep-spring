package com.example.googlekeep.Repository;

import com.example.googlekeep.Domain.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void save() throws Exception{

        Note n = new Note("title", "body", true, "#FFFFFF");

        Long id = noteRepository.save(n);

        Note note = noteRepository.findOne(id);

        Assertions.assertEquals(n.getBody(), note.getBody());

    }

}