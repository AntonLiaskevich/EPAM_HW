package com.example.user.epam_hw;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class InputSrudent extends DialogFragment {

    public static final String STUDENT_ID = "student id";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String HOMEWORK_COUNT = "homework count";
    public static final String TAG = "tag";

    public static final String EDIT_STUDENT_TAG = "Edit student";
    public static final String ADD_STUDENT_TAG = "Add student";
    private static final String EXCEPTION_MESSAGE = "exception";

    private EditText editName;
    private EditText editHomeworkCount;
    private InputDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.student_input, null);

        builder.setView(view)
                .setTitle(R.string.title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent();

                        if (getTag().equals(EDIT_STUDENT_TAG)) {
                            intent.putExtra(ID, getArguments().getLong(STUDENT_ID));
                        }

                        intent.putExtra(NAME, editName.getText().toString());
                        intent.putExtra(HOMEWORK_COUNT, Integer.valueOf(editHomeworkCount.getText().toString()));
                        intent.putExtra(TAG, getTag());

                        listener.applyDialogInfo(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        editName = view.findViewById(R.id.name_edit_text);
        editHomeworkCount = view.findViewById(R.id.hw_count_edit_text);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (InputDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + EXCEPTION_MESSAGE);
        }
    }

    public interface InputDialogListener {
        void applyDialogInfo(Intent intent);
    }
}