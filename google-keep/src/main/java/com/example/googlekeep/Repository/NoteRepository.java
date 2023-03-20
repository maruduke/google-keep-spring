package com.example.googlekeep.Repository;

import com.example.googlekeep.Domain.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class NoteRepository {

    private final EntityManager em;

    public Long save(Note note) {

        if( note.getId() == null) {
            System.out.println("persist");
            em.persist(note);
        } else {
            System.out.println("merge");
            em.merge(note);
        }
        return note.getId();
    };

    public List<Note> findAll() {
        return em.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();
    };

    public Note findOne(Long id) {
        return em.find(Note.class, id);
    }


    public int delete(Long id) {
        String jsql = "delete from Note n where n.id=:id";
        Query query = em.createQuery(jsql).setParameter("id", id);
        int row = query.executeUpdate();
        return row;
    }



}
