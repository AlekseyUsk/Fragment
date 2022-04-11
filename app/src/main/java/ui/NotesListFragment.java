package ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;

import java.util.List;

import domain.InMemoryNotesRepository;
import domain.Notes;
import ui.NotesDetailsActivity;

public class NotesListFragment extends Fragment {

    public static final String NOTES_CLICKED_KEY = "NOTES_CLICKED_KEY";
    public static final String SELECTED_NOTES = "SELECTED_NOTES";

//todo 1 - СОЗДАЕМ ЮФЙЧИК
// фрагмент теперь знает какой мы будем юайчик использовать
// далее создаем layout нажимая на fragment_notes_list(ui.NotesListFragment - это он же но по конвенции так пишут)
// затем контейнер,false - что мы не хотим к контейнеру циплятся автоматом

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);   // создал вьюшку в фрагменте

    }

//  todo 2 - после готовности юайчика вызываем метод onViewCreated и ищем наш контейнер

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Notes> notes = InMemoryNotesRepository.getINSTANCE(requireContext()).getAll();
        // обратившись к синглтону InMemoryNotesRepository и спрошу у него список заметок

        LinearLayout container = view.findViewById(R.id.container); // нашел контейнер у этого View
//todo 3 - прогоняем циклом по каждой заметки и создаем каждой заметки юайчик и добавляем в контейнер
//  при этом надо создать разметку(item_notes.xml) для каждой заметки.

        for (Notes note : notes) {

            View itemView = getLayoutInflater().inflate(R.layout.item_notes, container, false);

            itemView.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SELECTED_NOTES, note);
                        getParentFragmentManager()
                                .setFragmentResult(NOTES_CLICKED_KEY,bundle);
                    } else {
                        NotesDetailsActivity.show(requireContext(), note);
                    }
                }
            });

            ImageView icon = itemView.findViewById(R.id.icon);
            TextView title = itemView.findViewById(R.id.title);
            EditText date = itemView.findViewById(R.id.date);

            icon.setImageResource(note.getIcon());
            title.setText(note.getName());
            // date.setText(note.getDate());// ОШИБКА НУЛ!!!!

            container.addView(itemView);

            itemView.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SELECTED_NOTES, note);

                        getParentFragmentManager()
                                .setFragmentResult(NOTES_CLICKED_KEY, bundle);
                    } else {
                        NotesDetailsActivity.show(requireContext(), note);
                    }
                }

            });


        }
    }
}
