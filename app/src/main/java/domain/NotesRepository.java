package domain;

import android.text.Editable;

import java.util.ArrayList;
import java.util.List;

import domainBottomNavigation.Callback;
import domainBottomNavigation.Note;

public interface NotesRepository {

    ArrayList<Notes> getAll(); // метод получения всех заметок

    void add (Notes note);    // метод добавления новых заметок

    void addNoteNuv(Editable text, Editable text1, String toString, Callback<Note> noteCallback);

    void addNoteNuv(String title, String message, Callback<Note> noteCallback);

    void getAllNuv(Callback<List<Note>> listCallback);
}
