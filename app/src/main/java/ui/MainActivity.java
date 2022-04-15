package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.R;

public class MainActivity extends AppCompatActivity {
    Button buttonSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Selected(View view) {
        switch (view.getId()) {
            case R.id.ButtonSelect:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
        }
    }

}