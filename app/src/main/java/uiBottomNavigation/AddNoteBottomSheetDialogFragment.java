package uiBottomNavigation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fragment.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import domainBottomNavigation.Callback;
import domainBottomNavigation.Dependencies;
import domainBottomNavigation.Note;
//Выезжающаяся шторка снизу

public class AddNoteBottomSheetDialogFragment extends BottomSheetDialogFragment {

    protected static final String KEY_RESULT = "AddNoteBottomSheetDialogFragment_KEY_RESULT";
    protected static final String ARG_NOTE = "ARG_NOTE"; // передавать заметку

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_note_dialog_sheet_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText title = view.findViewById(R.id.title);
        EditText message = view.findViewById(R.id.message);

        Button btnSave = view.findViewById(R.id.save);//блокировка ввода

        view.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSave.setEnabled(false);
// добавляем заметку и сохраняем--->
                Dependencies.NOTES_REPOSITORY_NAVIGATION.addNoteNuv(title.getText(), message.getText(), toString(), new Callback<Note>() {
                    @Override
                    public void onSuccess(Note data) {
// добавляем в бандл и передаем --->
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(ARG_NOTE, data);

                        getParentFragmentManager().setFragmentResult(KEY_RESULT, bundle);
// выполнили Бтеперь это дело надо отловить в NotesBottomListFragment

                        btnSave.setEnabled(true);

                        dismiss();// закрытие шторки
                    }

                    @Override
                    public void onError(Throwable exception) {


                        btnSave.setEnabled(true);
                    }
                });

            }
        });
    }
}
