package com.wallacesolutions.angularlearn.rest;

import com.wallacesolutions.angularlearn.NoteRepository;
import com.wallacesolutions.angularlearn.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wwallace on 7/23/14.
 */
@RestController
public class NoteController {
    private NoteRepository repository;

    @Autowired
    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = {RequestMethod.POST}, value="/notes")
    public Note save(@RequestBody Note note) {
        return repository.save(note);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value="/notes")
    public void update(@RequestBody Note note) {
        repository.update(note);
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/notes/{id}")
    public Note get(@PathVariable("id") Long id) {
        return repository.get(id);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value="/notes/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(id);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/notes")
    public Collection<Note> getAll() {
        return repository.getAll();
    }
}
