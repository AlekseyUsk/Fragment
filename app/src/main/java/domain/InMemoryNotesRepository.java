package domain;

import android.content.Context;
import android.text.Editable;

import com.example.fragment.R;

import java.util.ArrayList;
import java.util.List;

import domainBottomNavigation.Callback;
import domainBottomNavigation.Note;

/**
 * КЛАСС КОНКРЕТНОЙ РЕАЛИЗАЦИИ СО СПИСКОМ КОТОРЫЙ МЫ БУДЕМ ВОЗВРАЩАТЬ
 */
public class InMemoryNotesRepository implements NotesRepository {

    private static NotesRepository INSTANCE;

    public static NotesRepository getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryNotesRepository(context);
        }
        return INSTANCE;
    }

    private Context context;

    public InMemoryNotesRepository(Context context) {
        this.context = context;
    }


    @Override
    public ArrayList<Notes> getAll() {
        ArrayList<Notes> result = new ArrayList<>();
        result.add(new Notes(context.getString(R.string.lada), context.getString(R.string.date), (R.drawable.lada)));
        result.add(new Notes(context.getString(R.string.nissan), context.getString(R.string.date), (R.drawable.nissan)));
        result.add(new Notes(context.getString(R.string.toyota), context.getString(R.string.date), (R.drawable.toyota)));
        result.add(new Notes(context.getString(R.string.camaro), context.getString(R.string.date), (R.drawable.camaro)));

        return result;
    }

    @Override
    public void add(Notes note) {

    }

    @Override
    public void addNoteNuv(Editable text, Editable text1, String toString, Callback<Note> noteCallback) {

    }

    @Override
    public void getAllNuv(Callback<List<Note>> listCallback) {

    }
}
