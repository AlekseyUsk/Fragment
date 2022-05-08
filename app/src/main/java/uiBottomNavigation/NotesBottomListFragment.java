package uiBottomNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.fragment.R;

import java.util.List;

import domainBottomNavigation.Note;
import domainBottomNavigation.Callback;
import domainBottomNavigation.Dependencies;

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

        getParentFragmentManager()
                .setFragmentResultListener(AddNoteBottomSheetDialogFragment.KEY_RESULT, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                        Note note = result.getParcelable(AddNoteBottomSheetDialogFragment.ARG_NOTE);//получили заметку
                        //теперь нужно после того как добавил перерисовать ее и отобразить (обновить коллекцию) она внутри адаптера -->
                        int index = notesAdapter.addNote(note);

                        notesAdapter.notifyItemInserted(index); //говорим обнови ставку эдемента оп такой-то позиции


                    }
                });


        ProgressBar progressBar = view.findViewById(R.id.progressBar);//крутилка
        progressBar.setVisibility(view.VISIBLE);

//кнопка добавления заметок -->
        view.findViewById(R.id.floating_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AddNoteBottomSheetDialogFragment()
                        .show(getParentFragmentManager(), "uiBottomNavigation.AddNoteBottomSheetDialogFragment");

            }
        });


        Dependencies.NOTES_REPOSITORY_NAVIGATION.getAllNuv(new Callback<List<Note>>() { // запросили получение списка заметок
            @Override
            public void onSuccess(List<Note> data) {
                notesAdapter.setData(data);

                notesAdapter.notifyDataSetChanged();//говорим адаптеру что данные изменились, процессор перерисовки запускается и рисуется новый список
                // я понял что экран вниз пролистал появляются новые к примеру как тут список заметок и это обеспечивает менеенагруженность системы приложения

                progressBar.setVisibility(view.GONE);//крутилка
            }

            @Override
            public void onError(Throwable exception) {


                progressBar.setVisibility(view.GONE);

            }
        });


    }


}
