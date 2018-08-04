package com.advert.vidceramah;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class itemlist extends RecyclerView.Adapter<itemlist.itemHolder> {

    Context konteks;
    List<Item> listvideo;

    public itemlist(Context konteks, List<Item> listvideo) {
        this.konteks = konteks;
        this.listvideo = listvideo;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemlist, parent, false);
        itemHolder objek = new itemHolder(v);
        return objek;
    }
    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        holder.judul.setText(listvideo.get(position).getSnippet().getTitle());
        Picasso.get().load(listvideo.get(position).getSnippet().getThumbnails().getHigh().getUrl()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return listvideo.size();
    }

    public static class itemHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView judul;
        ImageView thumbnail;
        public itemHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView);
            judul = (TextView)itemView.findViewById(R.id.judulceramah);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

}
