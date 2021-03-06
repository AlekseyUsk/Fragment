package ui;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

import fm.MyFragmentInfo2;
import fm.MyFragmentInfo3;
import fm.MyNotesFragmentList;
import fm.MyFragmentMenuActivity2;

public class MainActivity2 extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.image_notes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.image_notes:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_mainActivity2, new MyFragmentInfo2())
                                .commit();
                }
            }
        });
        findViewById(R.id.image_notes_nissan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.image_notes_nissan:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_mainActivity2, new MyFragmentInfo3())
                                .commit();
                }
            }
        });
        findViewById(R.id.btn_array_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_array_list:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_mainActivity2, new MyNotesFragmentList())
                                .commit();
                }
            }
        });
    }

    //region ?????????????? ?? ???????? ???????????? ?????? ?????????????? ???? select_fragment_activity2 ???????????????? ???????????????? ?? ?????????????????????? ????????
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity2:
                Toast.makeText(this, "open menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_fragment_activity2:
                Toast.makeText(this, "select_fragment_activity", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.container_mainActivity2, new MyFragmentMenuActivity2())
                        .commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //endregion

}

