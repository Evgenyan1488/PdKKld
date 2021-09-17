package com.deepth.pdkkld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.novikov.pdkkld.R;
import static com.deepth.pdkkld.offline_j.kol;
import static com.deepth.pdkkld.offline_j.sp;
import static com.deepth.pdkkld.offline_j.sl;

public class offline_vibor_j extends mymetods {

    static int[] komanda = new int[kol];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        Krasota();
        setContentView(R.layout.offline_vibor);


        TextView spidorov = findViewById(R.id.schetpidorov);
        TextView slohov = findViewById(R.id.schetlohov);
        spidorov.setText(String.valueOf(sp));
        slohov.setText(String.valueOf(sl));


        for (int i= 0; i < kol; i++)
            komanda[i] = 0;



        LinearLayout l3 = (LinearLayout) findViewById(R.id.c3);
        LinearLayout l4 = (LinearLayout) findViewById(R.id.c4);
        LinearLayout l5 = (LinearLayout) findViewById(R.id.g3);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        for (int i = 1; i <= kol; i++)
        {
            Button btn = new Button (this);
            btn.setText(String.valueOf(i));
            btn.setTextColor(getColor(R.color.white));
            btn.setTextSize(20);
            btn.setBackgroundResource(R.drawable.soyuz_nerushimiy);


            if (i < 5)
            l3.addView(btn, params);
            else l4.addView(btn, params);

            int finalI = i;


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                        komanda[finalI - 1] = 1;

                        Button butn = new Button(context);
                        butn.setText(String.valueOf(finalI));
                        butn.setTextColor(getColor(R.color.white));
                        butn.setTextSize(20);
                        butn.setBackgroundResource(R.drawable.soyuz_nerushimiy);
                        l5.addView(butn, params);


                        butn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                butn.setVisibility(View.GONE);
                                komanda[finalI - 1] = 0;
                            }
                        });
                }
            });
        }

        Button next = (Button)findViewById(R.id.gonext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_vibor_j.this, offline_ingame_j.class);
                startActivity(intent);
                finish();
            }
        });


        Button back = (Button)findViewById(R.id.tomain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_vibor_j.this, offline_j.class);
                startActivity(intent);
                finish();
            }
        });

    }
}