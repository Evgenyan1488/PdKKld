package com.deepth.pdkkld;

import android.text.GetChars;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.novikov.pdkkld.R;

import java.util.Random;
public abstract class mymetods extends AppCompatActivity
{


    public boolean NumCheck(int num, int kol, TextView nomerok, TextView hueta)
    {
        if (num > kol)
        {
            nomerok.setVisibility(View.GONE);
            hueta.setText(getString(R.string.ahuel));
            hueta.setTextSize(40);
            return false;
        }else if (num == kol)
        {
            nomerok.setVisibility(View.GONE);
            hueta.setText(getString(R.string.ahuel));
            hueta.setTextSize(40);
            return true;
        }else
        return true;
    }


    public void SkolkoPchel(int kol, View view)
    {
        if (kol < 5) {

            Snackbar.make(view, kol + " пчелы", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            //Toast.makeText(getApplicationContext(), kol + " пчелы", Toast.LENGTH_SHORT).show();
        }else
            Snackbar.make(view, kol + " пчол", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            //Toast.makeText(getApplicationContext(), kol + " пчол", Toast.LENGTH_SHORT).show();
    }


    public void Krasota()
    {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void Poluchka(int []arr, int kol, int nomer, View view, String spisok)
    {
        if(nomer >= kol)
        {
            Snackbar.make(view, "Куда ты лезешь мексиканец?", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            //Toast.makeText(getApplicationContext(),  "Куда ты лезешь мексиканец?", Toast.LENGTH_SHORT).show();
        } else


        if(arr[nomer] == 0) {
            Snackbar.make(view, "Бархатный , " + "номер - " +  String.valueOf(nomer+1), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            //Toast.makeText(getApplicationContext(),  "Бархатный , " + "номер - " +  String.valueOf(nomer+1), Toast.LENGTH_SHORT).show();
        } else

        if(arr[nomer] == 2) {
            Snackbar.make(view, "Иноходец," + "номер - " +  String.valueOf(nomer+1), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            //Toast.makeText(getApplicationContext(),  "Иноходец," + "номер - " +  String.valueOf(nomer+1), Toast.LENGTH_SHORT).show();
        } else

        if(arr[nomer] == 1) {
            Snackbar.make(view, "Скоттиш-фолд, " + "номер " +  String.valueOf(nomer+1) + " Список: " + spisok, Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();

            //Toast.makeText(getApplicationContext(),  "Скоттиш-фолд, " + "номер " +  String.valueOf(nomer+1), Toast.LENGTH_SHORT).show();
        }

    }


}
