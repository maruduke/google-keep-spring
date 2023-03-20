package com.example.googlekeep.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Note {

    @Id @GeneratedValue
    @Column(name = "note_id")
    private Long id;
    private String title;
    private String body;
    private Date createdAt;
    private Date updateAt;
    private boolean pinned;
    private String backgroundColor;

    public Note(String title, String body, boolean pinned, String backgroundColor) {

        this.title = title;
        this.body = body;
        this.pinned = pinned;
        this.backgroundColor = backgroundColor;

        this.createdAt = new Date(System.currentTimeMillis());
        this.updateAt = this.createdAt;

        this.pinned = pinned;
        this.backgroundColor = backgroundColor;

    }

    public Note() {
        this.createdAt = new Date(System.currentTimeMillis());
        this.updateAt = this.createdAt;
    }
}
