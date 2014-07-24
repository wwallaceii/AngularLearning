package com.wallacesolutions.angularlearn;

import com.wallacesolutions.angularlearn.model.Note;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wwallace on 7/23/14.
 */
@Component
public class NoteRepository {
    private Map<Long, Note> noteStore = new HashMap<Long, Note>();
    private final AtomicLong counter = new AtomicLong();

    public synchronized Note save(Note note) {
        Note newNote = new Note(counter.incrementAndGet(), note.getTitle(), note.getContent()) ;
        noteStore.put(newNote.getId(), newNote );

        return newNote;
    }

    public synchronized void update(Note note) {
         if(noteStore.containsKey(note.getId()))
         {
            noteStore.put(note.getId(), note);
         }
    }

    public synchronized Note get(Long id) {
        return noteStore.get(id);
    }

    public synchronized Collection<Note> getAll() {
        return noteStore.values();
    }

    public synchronized void delete(Long id) {
        noteStore.remove(id);
    }
}
