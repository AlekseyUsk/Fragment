package uiCityList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {

    private String[] dataSource;
    // Передаём в конструктор источник данных
// В нашем случае это массив, но может быть и запрос к БД

    public CityListAdapter(String[] dataSource) {
        this.dataSource = dataSource;
        // Создать новый элемент пользовательского интерфейса

    }

    // Запускается менеджером
    @NonNull
    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Создаём новый элемент пользовательского интерфейса
// Через Inflater
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        // Здесь можно установить всякие параметры

        return new ViewHolder(v);

    }
    // Заменить данные в пользовательском интерфейсе
// Вызывается менеджером

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.ViewHolder viewHolder, int i) {
        // Получить элемент из источника данных (БД, интернет...)
// Вынести на экран, используя ViewHolder
        viewHolder.getTextView().setText(dataSource[i]);

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    // Этот класс хранит связь между данными и элементами View
// Сложные данные могут потребовать несколько View на один пункт списка
    //Класс ViewHolder хранит в себе пользовательские элементы, которые передаются в конструктор,
    //чтобы позже их заполнить данными
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        public TextView getTextView() {
            return textView;
        }


    }

}
//В конструкторе адаптера передаём источник данных. По нему будем строить список. Пока для
//простоты это будет массив строк, но также можно передавать список со сложной структурой,
//считываемый из базы данных.