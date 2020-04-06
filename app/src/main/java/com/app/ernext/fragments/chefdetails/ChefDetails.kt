package com.app.ernext.fragments.chefdetails

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.app.ernext.BaseFragment
import com.app.ernext.R
import com.app.ernext.others.Utils
import kotlinx.android.synthetic.main.chefdetails_fragment.*

class ChefDetails : BaseFragment(), View.OnClickListener, ChefDetailsContract.View {

    override fun hideSearchBar() {
       // v_searchview.visibility = View.GONE
    }

    lateinit var chefDetailsPresenter: ChefDetailsPresenter

    companion object {
        const val CLASS_NAME = "ChefDetails"
        fun newInstance(): Fragment {
            return ChefDetails()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.chefdetails_fragment
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {

        /* Adding Tabs */
        tabLayoutPayment.addTab(tabLayoutPayment.newTab())
        tabLayoutPayment.addTab(tabLayoutPayment.newTab())
        tabLayoutPayment.addTab(tabLayoutPayment.newTab())
        tabLayoutPayment.addTab(tabLayoutPayment.newTab())

        /* set up ViewPager */
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, tabLayoutPayment.tabCount)
        viewPagerPayment.adapter = viewPagerAdapter
        tabLayoutPayment.setupWithViewPager(viewPagerPayment)
        /* Custom view is inflated to make the text of Tab left-aligned */
        for (i in 0..tabLayoutPayment.tabCount-1){
            tabLayoutPayment.getTabAt(i)?.setCustomView(getCustomViewTab(i))
        }
    }

    private fun getCustomViewTab(pos:Int): View {
        val tabInflater = LayoutInflater.from(context).inflate(R.layout.custom_tabitems, null) as LinearLayout
        val tvTabContent = tabInflater.findViewById(R.id.tvTabContent) as TextView
        tvTabContent.text = resources.getStringArray(R.array.tabItemsChefs)[pos]
        tvTabContent.setTextColor(Color.BLACK)
        tabLayoutPayment.getTabAt(pos)?.setCustomView(tvTabContent)

        return tvTabContent
    }


    override fun initListeners() {
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

    override fun setPresenter(presenter: ChefDetailsContract.Presenter) {
        chefDetailsPresenter = presenter as ChefDetailsPresenter
    }

    override fun isNetworkAvailable(): Boolean {
        return Utils.isConnectedToNetwork(this!!.activity!!)
    }

    override fun showNetworkUnavailableMsg() {
    }

    override fun showSomeErrorOccurredMsg(msg: String) {
    }
}