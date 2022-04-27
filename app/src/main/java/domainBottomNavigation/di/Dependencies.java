package domainBottomNavigation.di;

import domainBottomNavigation.InMemoryNoteRepositoryNavigation;
import domainBottomNavigation.NotesRepositoryNavigation;
//синглтон
public class Dependencies {

public static final NotesRepositoryNavigation NOTES_REPOSITORY_NAVIGATION = new InMemoryNoteRepositoryNavigation();

}
