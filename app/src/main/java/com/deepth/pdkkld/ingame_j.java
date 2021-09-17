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
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.novikov.pdkkld.R;


public class ingame_j extends mymetods {

    int palecstate = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ingame);


       Krasota();



        FirebaseDatabase myDatabase;
        myDatabase = FirebaseDatabase.getInstance();

        DatabaseReference Nref = myDatabase.getReference("Palec");    Nref.child("palchik").setValue(palecstate);





        Button nagadit = (Button)findViewById(R.id.gadost);
        nagadit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palecstate = 1;
                Nref.child("palchik").setValue(palecstate);
            }
        });





        Nref.child("palchik").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                palecstate = Integer.parseInt(snapshot.getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });



        Button goend = (Button)findViewById(R.id.endpohod);
        goend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (palecstate == 1) {
                    Intent intent = new Intent(ingame_j.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),  "Ебануло)))))", Toast.LENGTH_SHORT).show();
                    finish();
                } else if (palecstate == 0) {
                    Intent intent = new Intent(ingame_j.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),  "Не ебануло)", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });

    }
}