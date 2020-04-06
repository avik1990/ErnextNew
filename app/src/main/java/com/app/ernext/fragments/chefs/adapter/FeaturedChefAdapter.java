package com.app.ernext.fragments.chefs.adapter;

import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.ernext.R;
import com.app.ernext.fragments.chefs.model.FeaturedChefs;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avik on 11-01-2017.
 */

public class FeaturedChefAdapter extends RecyclerView.Adapter<FeaturedChefAdapter.MyViewHolder> {

    private List<FeaturedChefs> countryList;
    Context mContext;
    ChefIdAdapter chefIdAdapter;
    /**
     * View holder class
     */

    public interface ChefIdAdapter{
         void onClickChefIdAdapter(String id);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_chefimage;
        TextView tv_checfname, tv_likes;
        RatingBar rt_chef;
        ProgressBar progressbar;
        CardView card_view;


        public MyViewHolder(View view) {
            super(view);
            iv_chefimage = (ImageView) view.findViewById(R.id.iv_chefimage);
            tv_checfname = (TextView) view.findViewById(R.id.tv_checfname);
            tv_likes = (TextView) view.findViewById(R.id.tv_likes);
            rt_chef = (RatingBar) view.findViewById(R.id.rt_chef);
            progressbar = (ProgressBar) view.findViewById(R.id.progressbar);
            card_view = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public FeaturedChefAdapter(Context mContext, List<FeaturedChefs> countryList,ChefIdAdapter chefIdAdapter) {
        this.mContext = mContext;
        this.countryList = countryList;
        this.chefIdAdapter=chefIdAdapter;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final FeaturedChefs c = countryList.get(position);
        holder.tv_checfname.setText(c.getC_name());
        holder.tv_likes.setText(String.valueOf(c.getC_likes()));
        holder.rt_chef.setRating(Float.parseFloat(c.getC_rates()));
        holder.progressbar.setVisibility(View.VISIBLE);
        holder.iv_chefimage.setVisibility(View.VISIBLE);
        final ProgressBar progressView = holder.progressbar;
        Picasso.with(mContext)
                .load(c.getC_images())
                .into(holder.iv_chefimage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        progressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chefIdAdapter.onClickChefIdAdapter(c.getC_id());
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("RV", "Item size [" + countryList.size() + "]");
        return countryList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listbar_featured_chefs, parent, false);
        return new MyViewHolder(v);
    }
}
