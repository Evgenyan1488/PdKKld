package com.deepth.pdkkld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.novikov.pdkkld.R;

import java.util.Random;

public class zabil_j extends  mymetods  {
    public int kol = 5, buff, curplayer = 0, nomer=0, kl;
    public int arr[], arrzapasa[] = new int[10];
    public int inohodci[];
    public String ino_to_str = " ", k;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zabil);

        Krasota();



        FirebaseDatabase myDatabase;
        myDatabase = FirebaseDatabase.getInstance();
        DatabaseReference Kref = myDatabase.getReference("Kol-vo");   Kref.child("kolvo").setValue(kol);

        DatabaseReference Nref = myDatabase.getReference("Nomer");    Nref.child("num").setValue(nomer);

        DatabaseReference ref = myDatabase.getReference("Roli");




        Button addrilo = (Button)findViewById(R.id.riloplus);
        addrilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    kol+=1;
                    Kref.child("kolvo").setValue(kol);
                    SkolkoPchel(kol, v);
            }
            });



        Button removerilo = (Button)findViewById(R.id.rilominus);
        removerilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    kol-=1;
                    Kref.child("kolvo").setValue(kol);
                    SkolkoPchel(kol, v);
            }
        });




        Button getrol = (Button)findViewById(R.id.poluchit);
        getrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Poluchka(arrzapasa, kol, nomer, v, ino_to_str);

                nomer+=1;
                Nref.child("num").setValue(nomer);
            }
        });



        Nref.child("num").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                nomer = Integer.parseInt(snapshot.getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });



        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                buff = Integer.parseInt(snapshot.getValue().toString());
                curplayer = Integer.parseInt(snapshot.getKey());
                arrzapasa[curplayer]=buff;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







        Button datroli = (Button)findViewById(R.id.arrcreate);
        datroli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curplayer = 0;
                for (int i = 0; i < 10; i++) {
                    k = String.valueOf(i);
                    ref.child(k).removeValue();
                }
                arr = null;
                arrzapasa = null;
                //inohodci = null;
                //ino_to_str = "";

                arrzapasa = new int[kol];
                arr = new int[kol];

                for (int i = 0; i < kol; i++) {
                    arr[i] = 0;
                }
                if (kol < 3)
                {
                    Toast.makeText(getApplicationContext(), "Еблан?", Toast.LENGTH_SHORT).show();
                } else

                if (kol < 5)
                {
                    arr[0] = 1;
                    arr[1] = 2;
                } else


                if ((kol > 4) && (kol < 7)) {
                    arr[0] = 1;
                    for (int i = 1; i < 3; i++) {
                        arr[i] = 2;
                    }
                } else

                if (kol > 6) {
                    arr[0] = 1;
                    for (int i = 1; i < 4; i++) {
                        arr[i] = 2;
                    }
                }

                int rn = 3;
                Random rnd = new Random();
                for (int i = kol - 1; i > 0 ; i--) {
                    rn = i +1;
                    int j = rnd.nextInt(rn);
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

                /*kl = 0;
                for (int i = 0; i < kol; i++)
                {
                    if (arr[i] == 2)
                    {
                        inohodci[kl] = i + 1;
                        ino_to_str += String.valueOf(inohodci[kl]) + " ";
                        kl++;

                    }
                }*/

                for (int i = 0; i < kol; i++) {
                    k = String.valueOf(i);
                    ref.child(k).setValue(arr[i]);
                }


                nomer = 0;
                Nref.child("num").setValue(nomer);
                Toast.makeText(getApplicationContext(), "Обязанност обновленны", Toast.LENGTH_SHORT).show();
            }
        });

        Button gogame = (Button)findViewById(R.id.gotogame);
        gogame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(zabil_j.this, ingame_j.class);
                startActivity(intent);
                finish();
            }
        });
    }



}