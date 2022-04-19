package fm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.R;

public class MyFragmentMenuActivity2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true); //дает доступ фрагмента к меню Активити
        return inflater.inflate(R.layout.fragment_my_menu_activity2, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment, menu); // добавил во фрагмент меню
        MenuItem item = menu.findItem(R.id.select_fragment_activity2);
        // В этом методе мы получаем меню активити, находим нужную нам кнопку и просто прячем ее
        // в данный момент я спрятал кнопку select_fragment_activity2 в момент нажатия на нее
        if (item != null) {
            item.setVisible(false);

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}