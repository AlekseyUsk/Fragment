package ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;

import com.example.fragment.R;

import domain.Notes;

public class NotesDetailsFragment extends Fragment {


    private static final String ARG_NOTES = " ARG_NOTES";


    // передаем вьюшку когда готова xml(fragment_notes_details)
    public NotesDetailsFragment() {
        super(R.layout.fragment_notes_details);
    }

    private TextView title;
    private ImageView icon;
    private EditText date;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        icon = view.findViewById(R.id.icon);
        title = view.findViewById(R.id.title);
        date = view.findViewById(R.id.date);

        //  Notes note =  getArguments().getParcelable(ARG_NOTES);

        //  icon.setImageResource(note.getIcon());
        //  title.setText(note.getName());
        //  date.setText(note.getDate());

        getParentFragmentManager()
                .setFragmentResultListener(NotesListFragment.NOTES_CLICKED_KEY, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Notes note = result.getParcelable(NotesListFragment.SELECTED_NOTES);

                        showNotes(note);
                    }
                });
        if (getArguments() != null && getArguments().containsKey(ARG_NOTES)) {
            Notes note = getArguments().getParcelable(ARG_NOTES);
            showNotes(note);
        }

    }

    private void showNotes(Notes note) {
        title.setText(note.getName());
        icon.setImageResource(note.getIcon());
        date.getText();

    }
}
