package fmNotification;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        super(R.layout.fragment_notification);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//region  snack_bar

        view.findViewById(R.id.snack_bar).setOnClickListener(new View.OnClickListener() {
            //Snackbar хмл view всегда обворачивай в CoordinatorLayout чтобы работал свайп
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "SnackBar", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Button", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(requireContext(), "сюда можно что то прилепить", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
//endregion

//region dialog

        view.findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//вызываем с app.compact библиотеки new AlertDialog.Builder()
                new AlertDialog.Builder(requireContext())
                        // указываем че мы хотим поместить в диалог и добавляем кнопки от 3х
                        .setTitle(R.string.Heading)
                        .setMessage("Вы действительно хотите выйти из приложения?")
                        .setIcon(R.drawable.camaro)
                        .setCancelable(false) // запрещает скрываться сообщению при нажатии за пределы диалога
                        .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), "Positive", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("negative", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), "negative", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("neutral", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), "neutral", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

//endregion

//region custom_dialog
        view.findViewById(R.id.custom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// создаем layout.custom_dialog
                View customTitle = getLayoutInflater().inflate(R.layout.custom_dialog, null);//преобразовал хмл во View
                View customDialogView = getLayoutInflater().inflate(R.layout.custom_dialog_view, null);
//затем вытащим из customDialogView текст который в хмл под id ( EditText )
                EditText editText = customDialogView.findViewById(R.id.edit_text);

                new AlertDialog.Builder(requireContext())
                        .setCustomTitle(customTitle) //можем запихать View (заголовок)
// создаем  layout.custom_dialog_View
                        .setView(customDialogView)
                        .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //и отобразил в тосте то что пользователь ввел
                                Toast.makeText(requireContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
//endregion

//region  dialog_list
        view.findViewById(R.id.dialog_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// CharSequence[] - в списке этот выбрать массив
                CharSequence[] items = {"1", "2", "3", "4"};

                new AlertDialog.Builder(requireContext())
                        .setTitle("Заголовок")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), items[i], Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
//принцип работы пользователь выбирает из списка элементов массива CharSequence[] items = {"1", "2", "3", "4"};
//при нажатии метод onClick передает этот эл-т в int i (public void onClick(DialogInterface dialogInterface, int i)
//и через Toast мы показываем( можно провести операцию с кодом вместо Toast)
// список автоматом скролится если сею сиятельству потребуется
        });
//endregion

//region dialog_single_choice
        view.findViewById(R.id.dialog_single_choice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] items = {"1", "2", "3", "4"};

                final int[] selected = {-1};//тут мы изначально поставили индекс которого нет в массиве типо нечего не выбрано

                new AlertDialog.Builder(requireContext())
                        .setSingleChoiceItems(items, selected[0], new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                selected[0] = i;//тут мы запомнили пользователский выбор когда нажали кнопку
                            }
                        })
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), items[selected[0]], Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }

        });
//endregion

//region dialog_multiple_choice
        view.findViewById(R.id.dialog_multiple_choice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] items = {"1", "2", "3", "4"};
                boolean[] selected = {false, false, false, false};

                new AlertDialog.Builder(requireContext())
                        .setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                selected[i] = b;
                            }
                        })
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(requireContext(), Arrays.toString(selected), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
//endregion

//region сохр-я состояние код находится в CustomViewDialogFragment - тут обработка нажатия на кнопку
//за пример взят custom_dialog
        view.findViewById(R.id.dialog_custom_dialog_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomViewDialogFragment.newInstance("Ну здорово)")//newInstance("Message") - передал из класса dialog_custom_dialog_fragment(java)
                        //так как добавлял сообщение в аргументы , а теперь вытаскиваю
                        .show(getChildFragmentManager(), "тег по которму можно найти");//getChildFragmentManager()
            }
        });


//endregion

    }
}
