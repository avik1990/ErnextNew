package com.app.ernext.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.ernext.R;
import com.app.ernext.fragments.home.model.FeaturedChefsModel;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Avik on 11-01-2017.
 */
public class FeaturedChefAdapter extends RecyclerView.Adapter<FeaturedChefAdapter.MyViewHolder> {

    private List<FeaturedChefsModel> countryList;
    Context mContext;
    private OnclickListener onclickListener;

    /**
     * View holder class
     */

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

    public FeaturedChefAdapter(Context mContext, List<FeaturedChefsModel> countryList, OnclickListener _onclickListener) {
        this.mContext = mContext;
        onclickListener = _onclickListener;
        this.countryList = countryList;
    }

    public interface OnclickListener {
        void onItemClickListener(FeaturedChefsModel buddy, ImageView imageView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final FeaturedChefsModel c = countryList.get(position);
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
               /* Intent a = new Intent(mContext, ActivityChefDetails.class);
                mContext.startActivity(a);*/
                if (onclickListener != null)
                    onclickListener.onItemClickListener(c, holder.iv_chefimage);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listbar_featured_chefs, parent, false);
        return new MyViewHolder(v);
    }


}
