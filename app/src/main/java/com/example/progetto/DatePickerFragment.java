package com.example.progetto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    private Calendar date;

    public static DatePickerFragment newInstance() {
        DatePickerFragment frag = new DatePickerFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final DatePicker datePicker = new DatePicker(getActivity());
        date = Calendar.getInstance();
        return new AlertDialog.Builder(getActivity())
                .setView(datePicker)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                date.set(Calendar.YEAR, datePicker.getYear());
                                date.set(Calendar.MONTH, datePicker.getMonth());
                                date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                                //((SignUp)getActivity()).updateDataDiNascita(date);
                                //((SignUp)getActivity()).doPositiveClick(date);
                            }
                        }
                )
                .setNegativeButton("Annulla",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //((SignUp)getActivity()).doNegativeClick();
                                dismiss();}
                        }
                )
                .create();
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}
