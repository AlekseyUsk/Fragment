package uiBottomNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import domainBottomNavigation.Note;
import domainBottomNavigation.di.Dependencies;

public class NotesBottomListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notes_bottom_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView notesList = view.findViewById(R.id.notes_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        notesList.setLayoutManager(layoutManager);

        NotesAdapter notesAdapter = new NotesAdapter();//создал экземпляр класса
        notesList.setAdapter(notesAdapter);// и даем RecyclerView адаптер (из класса NotesAdapter)


        List<Note> notes = Dependencies.NOTES_REPOSITORY_NAVIGATION.getAll();//получаю список заметок через Dependencies.NOTES_REPOSITORY_NAVIGATION

        notesAdapter.setData(notes);//передал адаптеру список заметок ( метод set.Date )

        notesAdapter.notifyDataSetChanged();//говорим адаптеру что данные изменились, процессор перерисовки запускается и рисуется новый список
        // я понял что экран вниз пролистал появляются новые к примеру как тут список заметок и это обеспечивает менеенагруженность системы приложения
    }


}
