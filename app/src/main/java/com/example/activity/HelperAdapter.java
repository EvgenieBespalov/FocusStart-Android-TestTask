package com.example.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {
    MainData data;
    Context context;
    List<Valute> listValutes;

    public HelperAdapter(MainData data, Context context) {
        this.data = data;
        this.listValutes = new ArrayList<>(data.valutes.values());
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        MyViewClass myViewClass = new MyViewClass(view);
        return myViewClass;
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewClass holder, int position) {
        holder.name.setText(listValutes.get(position).getName());
        holder.nominal.setText(listValutes.get(position).getNominal().toString());
        holder.value.setText(listValutes.get(position).getValue().toString());
        holder.setValutes(listValutes.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float exchangeRubles = listValutes.get(position).getValue(); //за сколько рублей дают валюту
                Float realExchange = exchangeRubles/listValutes.get(position).getNominal(); //за один рубль дают
                holder.value.setText(Float.toString(realExchange * Float.parseFloat(holder.nominal.getText().toString())));
                Toast.makeText(context,"Валюта конвертирована",Toast.LENGTH_LONG).show();
            }
        });
    }

    public class MyViewClass extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        EditText nominal;
        TextView value;
        Button btnExchangeValute;
        Valute valutes;

        public MyViewClass(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            nominal = itemView.findViewById(R.id.nominal);
            value = itemView.findViewById(R.id.value);

            btnExchangeValute = itemView.findViewById(R.id.btnExchangeValute);
            btnExchangeValute.setOnClickListener(this);
        }

        @Override
        public void onClick(@NonNull View itemView) {
            ExchangeValuteDialog dialog = new ExchangeValuteDialog(valutes);
            dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "custom");
        }

        public void setValutes(Valute valutes){ this.valutes = valutes; }
    }

    @Override
    public int getItemCount() {
        return data.valutes.size();
    }

}