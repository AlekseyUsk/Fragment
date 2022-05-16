package domainBottomNavigation;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class InMemoryNoteRepositoryNavigation implements NotesRepositoryNavigation {

    Handler handler = new Handler(Looper.myLooper());//Handler o.s нужен для передачи команды основному потоку(доставки сообщения потоку)
    //так как только основной поток может трогать вьюшки если не основной поток то будет креш

    Executor executor = Executors.newSingleThreadExecutor();//завел однопоточный Executor (нужно еще почтитать за него)

    private ArrayList<Note> data = new ArrayList<>();

    //заполняем список
    public InMemoryNoteRepositoryNavigation() {
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 1", "Message 1", new Date()));//new Date() - дата (время)
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 2", "Message 2", new Date()));
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 3", "Message 3", new Date()));
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 4", "Message 4", new Date()));
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 5", "Message 5", new Date()));
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 6", "Message 6", new Date()));
//        data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 7", "Message 7", new Date()));
//
//        for (int i = 0; i < 3000; i++) {
//            data.add(new Note(UUID.randomUUID(), UUID.randomUUID().toString(), "Title 8", "Message 8", new Date()));
//        }
    }


    @Override
    public void addNoteNuv(String title, String message, Callback<Note> callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                Note note = new Note(UUID.randomUUID(),  title, message, new Date());

                data.add(note);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(note);// говорим успешно заметка добавлена
                    }
                });
            }
        });
    }

    @Override
    public void getAllNuv(Callback<List<Note>> callback) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                //послетого как создал Handler handler = new Handler(Looper.myLooper());
                //даем команду выполнить в основном потоке
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(data);
                    }
                });

            }
        });

    }

    @Override
    public void addNoteNuv(Editable text, Editable text1, String toString, Callback<Note> noteCallback) {

    }

}
//без Handler handler = new Handler(Looper.myLooper());у меня запускался белый экран и был креш
//так как нужно запускать все в основном потоке !!! помог Handler


