package domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import domainBottomNavigation.Callback;
import domainBottomNavigation.Note;

class SharedPreferencesNotesRepository implements NotesRepository {

    public Callback callback;

    private static final String KEY_SAVED_NOTES = "KEY_SAVED_NOTES";


    private SharedPreferences sharedPreferences;

    private Context context;

    public SharedPreferencesNotesRepository(Context context) {
        sharedPreferences = context.getSharedPreferences("NOTES", context.MODE_PRIVATE);
    }


    @Override
    public ArrayList<Notes> getAll() {
        return null;
    }

    @Override
    public void add(Notes note) {

    }

    @Override
    public void addNoteNuv(Editable text, Editable text1, String toString, Callback<Note> noteCallback) {

    }

    @Override
    public void addNoteNuv(String title, String message, Callback<Note> noteCallback) {

        ArrayList<Note> data = new ArrayList<>();
        data.add(new Note(UUID.randomUUID().toString(), title, message, new Date()));

        Note note = new Note(UUID.randomUUID().toString(), title, message, new Date());

        Gson gson = new Gson();

        String savedData = sharedPreferences.getString(KEY_SAVED_NOTES, "[]");

        Type type = new TypeToken<ArrayList<Note>>() {
        }.getType();

        List<Note> savedNotes = gson.fromJson(savedData, type);

        savedNotes.add(note);

        String toWrite = gson.toJson(savedNotes, type);

        sharedPreferences
                .edit()
                .putString(KEY_SAVED_NOTES, toWrite)
                .apply();

        callback.onSuccess(note);
    }

    @Override
    public void getAllNuv(Callback<List<Note>> listCallback) {

        Gson gson = new Gson();

        String savedData = sharedPreferences.getString(KEY_SAVED_NOTES, "[]");

        Type type = new TypeToken<ArrayList<Note>>() {
        }.getType();

        List<Note> savedNotes = gson.fromJson(savedData, type);


        callback.onSuccess(savedNotes);

    }
}
