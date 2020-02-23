package com.app.ernext.fragments.deals.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.ernext.R;
import com.app.ernext.fragments.menus.model.MenusDeals;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avik on 11-01-2017.
 */

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.MyViewHolder> {

    private List<MenusDeals> countryList;
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
        TextView tv_productname, tv_itemtype,tv_checfname;
        ProgressBar progressbar;
        RelativeLayout card_view;

        public MyViewHolder(View view) {
            super(view);
            iv_chefimage = (ImageView) view.findViewById(R.id.iv_product);
            tv_productname = (TextView) view.findViewById(R.id.tv_productname);
            tv_itemtype = (TextView) view.findViewById(R.id.tv_itemtype);
            tv_checfname = (TextView) view.findViewById(R.id.tv_checfname);
            progressbar = (ProgressBar) view.findViewById(R.id.progressbar);
            card_view =  view.findViewById(R.id.card_view);
        }
    }

    public DealAdapter(Context mContext, List<MenusDeals> countryList, ChefIdAdapter chefIdAdapter) {
        this.mContext = mContext;
        this.countryList = countryList;
        this.chefIdAdapter=chefIdAdapter;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MenusDeals c = countryList.get(position);
        holder.tv_checfname.setText(c.getC_name());
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart, parent, false);
        return new MyViewHolder(v);
    }
}
