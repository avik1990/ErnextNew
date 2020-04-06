package com.app.ernext.fragments.chefs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.app.ernext.BaseFragment
import com.app.ernext.R
import com.app.ernext.fragments.chefdetails.ChefDetails
import com.app.ernext.fragments.chefs.adapter.FeaturedChefAdapter
import com.app.ernext.fragments.chefs.model.FeaturedChefs
import com.app.ernext.others.Utils
import kotlinx.android.synthetic.main.chefs_fragment.*
import java.util.ArrayList

class FragmentChefs : BaseFragment(), View.OnClickListener, ChefsContract.View,FeaturedChefAdapter.ChefIdAdapter {


    private val list_featured_chefs = ArrayList<FeaturedChefs>()
    lateinit var mContext: Context

    override fun hideSearchBar() {
       // v_searchview.visibility = View.GONE
    }

    lateinit var chefsPresenter: ChefsPresenter

    companion object {
        const val CLASS_NAME = "FragmentChefs"
        fun newInstance(): Fragment {
            return FragmentChefs()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.chefs_fragment
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {
        mContext =activity!!
        createList()
    }

    private fun createList() {
        list_featured_chefs.add(FeaturedChefs("1", "Avik Sutar", "3.2", "120", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/5/005/03f/2db/07e99f3.jpg"))
        list_featured_chefs.add(FeaturedChefs("2", "Prosenjit Paul", "3.2", "123", "http://www.celebplasticsurgeryonline.com/wp-content/uploads/2016/02/Brad-Pitt-plastic-surgery-featured.jpg"))
        list_featured_chefs.add(FeaturedChefs("3", "Debarun Biswas", "5", "126", "http://www.contactmusic.com/images/feature-images/johnny-depp-2016-alice-uk-premiere-01-670-500.jpg"))
        list_featured_chefs.add(FeaturedChefs("4", "Asadhul Haq", "4", "127", "http://www.oncologica.com/wp-content/uploads/2016/06/98892061_UNHCR-Josie-world-large_transZgEkZX3M936N5BQK4Va8RQJ6Ra64K3tAxfZq0dvIBJw.jpg"))
        list_featured_chefs.add(FeaturedChefs("5", "Bilanjo Mukhrjee", "3", "345", "http://www.ansa.it/webimages/foto_large_ls_350/2016/1/13/fd13e7f6ca8fd863f91a2936cdd7f8d4.jpg"))
        list_featured_chefs.add(FeaturedChefs("6", "Josh Doe", "3", "224", "http://www.fansofcinema.com/wp-content/uploads/2015/09/All-Upcoming-Films-of-Aamir-Khan-in-2015-2016-2017.jpg"))
        list_featured_chefs.add(FeaturedChefs("7", "Sanjay Chowdhury", "2", "138", "http://www.stylerug.net/wp-content/uploads/2016/12/King-Khan.jpg"))
        list_featured_chefs.add(FeaturedChefs("8", "Manish Madhukar", "4", "112", "https://cdn.techinasia.com/wp-content/uploads/2015/07/jackma.jpg"))
        list_featured_chefs.add(FeaturedChefs("9", "Ankeekita", "5", "145", "http://image6.buzzintown.com/files/event/upload_82000/upload_original/414725-cooking-with-sanjeev-kapoor.jpg"))
        list_featured_chefs.add(FeaturedChefs("10", "Anikita", "3", "167", "https://s3.amazonaws.com/b.assets.cmshanken.mshanken.com/foodarts/article/19497/THUMBNAIL/bemedaled-and-bemused-best-chef-and-best-guy-jos-andrs-is-a-winner-in-anyones-book.png"))
        list_featured_chefs.add(FeaturedChefs("11", "Sneha Singh", "4", "190", "http://asian-fusion.com/wp-content/uploads/2015/10/Srijith-Gopinathan.jpg"))
        list_featured_chefs.add(FeaturedChefs("12", "Manish Singh", "3", "234", "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2013/08/Ajay-Devgan.jpg"))
        list_featured_chefs.add(FeaturedChefs("13", "Rakesh Samanta", "3", "108", "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2013/08/Salman-Khan.jpg"))
        list_featured_chefs.add(FeaturedChefs("14", "Saikat Basu", "2", "190", "https://s-media-cache-ak0.pinimg.com/originals/bd/0e/b3/bd0eb380108a59dd5d5d4415da43c620.jpg"))
    }


    override fun initListeners() {
        fc_recycler_view.layoutManager = GridLayoutManager(mContext, 2)
        val ca = FeaturedChefAdapter(mContext, list_featured_chefs,this)
        fc_recycler_view.adapter = ca
    }

    override fun onClick(v: View?) {
    }

    override fun showloader(showingStatus: Boolean) {
    }

    override fun goToNextPage() {
    }

    override fun isFragmentAlive(): Boolean {
        return true
    }

    override fun isActivityRunning(): Boolean {
        return true
    }

    override fun setPresenter(presenter: ChefsContract.Presenter) {
        chefsPresenter = presenter as ChefsPresenter
    }

    override fun isNetworkAvailable(): Boolean {
        return Utils.isConnectedToNetwork(this!!.activity!!)
    }

    override fun showNetworkUnavailableMsg() {
    }

    override fun showSomeErrorOccurredMsg(msg: String) {
    }

    override fun onClickChefIdAdapter(id: String?) {
        Toast.makeText(context, id, Toast.LENGTH_SHORT).show()
        Utils.replaceFragmentInActivityFadeAnimation(activity?.supportFragmentManager, ChefDetails.newInstance(),
                R.id.container, true, ChefDetails.CLASS_NAME)
    }
}