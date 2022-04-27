package uiBottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import uiBottomNavigation.InfoBottomFragment;
import uiBottomNavigation.NotesBottomListFragment;

public class MainActivityBottomNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_navigation);

// Проверка на null, в проитвном случае запускаем NotesBottomListFragment
      /*  if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.container, new NotesBottomListFragment())
                    .commit();
        }
        с этим куском кода просто вылетает приложение,зато теперь просто белый экран когда жму на
        bottom_action_nav (при нажатии на bottom_action_info - работает и открывается заглушка)  ???????????
*/

//  BottomNavigationView - НАВИГАЦИЯ ЭКРАНА ВНИЗУ
// Для BottomNavigationView обработчик нажатия нетипичный тут он (setOnItemSelectedListener)
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_action_info:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container_activity_bottom_navigation, new InfoBottomFragment())
                                .commit();

                        return true;

                    case R.id.bottom_action_nav:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container_activity_bottom_navigation, new NotesBottomListFragment())
                                .commit();

                        return true;
                }
                return false;
            }
        });


    }


}