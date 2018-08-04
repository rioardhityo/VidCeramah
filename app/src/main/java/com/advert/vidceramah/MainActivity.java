package com.advert.vidceramah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button u1,u2,u3,u4,u5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u1 = (Button)findViewById(R.id.utd1);
        u2 = (Button)findViewById(R.id.utd2);
        u3 = (Button)findViewById(R.id.utd3);
        u4 = (Button)findViewById(R.id.utd4);
        u5 = (Button)findViewById(R.id.utd5);

        u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usv1();
            }
        });

        u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usv2();
            }
        });

        u3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usv3();
            }
        });

        u4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usv4();
            }
        });

        u5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usv5();
            }
        });

    }



    public void usv1(){
        Intent intent = new Intent(this, ustadSatu.class);
        startActivity(intent);
    }


    public void usv2(){
        Intent intent = new Intent(this, ustadDua.class);
        startActivity(intent);
    }


    public void usv3(){
        Intent intent = new Intent(this, ustadTiga.class);
        startActivity(intent);
    }

    public void usv4(){
        Intent intent = new Intent(this, ustadEmpat.class);
        startActivity(intent);
    }

    public void usv5(){
        Intent intent = new Intent(this, ustadLima.class);
        startActivity(intent);
    }
}
