package com.deepth.pdkkld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.novikov.pdkkld.R;

import java.util.Random;



public class offline_j extends mymetods {
    public int  curplayer = 0, nomer=0, k, rn = 3;
    public static int arr[];
    public int inohodci[];
    public String ino_to_str;
    public static int kol;
    public static int MCount;
    public static int sp, sl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline);
        MCount = 0;
        kol = 5;
        sp = 0;
        sl = 0;
        Krasota();


        Button addrilo = (Button)findViewById(R.id.riloplus);
        addrilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    kol+=1;
                    SkolkoPchel(kol, v);
            }
            });



        Button removerilo = (Button)findViewById(R.id.rilominus);
        removerilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    kol-=1;
                    SkolkoPchel(kol, v);
            }
        });




        Button getrol = (Button)findViewById(R.id.poluchit);
        getrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Poluchka(arr, kol, nomer, v, ino_to_str);

                nomer+=1;
            }
        });




        Button datroli = (Button)findViewById(R.id.arrcreate);
        datroli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curplayer = 0;

                arr = null;
                inohodci = null;
                ino_to_str = "";
                arr = new int[kol];

                for (int i = 0; i < kol; i++) {
                    arr[i] = 0;
                }

                if (kol < 3)
                {
                    Toast.makeText(getApplicationContext(), "Еблан?", Toast.LENGTH_SHORT).show();
                    return;
                } else

                if (kol < 5)
                {
                    arr[0] = 1;
                    arr[1] = 2;
                    inohodci = new int[1];
                } else


                if ((kol > 4) && (kol < 7)) {
                    arr[0] = 1;
                    for (int i = 1; i < 3; i++) {
                        arr[i] = 2;
                    }
                    inohodci = new int[2];
                } else

                if (kol > 6) {
                    arr[0] = 1;
                    for (int i = 1; i < 4; i++) {
                        arr[i] = 2;
                    }
                    inohodci = new int[3];
                }


                Random rnd = new Random();
                for (int i = kol - 1; i > 0 ; i--) {
                    rn = i +1;
                    int j = rnd.nextInt(rn);
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

                 k = 0;
                for (int i = 0; i < kol; i++)
                {
                    if (arr[i] == 2)
                    {
                        inohodci[k] = i + 1;
                        ino_to_str += String.valueOf(inohodci[k]) + " ";
                        k++;

                    }
                }

                //Toast.makeText(getApplicationContext(), ino_to_str, Toast.LENGTH_SHORT).show();

                nomer = 0;
                Toast.makeText(getApplicationContext(), "Лопаты выданны", Toast.LENGTH_SHORT).show();
            }
        });


        Button gogame = (Button)findViewById(R.id.gotogame);
        gogame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_j.this, offline_vibor_j.class);
                startActivity(intent);
                finish();
            }
        });


        Button back = (Button)findViewById(R.id.tomain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_j.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public int getKol()
    {
        return kol;
    }

}