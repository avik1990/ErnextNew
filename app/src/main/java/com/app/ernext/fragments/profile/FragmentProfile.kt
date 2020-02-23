package com.app.ernext.fragments.menus

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.app.ernext.BaseFragment
import com.app.ernext.R
import com.app.ernext.fragments.chefdetails.ChefDetails
import com.app.ernext.fragments.chefs.adapter.FeaturedChefAdapter
import com.app.ernext.fragments.menus.adapter.MenusAdapter
import com.app.ernext.fragments.menus.model.MenusDeals
import com.app.ernext.fragments.menus.model.ProfileMenus
import com.app.ernext.fragments.profile.adapter.ProfileAdapter
import com.app.ernext.others.Utils
import kotlinx.android.synthetic.main.chefs_fragment.*
import java.util.ArrayList

class Fragmentprofile : BaseFragment(), View.OnClickListener, ProfileContract.View,FeaturedChefAdapter.ChefIdAdapter, ProfileAdapter.ChefIdAdapter {

    private val list_featured_chefs = ArrayList<ProfileMenus>()
    lateinit var mContext: Context

    override fun hideSearchBar() {
       // v_searchview.visibility = View.GONE
    }

    lateinit var chefsPresenter: MenusPresenter

    companion object {
        const val CLASS_NAME = "Fragmentprofile"
        fun newInstance(): Fragment {
            return Fragmentprofile()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.myprofile
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {
        mContext =activity!!
        createList()
    }

    private fun createList() {
        list_featured_chefs.add(ProfileMenus("1", "Your Orders", "3.2", "120", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/5/005/03f/2db/07e99f3.jpg"))
        list_featured_chefs.add(ProfileMenus("2", "Wish List", "3.2", "123", "http://www.celebplasticsurgeryonline.com/wp-content/uploads/2016/02/Brad-Pitt-plastic-surgery-featured.jpg"))
        list_featured_chefs.add(ProfileMenus("3", "Inbox", "5", "126", "http://www.contactmusic.com/images/feature-images/johnny-depp-2016-alice-uk-premiere-01-670-500.jpg"))
        list_featured_chefs.add(ProfileMenus("4", "Change Password", "4", "127", "http://www.oncologica.com/wp-content/uploads/2016/06/98892061_UNHCR-Josie-world-large_transZgEkZX3M936N5BQK4Va8RQJ6Ra64K3tAxfZq0dvIBJw.jpg"))
        list_featured_chefs.add(ProfileMenus("5", "Address Book", "3", "345", "http://www.ansa.it/webimages/foto_large_ls_350/2016/1/13/fd13e7f6ca8fd863f91a2936cdd7f8d4.jpg"))
        list_featured_chefs.add(ProfileMenus("6", "Upgrade to Provider", "3", "224", "http://www.fansofcinema.com/wp-content/uploads/2015/09/All-Upcoming-Films-of-Aamir-Khan-in-2015-2016-2017.jpg"))
        list_featured_chefs.add(ProfileMenus("7", "My Reviews", "2", "138", "http://www.stylerug.net/wp-content/uploads/2016/12/King-Khan.jpg"))
        list_featured_chefs.add(ProfileMenus("8", "Help & Support", "4", "112", "https://cdn.techinasia.com/wp-content/uploads/2015/07/jackma.jpg"))
        list_featured_chefs.add(ProfileMenus("8", "Log Out", "4", "112", "https://cdn.techinasia.com/wp-content/uploads/2015/07/jackma.jpg"))
    }


    override fun initListeners() {
        fc_recycler_view.layoutManager = LinearLayoutManager(mContext)
        val ca = ProfileAdapter(mContext, list_featured_chefs,this)
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

    override fun setPresenter(presenter: ProfileContract.Presenter) {
        chefsPresenter = presenter as MenusPresenter
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