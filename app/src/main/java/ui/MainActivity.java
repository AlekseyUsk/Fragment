package ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragment.R;
import com.google.android.material.navigation.NavigationView;


import fm.MyFragmentInfo3;
import fmNotification.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    Button buttonSelect; // кнопка переклюения на MainActivity2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//region Menu Drawer ( ШТОРКА )

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);// для закрытия шторки использовал в меню

        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_auto:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new NotesListFragment())
                                .commit();

                        drawerLayout.closeDrawer(navigationView); //закрытие шторки
                        return true;

                    case R.id.action_notes:
                        getSupportFragmentManager().popBackStack();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new MyFragmentInfo3())
                                .commit();

                        return true;
                }
                return false;
            }

        });

//endregion

    }

    //region переключение на MainActivity2
    public void Selected(View view) {
        switch (view.getId()) {
            case R.id.ButtonSelect:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
        }
    }
//endregion

//region Menu Toolbar ( MainActivity )

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity:
                Toast.makeText(this, "open menu", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new NotificationFragment())
                        .commit();
                break;
            case R.id.menu_activity_search:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//endregion

}