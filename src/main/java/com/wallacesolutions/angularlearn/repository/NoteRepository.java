package com.wallacesolutions.angularlearn.repository;

import com.wallacesolutions.angularlearn.model.Note;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wwallace on 7/23/14.
 */

public interface NoteRepository extends CrudRepository<Note, Long>{
	
}
