package com.example.friendnotes.controller;


import com.example.friendnotes.exception.ResourceNotFoundException;
import com.example.friendnotes.model.Intersactions;
import com.example.friendnotes.repository.IntersactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//TODO: notes değil artık interaction olacak hepsi url ve methodlar
//TODO: repository değil service'e gidicek
@RestController
@RequestMapping("/api")
public class InstersactionsController {

    @Autowired
    IntersactionsRepository intersactionsRepository;

    // Get All Notes
    @GetMapping("/notes")
    public List<Intersactions> getAllNotes() {
        return intersactionsRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/notes")
    public Intersactions createNote(@Valid @RequestBody Intersactions note) {
        return intersactionsRepository.save(note);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Intersactions getNoteById(@PathVariable(value = "id") Long noteId) {
        return intersactionsRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public Intersactions updateNote(@PathVariable(value = "id") Long noteId,
                                    @Valid @RequestBody Intersactions noteDetails) {

        Intersactions note = intersactionsRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Intersactions updatedNote = intersactionsRepository.save(note);
        return updatedNote;
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Intersactions note = intersactionsRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        intersactionsRepository.delete(note);

        return ResponseEntity.ok().build();
    }


}
