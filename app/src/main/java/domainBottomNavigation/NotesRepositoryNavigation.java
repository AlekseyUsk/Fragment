package domainBottomNavigation;

import android.text.Editable;

import java.util.List;

public interface NotesRepositoryNavigation {

    void addNoteNuv (String title,String message,Callback <Note> callback);  // метод добавления новых заметок в AddNoteBottomSheetDialogFragment(шторка которая выезжает снизу)

    void getAllNuv(Callback<List<Note>> callback); // метод получения всех заметок

    void addNoteNuv(Editable text, Editable text1, String toString, Callback<Note> noteCallback);//горела ошибка пока неимплементровал этот метод???
}
