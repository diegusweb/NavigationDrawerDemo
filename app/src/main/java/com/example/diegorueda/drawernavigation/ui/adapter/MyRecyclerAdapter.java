package com.example.diegorueda.drawernavigation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diegorueda.drawernavigation.R;
import com.example.diegorueda.drawernavigation.model.FeedItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HP on 03/09/2015.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.FeedListRowHolder> {


    private List<FeedItem> feedItemList;

    private Context mContext;

    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public FeedListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, null);
        FeedListRowHolder mh = new FeedListRowHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(FeedListRowHolder feedListRowHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(feedListRowHolder.thumbnail);

        feedListRowHolder.title.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }



    public class FeedListRowHolder extends RecyclerView.ViewHolder {
        protected ImageView thumbnail;
        protected TextView title;

        public FeedListRowHolder(View view) {
            super(view);
            this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            this.title = (TextView) view.findViewById(R.id.title);
        }

    }
}