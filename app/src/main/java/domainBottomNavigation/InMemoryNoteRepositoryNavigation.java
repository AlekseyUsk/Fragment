package domainBottomNavigation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InMemoryNoteRepositoryNavigation implements NotesRepositoryNavigation {

    private ArrayList<Note> data = new ArrayList<>();
    //заполняем список
    public InMemoryNoteRepositoryNavigation(){
        data.add(new Note(UUID.randomUUID().toString(),"Title 1","Message 1",new Date()));//new Date() - дата (время)
        data.add(new Note(UUID.randomUUID().toString(),"Title 2","Message 2",new Date()));
        data.add(new Note(UUID.randomUUID().toString(),"Title 3","Message 3",new Date()));
        data.add(new Note(UUID.randomUUID().toString(),"Title 4","Message 4",new Date()));
        data.add(new Note(UUID.randomUUID().toString(),"Title 5","Message 5",new Date()));
        data.add(new Note(UUID.randomUUID().toString(),"Title 6","Message 6",new Date()));
        data.add(new Note(UUID.randomUUID().toString(),"Title 7","Message 7",new Date()));
    }




    @Override
    public List<Note> getAll() {
        return null;
    }
}
