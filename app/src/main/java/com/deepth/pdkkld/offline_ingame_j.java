package com.deepth.pdkkld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.novikov.pdkkld.R;
import org.w3c.dom.Text;


import static com.deepth.pdkkld.offline_vibor_j.komanda;
import static com.deepth.pdkkld.offline_j.kol;
import static com.deepth.pdkkld.offline_j.arr;
import static com.deepth.pdkkld.offline_j.MCount;
import static com.deepth.pdkkld.offline_j.sp;
import static com.deepth.pdkkld.offline_j.sl;

public class offline_ingame_j extends mymetods {
    int nomer = 1;
    int palecstate = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Krasota();
        setContentView(R.layout.offline_ingame);


        TextView nomerok = findViewById(R.id.number);
        TextView textView = findViewById(R.id.hueta);



        Button nagadit = (Button)findViewById(R.id.gadost);
        nagadit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumCheck(nomer, kol, nomerok, textView)) {
                    if ((komanda[nomer - 1] == 1) && (arr[nomer - 1] == 2)) {
                        nomer += 1;
                        palecstate = 1;
                        nomerok.setText(String.valueOf(nomer));


                    } else
                        Toast.makeText(getApplicationContext(), " Ты кто такой сука, чтобы это делать?", Toast.LENGTH_SHORT).show();
                }
            }
        });




        Button propolzti = (Button)findViewById(R.id.negadost);
        propolzti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumCheck(nomer, kol, nomerok, textView)) {
                    nomer += 1;
                    nomerok.setText(String.valueOf(nomer));
                }
            }
        });




        Button mizinec = (Button)findViewById(R.id.mizinec);
        mizinec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumCheck(nomer, kol, nomerok, textView)) {
                    if ((MCount == 0) && (arr[nomer - 1] == 2) && (sp < 2))
                    {
                        palecstate = 1;
                        MCount = 1;
                        nomer += 1;
                        nomerok.setText(String.valueOf(nomer));
                    }else
                        Toast.makeText(getApplicationContext(), "Ты вообще ебло ахуевшее?", Toast.LENGTH_SHORT).show();
                }
            }
        });




        Button goend = (Button)findViewById(R.id.endpohod);
        goend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (palecstate == 1) {
                    Intent intent = new Intent(offline_ingame_j.this, offline_vibor_j.class);
                    sp += 1;
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),  "Коза заделанна", Toast.LENGTH_SHORT).show();
                    finish();
                } else if (palecstate == 0) {
                    Intent intent = new Intent(offline_ingame_j.this, offline_vibor_j.class);
                    sl += 1;
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),  "Проползший", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });


        Button back = (Button)findViewById(R.id.tomain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_ingame_j.this, offline_vibor_j.class);
                startActivity(intent);
                finish();
            }
        });
    }
}