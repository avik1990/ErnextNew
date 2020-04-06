package com.app.ernext.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.app.ernext.BaseFragment
import com.app.ernext.R
import com.app.ernext.adapter.FeaturedChefAdapter
import com.app.ernext.adapter.SlidingAdapter_dash
import com.app.ernext.fragments.chefdetails.ChefDetails
import com.app.ernext.fragments.home.model.FeaturedChefsModel
import com.app.ernext.home.DashboardModel
import com.app.ernext.others.Constants
import com.app.ernext.others.Utils
import com.app.ernext.others.showToast
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.ArrayList

class Homefragment : BaseFragment(), FeaturedChefAdapter.OnclickListener {

    companion object {
        lateinit var bannerRow: List<DashboardModel.BannerRow>
        lateinit  var chefRow: List<DashboardModel.ChefRow>
        lateinit  var dishRow: List<DashboardModel.DishRow>
        const val CLASS_NAME = "Homefragment"

        fun newInstance(fromWhichFragment: String, bannerRow: List<DashboardModel.BannerRow>,chefRow: List<DashboardModel.ChefRow>,
                        dishRow: List<DashboardModel.DishRow>): Fragment {

            val bundle = Bundle()
            bundle.putString(Constants.Keys.KEY_FRAGMENT_NAME, fromWhichFragment)
            this.bannerRow=bannerRow
            this.chefRow=chefRow
            this.dishRow=dishRow
            bundle.putString(Constants.Keys.KEY_FRAGMENT_NAME, fromWhichFragment)
            val fragment = Homefragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.home_fragment
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {

        init()

        if (chefRow.size > 0) {
            val ca = FeaturedChefAdapter(context, chefRow, this)
            fc_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            fc_recycler_view.adapter = ca
        }
        //showToast(context!!,"BannerSize:" +bannerRow.size)
    }

    override fun initListeners() {

    }

    override fun onItemClickListener(buddy: FeaturedChefsModel?, imageView: ImageView?) {
        val userId = buddy!!.c_id
        Toast.makeText(context, userId, Toast.LENGTH_SHORT).show()
        Utils.replaceFragmentInActivityFadeAnimation(activity?.supportFragmentManager, ChefDetails.newInstance(),
                R.id.container, true, ChefDetails.CLASS_NAME)
    }

    private fun init() {

        pager!!.adapter = SlidingAdapter_dash(context, bannerRow)
        //val NUM_PAGES = bannerRow.size
        //Auto start of viewpager
        /*final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 9000, 9000);
    }*/
    }
}