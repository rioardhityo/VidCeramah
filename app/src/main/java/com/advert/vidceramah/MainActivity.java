package com.advert.vidceramah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class MainActivity extends AppCompatActivity {

    Button u1,u2,u3,u4,u5;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u1 = (Button)findViewById(R.id.utd1);
        u2 = (Button)findViewById(R.id.utd2);
        u3 = (Button)findViewById(R.id.utd3);
        u4 = (Button)findViewById(R.id.utd4);
        u5 = (Button)findViewById(R.id.utd5);

        adView = new AdView(this, "YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();

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

        adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(MainActivity.this, "Error: " + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
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

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

}
