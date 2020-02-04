package com.app.ernext.fragments.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.app.ernext.BaseFragment
import com.app.ernext.R
import com.app.ernext.adapter.FeaturedChefAdapter
import com.app.ernext.adapter.SlidingAdapter_dash
import com.app.ernext.fragments.chefdetails.ChefDetails
import com.app.ernext.fragments.home.model.FeaturedChefsModel
import com.app.ernext.others.Utils
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.ArrayList

class Homefragment : BaseFragment(), FeaturedChefAdapter.OnclickListener {

    private val IMAGES = arrayOf("http://weneedfun.com/wp-content/uploads/2015/10/Beautiful-Food-Photos-1.jpg", "http://www.indianfoodforever.com/images/indian-food-platter.jpg", "http://thekashmirwalla.com/wp-content/uploads/2015/04/209_1beef_kabobs1.jpg", "https://i.ytimg.com/vi/uDnd_C8Hkp8/maxresdefault.jpg")
    private val SLIDER_TITLE = arrayOf("Chinese", "Indian", "Korean", "American")
    private val list_featured_chefs = ArrayList<FeaturedChefsModel>()
    private val ImagesArray = ArrayList<String>()
    private val TitleArray = ArrayList<String>()

    companion object {
        const val CLASS_NAME = "Homefragment"
        fun newInstance(): Fragment {
            return Homefragment()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.home_fragment
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {

        init()
        createList()

        if (list_featured_chefs.size > 0) {
            val ca = FeaturedChefAdapter(context, list_featured_chefs, this)
            fc_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            fc_recycler_view.adapter = ca
        }
    }

    override fun initListeners() {

    }

    override fun onItemClickListener(buddy: FeaturedChefsModel?, imageView: ImageView?) {
        val userId = buddy!!.c_id
        Toast.makeText(context, userId, Toast.LENGTH_SHORT).show()
        Utils.replaceFragmentInActivityFadeAnimation(activity?.supportFragmentManager, ChefDetails.newInstance(),
                R.id.container, true, ChefDetails.CLASS_NAME)
    }


    private fun createList() {
        list_featured_chefs.clear()
        list_featured_chefs.add(FeaturedChefsModel("1", "Avik Sutar", "3.2", "120", "http://www.celebplasticsurgeryonline.com/wp-content/uploads/2016/02/Brad-Pitt-plastic-surgery-featured.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("2", "Prosenjit Paul", "3.2", "123", "http://www.celebplasticsurgeryonline.com/wp-content/uploads/2016/02/Brad-Pitt-plastic-surgery-featured.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("3", "Debarun Biswas", "5", "126", "http://www.contactmusic.com/images/feature-images/johnny-depp-2016-alice-uk-premiere-01-670-500.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("4", "Asadhul Haq", "4", "127", "http://www.oncologica.com/wp-content/uploads/2016/06/98892061_UNHCR-Josie-world-large_transZgEkZX3M936N5BQK4Va8RQJ6Ra64K3tAxfZq0dvIBJw.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("5", "Bilanjo Mukhrjee", "3", "345", "http://www.ansa.it/webimages/foto_large_ls_350/2016/1/13/fd13e7f6ca8fd863f91a2936cdd7f8d4.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("6", "Josh Doe", "3", "224", "http://www.fansofcinema.com/wp-content/uploads/2015/09/All-Upcoming-Films-of-Aamir-Khan-in-2015-2016-2017.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("7", "Sanjay Chowdhury", "2", "138", "http://www.stylerug.net/wp-content/uploads/2016/12/King-Khan.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("8", "Manish Madhukar", "4", "112", "https://cdn.techinasia.com/wp-content/uploads/2015/07/jackma.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("9", "Ankeekita", "5", "145", "http://image6.buzzintown.com/files/event/upload_82000/upload_original/414725-cooking-with-sanjeev-kapoor.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("10", "Anikita", "3", "167", "https://s3.amazonaws.com/b.assets.cmshanken.mshanken.com/foodarts/article/19497/THUMBNAIL/bemedaled-and-bemused-best-chef-and-best-guy-jos-andrs-is-a-winner-in-anyones-book.png"))
        list_featured_chefs.add(FeaturedChefsModel("11", "Sneha Singh", "4", "190", "http://asian-fusion.com/wp-content/uploads/2015/10/Srijith-Gopinathan.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("12", "Manish Singh", "3", "234", "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2013/08/Ajay-Devgan.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("13", "Rakesh Samanta", "3", "108", "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2013/08/Salman-Khan.jpg"))
        list_featured_chefs.add(FeaturedChefsModel("14", "Saikat Basu", "2", "190", "https://s-media-cache-ak0.pinimg.com/originals/bd/0e/b3/bd0eb380108a59dd5d5d4415da43c620.jpg"))
    }

    private fun init() {
        for (i in IMAGES.indices)
            ImagesArray.add(IMAGES[i])

        for (j in SLIDER_TITLE.indices)
            TitleArray.add(SLIDER_TITLE[j])

        // mPager = findViewById(R.id.pager) as ViewPager
        pager!!.adapter = SlidingAdapter_dash(context, ImagesArray, TitleArray)
        val NUM_PAGES = IMAGES.size
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