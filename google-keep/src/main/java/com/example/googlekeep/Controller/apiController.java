package com.example.googlekeep.Controller;

import com.example.googlekeep.Domain.Note;
import com.example.googlekeep.Service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class apiController {

    private final NoteService noteService;
    private final ObjectMapper objectMapper;

    // 모든 노트 반환
    @GetMapping("/api/notes")
    public String getNotes() {

        String notes_List_json = noteService.getAllNotesToJson();
        return notes_List_json;
    }

    @PostMapping("/api/notes")
    public String saveNote(@RequestBody Note note) {
        String note_json = noteService.saveNote(note);
        return note_json;

    }

    // 노트 수정 기능
    @PutMapping("/api/notes/{noteId}")
    public String updateNote(@PathVariable("noteId") Long NoteId, @RequestBody Note note) {

        note.setId(NoteId);
        String json = noteService.updateNote(NoteId, note);
        System.out.println(note.getId());
        System.out.println(note.getTitle());
        System.out.println(note.getBody());
        System.out.println(note.getBackgroundColor());

        return json;
    }

    // 노트 삭제 기능
    @DeleteMapping("/api/notes/{noteId}")
    public String deleteNote(@PathVariable("noteId") Long NoteId) {
      String json = noteService.deleteNote(NoteId);
      return json;
    }
}
