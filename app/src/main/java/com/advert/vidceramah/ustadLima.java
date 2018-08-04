package com.advert.vidceramah;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ustadLima extends AppCompatActivity {

    String url;
    RecyclerView rv;
    List<Item> datanya1 = new ArrayList<>();
    itemlist adapter;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustad_satu);
        rv = (RecyclerView) findViewById(R.id.rv);
        parsingData("Hawariyyun terbaru 2018");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        //Progress Dialog memperlihatkan proses
        pd = new ProgressDialog(this);
        pd.setMessage("Sedang mengambil data...");
        pd.setTitle("Pesan");
        pd.setCanceledOnTouchOutside(false);
        pd.show();

    }

    private void parsingData(String types) {
        //Url google place API
        url = "https://www.googleapis.com/youtube/v3/search?q="+types+"&%20maxResults=25%20&part=snippet%20&key=AIzaSyB0luV4VOOR4M694PeUfJs5WFPmiSTsQTI";

        //Mengambil data dari google place API (Parsing JSON)
        SampleAPI.Factory.getIstance(ustadLima.this).getData(url).enqueue(new Callback<ModelVid>() {
            @Override
            public void onResponse(Call<ModelVid> call, Response<ModelVid> response) {
                if (response.isSuccessful()) {
                    datanya1 = response.body().getItems();
                    adapter = new itemlist(ustadLima.this, datanya1);
                    rv.setAdapter(adapter);
                    rv.invalidate();
                    pd.dismiss();
                    //Toast.makeText(ustadLima.this, "Say Hello to papa !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ustadLima.this, "Kenapa bro : " + response.message() + response.errorBody(), Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, "Whats Wrong ? : "+datanya.get(0).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelVid> call, Throwable t) {
                //pd.dismiss();
                Toast.makeText(ustadLima.this, "Error : " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("Error", t.getMessage());
            }
        });
    }
}
