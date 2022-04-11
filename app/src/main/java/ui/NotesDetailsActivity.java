package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.fragment.R;

import domain.Notes;

public class NotesDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_NOTES = "EXTRA_NOTES";

    public static void show(Context context, Notes note){
        Intent intent = new Intent(context,NotesDetailsActivity.class);
        intent.putExtra(EXTRA_NOTES,note);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);

        if(savedInstanceState == null){

          Notes note = getIntent().getParcelableExtra(EXTRA_NOTES);

          NotesDetailsFragment notesDetailsFragment = new NotesDetailsFragment();
          // new.Instance(note) как на уроке не ставиться горит крассным ! ОШИБКА Я НЕ ЗНАЮ ПОЧЕМУ?

          getSupportFragmentManager()
                  .beginTransaction()
                  .replace(R.id.container,notesDetailsFragment)
                  .commit();
        }
    }
}