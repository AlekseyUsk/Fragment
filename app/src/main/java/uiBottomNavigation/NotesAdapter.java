package uiBottomNavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import domainBottomNavigation.Note;

//ViewHolder - отпечаток view какого то типа который при построения списка переиспользуется(в нашем случае это отпечаток карточки в заметках)

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {//RecyclerView.Adapter<VH>

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM, HH:mm", Locale.getDefault());//дата и время к заметкам


    // ДАННЫЕ КОТОРЫЕ СЮДА ОТОБРАЖАТЬ БУДЕМ ->
    public List<Note> data = new ArrayList<>();// todo-1 добавил список заметок где хранятся данные

    public void setData(Collection<Note> notes) { // todo-2 завел метод который будет добавлять коллекцию Note
        data.addAll(notes);

    }

    //todo сгенерировали 3 обязательных метода :
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        NotesViewHolder holder = new NotesViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) { // метод служит чтобы заполнить элементы каждого по пазициям

        Note note = data.get(position);

        holder.title.setText(note.getTitle());
        holder.message.setText(note.getMessage());
        holder.date.setText(simpleDateFormat.format(note.getCreatedAt()));//дата и врямея к заметкам


    }

    @Override
    public int getItemCount() { // метод колличество эллементов
        return data.size();//указываем сколько элементов будем возвращать
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView message;
        TextView date;

        public NotesViewHolder(@NonNull View itemView) { // конструктор по умолч принимающий itemView заметок
            super(itemView);


            title = itemView.findViewById(R.id.title);
            message = itemView.findViewById(R.id.message);
            date = itemView.findViewById(R.id.date);


        }
    }


}
