package com.app.ernext.adapter;

import android.content.Context;
import android.os.Parcelable;
import androidx.viewpager.widget.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.app.ernext.R;
import com.app.ernext.home.DashboardModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONU on 29/08/15.
 */
public class SlidingAdapter_dash extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;
    ProgressBar progressbar;
    List<DashboardModel.BannerRow> bannerRow;

    public SlidingAdapter_dash(Context context, List<DashboardModel.BannerRow> bannerRow) {
        this.context = context;
        this.bannerRow=bannerRow;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return bannerRow.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {

        View imageLayout = inflater.inflate(R.layout.slider_img_dash, view, false);
        //assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
        final ProgressBar progressbar = (ProgressBar) imageLayout.findViewById(R.id.progressbar);
        TextView tv_title=(TextView) imageLayout.findViewById(R.id.tv_title);
        TextView tv_subtitle=(TextView) imageLayout.findViewById(R.id.tv_subtitle);

        tv_subtitle.setText(bannerRow.get(position).getBannerSubtext());
        tv_title.setText(bannerRow.get(position).getBannerText());
        progressbar.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);
        final ProgressBar progressView = progressbar;
        Picasso.with(context)
                .load(bannerRow.get(position).getBannerImgsrc())
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        progressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        progressView.setVisibility(View.GONE);
                    }
                });

    view.addView(imageLayout,0);


    return imageLayout;
}

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
