package domainBottomNavigation;

import android.content.Context;
import android.content.SharedPreferences;

import domain.NotesRepository;
import domain.SharedPreferencesNotesRepository;
import domainBottomNavigation.InMemoryNoteRepositoryNavigation;
import domainBottomNavigation.NotesRepositoryNavigation;

//синглтон
public class Dependencies {

    private static NotesRepository notesRepository;

    public static NotesRepository getNotesRepository(Context context) {
        if (notesRepository == null) {
            notesRepository = new SharedPreferencesNotesRepository(context);


        }
        return notesRepository;


    }

}
