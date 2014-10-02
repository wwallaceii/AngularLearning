package com.wallacesolutions.angularlearn.rest;

import com.wallacesolutions.angularlearn.model.Note;
import com.wallacesolutions.angularlearn.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

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
    public Note save(@RequestBody Note note,
    		         HttpServletResponse response) {
       Note savedNote = repository.save(note);
       
       response.setStatus(HttpServletResponse.SC_CREATED);
       
       return savedNote;
    }

    @RequestMapping(method = {RequestMethod.PUT}, value="/notes")
    public Note update(@RequestBody Note note,
    		           HttpServletResponse response) throws IOException {
        Note retrievedNote = repository.findOne(note.getId());
        
        if(retrievedNote == null)
        {
        	response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    	return repository.save(note);
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/notes/{id}")
    public Note get(@PathVariable("id") Long id,
    		        HttpServletResponse response) throws IOException {
        Note note = repository.findOne(id);
        
        if(note == null)
        {
        	response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        
        return note;
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value="/notes/{id}")
    public void delete(@PathVariable("id") Long id,
    		           HttpServletResponse response) throws IOException {
        Note note = repository.findOne(id);
        
        if(note == null)
        {
        	response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else
        {
	    	repository.delete(id);
        }
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/notes")
    public Collection<Note> getAll() {
        return (Collection<Note>) repository.findAll();
    }
}
