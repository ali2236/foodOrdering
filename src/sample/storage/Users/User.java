package sample.storage.Users;

import sample.data.Note;
import sample.data.NotePad;

import java.util.List;

public class User {
    private String username;
    private String password;

    private Note note;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        note = new Note();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
