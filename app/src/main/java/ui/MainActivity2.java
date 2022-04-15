package ui;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;

import fm.MyFragmentInfo;
import fm.MyFragmentInfo2;
import fm.MyFragmentInfo3;

public class MainActivity2 extends AppCompatActivity {

    Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn_notes_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_notes_info:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_mainActivity2, new MyFragmentInfo())
                                .commit();
                }
            }
        });
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
    }
}

