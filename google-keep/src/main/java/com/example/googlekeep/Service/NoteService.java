package com.example.googlekeep.Service;

import com.example.googlekeep.Domain.Note;
import com.example.googlekeep.Repository.NoteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional

public class NoteService {

    private final NoteRepository noteRepository;
    private final ObjectMapper objectMapper;

    // 모든 노트 조회
    public String getAllNotesToJson() {
        List<Note> notes = noteRepository.findAll();
        String notes_json = null;

        try {
            notes_json = objectMapper.writeValueAsString(notes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return notes_json;
    }

    // 노트 저장
    public String saveNote(Note note) {

        Note n_note = new Note(note.getTitle(), note.getBody(), note.isPinned(), note.getBackgroundColor());
        noteRepository.save(n_note);

        String note_json = null;
        try {
            note_json = objectMapper.writeValueAsString(n_note);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return note_json;
    }

    public String deleteNote(Long id) {
        Map<String, String> map = new HashMap<>();
        map.put("msg","노트 ID" + id+ "가 삭제되었습니다");
        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        noteRepository.delete(id);
        return json;
    }

    public String updateNote(Long noteId, Note note) {
        String json = null;

        Note n_note = noteRepository.findOne(noteId);

        String title = note.getTitle();
        String body = note.getBody();
        boolean pinned = note.isPinned();
        String background = note.getBackgroundColor();
        Date updatedAt = new Date(System.currentTimeMillis());

        if(title != null)
            n_note.setTitle(title);
        if(body != null)
            n_note.setBody(body);
        if(pinned != n_note.isPinned())
            n_note.setPinned(pinned);
        if(background != null)
            n_note.setBackgroundColor(background);
        n_note.setUpdateAt(updatedAt);

        noteRepository.save(n_note);

        try {
            json = objectMapper.writeValueAsString(n_note);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
