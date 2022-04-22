package fmNotification;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment.R;

// унаследуемся на от Fragment, а от DialogFragment
public class CustomViewDialogFragment extends DialogFragment {
    //region передача аргумента через Arguments
//todo 1е передаем например сообщение через Arguments
    private static final String ARG_MESSAGE = "ARG_MESSAGE"; // передаваемый аргумент сообщения

    //todo 2e помещаем в Arguments сообщение
    public static CustomViewDialogFragment newInstance(String message) {//например мы передадим какое то сообщение String message

//передача аргумента через Arguments
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);//и потом мы его передаем через ключ значение
        CustomViewDialogFragment fragment = new CustomViewDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    // затем что бы сохр состояние мы переопределяем метод onCreateDialog
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View customTitle = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        View customDialogView = getLayoutInflater().inflate(R.layout.custom_dialog_view, null);
        EditText editText = customDialogView.findViewById(R.id.edit_text);
// и потом мы берем то что передали и вытаскиваем то что положили
//todo 3e достаем сообщение из аргументов
        String message = getArguments().getString(ARG_MESSAGE);
        editText.setText(message);


        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext())//добавил AlertDialog.Builder builder =
                .setCustomTitle(customTitle)
                .setView(customDialogView)
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(requireContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();//вместо show() выставил return builder.create()
    }
}
//любой из диалогов прописываешь во фрагмент данный момент мы вставили из custom_dialog(скопировали)
//затем идешь в тот класс где управление нажатием кнопки и вызова этого колдунства