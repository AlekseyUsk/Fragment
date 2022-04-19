package fm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragment.R;

import java.util.zip.Inflater;

public class MyFragmentList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes_list = getResources().getStringArray(R.array.notes_list);
        for (String notes : notes_list) {
            TextView textView = new TextView(getContext());
            textView.setText(notes);
            textView.setTextSize(30);
            layoutView.addView(textView);  // ? неотображается на экране почему то список из ресурсов
        }

    }
}