package com.wallacesolutions.angularlearn.model;

import java.io.Serializable;

/**
 * Created by wwallace on 7/23/14.
 */
public class Note implements Serializable{

    private long id;
    private String title;
    private String content;

    public Note() {
    }

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
