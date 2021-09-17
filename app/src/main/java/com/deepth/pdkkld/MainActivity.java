package com.deepth.pdkkld;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import com.novikov.pdkkld.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends mymetods {

    private  void  ShowRegWindow()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Введи кличку");
        dialog.setMessage("По братски");
        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register, null);
        dialog.setView(register_window);
        MaterialEditText pogonyalo = register_window.findViewById(R.id.name);
    }

    boolean hostcheck = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //NavController navController = Navigation.findNavController(this, R.id.fragment);

       Krasota();


        Button offline = (Button)findViewById(R.id.offline);
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, offline_j.class);
                startActivity(intent);
                finish();
            }
        });



        Button bmyach = (Button)findViewById(R.id.buttonmyach);
        bmyach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hostcheck) {
                    ShowRegWindow();
                }
            }
        });


        /*Button bmyach = (Button)findViewById(R.id.buttonmyach);
        bmyach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, futbol_j.class);
                startActivity(intent);
                finish();
            }
        });*/



        Button bhost = (Button)findViewById(R.id.buttonhost);
        bhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, zabil_j.class);
                startActivity(intent);
                finish();
            }
        });



       /* Button bhost = (Button)findViewById(R.id.buttonhost);
        bhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_mainActivity2_to_huiznaetchedalshe_j2);
            }
        });*/



        //Button bmyach = (Button)findViewById(R.id.buttonmyach);
       // bmyach.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainActivity2_to_futbol_j2, null));

       // Button bmyach = (Button)findViewById(R.id.buttonmyach);
        //bmyach.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainActivity_to_futbol2, null));


        };





    }

