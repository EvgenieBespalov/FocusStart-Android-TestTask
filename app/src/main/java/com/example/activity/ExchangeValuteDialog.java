package com.example.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import models.Valute;

public class ExchangeValuteDialog extends DialogFragment {

    private Valute valutes;

    ExchangeValuteDialog(Valute valutes)
    {
        this.valutes = valutes;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

        return dialog.setTitle("Информация о валюте")
                .setMessage("Цифровой код: " + valutes.getNumCode() +
                        "\nБуквенный код: " + valutes.getCharCode() +
                        "\nНоминал: " + valutes.getNominal() +
                        "\nНазвание: " + valutes.getName() +
                        "\nКурс: " + valutes.getValue() +
                        "\nПрошлый курс: " + valutes.getPrevious())
                .setNegativeButton("Закрыть", null)
                .create();
    }


}
