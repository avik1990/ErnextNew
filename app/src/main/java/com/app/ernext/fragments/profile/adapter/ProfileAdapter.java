package com.app.ernext.fragments.profile.adapter;

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
import com.app.ernext.fragments.menus.model.ProfileMenus;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avik on 11-01-2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    private List<ProfileMenus> countryList;
    Context mContext;
    ChefIdAdapter chefIdAdapter;
    /**
     * View holder class
     */

    public interface ChefIdAdapter{
         void onClickChefIdAdapter(String id);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_productname,tv_checfname;
        RelativeLayout card_view;

        public MyViewHolder(View view) {
            super(view);
            tv_productname = view.findViewById(R.id.tv_productname);
            card_view =  view.findViewById(R.id.card_view);
        }
    }

    public ProfileAdapter(Context mContext, List<ProfileMenus> countryList, ChefIdAdapter chefIdAdapter) {
        this.mContext = mContext;
        this.countryList = countryList;
        this.chefIdAdapter=chefIdAdapter;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ProfileMenus c = countryList.get(position);
        holder.tv_productname.setText(c.getC_name());
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile, parent, false);
        return new MyViewHolder(v);
    }
}
