package com.deepth.pdkkld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.novikov.pdkkld.R;


public class eshe_ekran extends mymetods {
    public int buff, curplayer, nomer;
    public int arr[], arrzapasa[] = new int[10];
    public String k;
    public String ino_to_str = " ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.futbol);

        Krasota();



        FirebaseDatabase myDatabase;
        myDatabase = FirebaseDatabase.getInstance();

        DatabaseReference Nref = myDatabase.getReference("Nomer");    Nref.child("num").setValue(nomer);

        DatabaseReference ref = myDatabase.getReference("Roli");





        Button getrol = (Button)findViewById(R.id.poluchit);
        getrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Poluchka(arrzapasa, 10, nomer, v, ino_to_str);
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

        Button gogame = (Button)findViewById(R.id.gotogame);
        gogame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(eshe_ekran.this, ingame_j.class);
                startActivity(intent);
                finish();
            }
        });

    }

}