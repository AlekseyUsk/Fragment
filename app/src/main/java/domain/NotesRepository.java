package domain;

import java.util.ArrayList;

public interface NotesRepository {

    ArrayList<Notes> getAll(); // метод получения всех заметок

    void add (Notes note);    // метод добавления новых заметок

}
