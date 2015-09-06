package com.example.diegorueda.drawernavigation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diegorueda.drawernavigation.R;
import com.example.diegorueda.drawernavigation.model.AndroidVersion;
import com.example.diegorueda.drawernavigation.model.Country;
import com.example.diegorueda.drawernavigation.model.CountryTemp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 04/09/2015.
 */
public class ContryAdapter extends RecyclerView.Adapter<ContryAdapter.HypedArtistViewHolder>{

    List<AndroidVersion> androidVersionsLists = new ArrayList<>();
    public ContryAdapter(Context context) {

    }

    public void addAndroidVersions(List<AndroidVersion> androidVersionsList){
        Log.d("DiegoResult:", "addAndroidVersions - " + androidVersionsList.size());
        this.androidVersionsLists.addAll(androidVersionsList);
        notifyDataSetChanged();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        Log.d("DiegoResult:", "onCreateViewHolder -> "+androidVersionsLists.size());
        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        //primero ver en que posicion estamos
        //Country currentArtist = artists.get(position);
        //poner un nombre
        Log.d("DiegoResult:", "onBindViewHolder"+androidVersionsLists.size());
        holder.bind(androidVersionsLists.get(position));
    }

    @Override
    public int getItemCount() {
        return androidVersionsLists.size();
    }


    public class HypedArtistViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.fthumbnail);

        }

        public void bind(AndroidVersion androidVersion){
            this.textView.setText(androidVersion.getTitre());
            Picasso.with(imageView.getContext()).load(androidVersion.getUrl()).into(imageView);

        }


    }
}
