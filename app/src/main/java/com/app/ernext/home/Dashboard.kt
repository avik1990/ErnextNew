package com.app.ernext.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.ernext.BaseActivity
import com.app.ernext.R
import com.app.ernext.fragments.chefdetails.ChefDetails
import com.app.ernext.fragments.chefs.FragmentChefs
import com.app.ernext.fragments.home.Homefragment
import com.app.ernext.fragments.menus.FragmentDeals
import com.app.ernext.fragments.menus.FragmentMenus
import com.app.ernext.fragments.menus.Fragmentprofile
import com.app.ernext.home.adapter.DashboardMenuAdapter
import com.app.ernext.others.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard_inc.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Dashboard : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, DashboardMenuAdapter.GetIdFromMenuAdapter, View.OnClickListener {

    lateinit var context:Context
    lateinit var menuAdapter:DashboardMenuAdapter
    lateinit var  intermenuadapter: DashboardMenuAdapter.GetIdFromMenuAdapter
    var dashresponse:DashboardModel?=null

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        // Eutils.openNavDrawer(id, mContext)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private val loader by lazy {
        LoaderDialog(context)
    }

    override fun initResources() {
        context=this
        intermenuadapter=this

        btn_menu.setOnClickListener(this)
        bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (supportFragmentManager.findFragmentById(R.id.container) !is Homefragment) {
                        Utils.replaceFragmentInActivityFadeAnimation(supportFragmentManager, Homefragment.newInstance("Hello World",dashresponse!!.getData()!!.bannerRows!!,
                                dashresponse!!.getData()!!.chefRows!!,dashresponse!!.getData()!!.dishRows!!),
                                R.id.container, true, Homefragment.CLASS_NAME)
                    }
                }

                R.id.nav_chefs -> {
                    if (supportFragmentManager.findFragmentById(R.id.container) !is FragmentChefs) {
                        Utils.replaceFragmentInActivityFadeAnimation(supportFragmentManager, FragmentChefs.newInstance(),
                                R.id.container, true, FragmentChefs.CLASS_NAME)
                    }
                }

                R.id.nav_menus-> {
                    if (supportFragmentManager.findFragmentById(R.id.container) !is FragmentMenus) {
                        Utils.replaceFragmentInActivityFadeAnimation(supportFragmentManager, FragmentMenus.newInstance(),
                                R.id.container, true, FragmentMenus.CLASS_NAME)
                    }
                }

                R.id.nav_deals-> {
                    if (supportFragmentManager.findFragmentById(R.id.container) !is FragmentDeals) {
                        Utils.replaceFragmentInActivityFadeAnimation(supportFragmentManager, FragmentDeals.newInstance(),
                                R.id.container, true, FragmentDeals.CLASS_NAME)
                    }
                }
                R.id.nav_profile-> {
                    if (supportFragmentManager.findFragmentById(R.id.container) !is Fragmentprofile) {
                        Utils.replaceFragmentInActivityFadeAnimation(supportFragmentManager, Fragmentprofile.newInstance(),
                                R.id.container, true, Fragmentprofile.CLASS_NAME)
                    }
                }
            }

            true
        })

    }

    override fun initListeners() {
        var navigationView: NavigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.itemIconTintList = null

        val headerView = navigationView.inflateHeaderView(R.layout.nav_header_main)
        val txt_name = headerView.findViewById(R.id.tv_notif_tips_title) as TextView
        val ivNavDrawer = findViewById<ImageView>(R.id.iv_product_photo)
        val tvName = findViewById<TextView>(R.id.tv_notif_tips_title)

        val tv_cartcount = findViewById<CircularTextView>(R.id.tv_cartcount)
        tv_cartcount.setSolidColor("#002f49")
        Utils.BottomNavigationViewHelper.removeShiftMode(bottomNavigation)
        verifyUser()
    }

    override fun getLayout(): Int {
        return R.layout.activity_dashboard_inc
    }

    override fun initPermissions() {
    }


    fun parseIntent(intent: Intent?) {
        if (null != intent) {
            if (intent.hasExtra(Constants.Keys.KEY_FRAGMENT_NAME)) {
                val fragName = intent.getStringExtra(Constants.Keys.KEY_FRAGMENT_NAME)
                setUpScreenUiForFragment(fragName)
                when (fragName) {
                    Homefragment.CLASS_NAME -> {
                        Utils.addFragmentInActivityFadeAnimation(supportFragmentManager,
                                Homefragment.newInstance("Hello World",dashresponse!!.getData()!!.bannerRows!!,
                                        dashresponse!!.getData()!!.chefRows!!,dashresponse!!.getData()!!.dishRows!!),
                                R.id.container, false, Homefragment.CLASS_NAME)
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        Utils.hideKeyboard(this)
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
             if (supportFragmentManager.findFragmentById(R.id.container) is Homefragment) {
                 Log.e("HomeActivity", "SavedBanksFragment")
                 bottomNavigation.selectedItemId = R.id.nav_home;
                // setUpScreenUiForFragment(Homefragment.CLASS_NAME)
             }
            else if (supportFragmentManager.findFragmentById(R.id.container) is FragmentChefs){
                Log.e("HomeActivity","AddBankAccountFragment")
                 bottomNavigation.selectedItemId = R.id.nav_home
                //setUpScreenUiForFragment(SavedBanksFragment.CLASS_NAME)
            }
            else if (supportFragmentManager.findFragmentById(R.id.container) is ChefDetails){
                 Log.e("HomeActivity","EditProfileFragment")
                 bottomNavigation.selectedItemId = R.id.nav_chefs
                //setUpScreenUiForFragment(ViewProfileFragment.CLASS_NAME)
            }
           /* else if (supportFragmentManager.findFragmentById(R.id.flFragmentContainerHome) is CompleteYourPaymentFragment){
                Log.e("HomeActivity","CompleteYourPaymentFragment")
                setUpScreenUiForFragment(AddMoneyEnterAmountFragment.CLASS_NAME)
            }*/
        } else {
            super.onBackPressed()
        }
    }

    fun setUpScreenUiForFragment(fragName: String) {
        /*imgvwGuulpayLogo.visibility = View.GONE
          imgvwCommonToolbar.visibility = View.VISIBLE
          tvCommonToolbar.visibility = View.VISIBLE*/
          //v_searchview.visibility = View.VISIBLE
        when (fragName) {
            ChefDetails.CLASS_NAME -> {
                v_searchview.visibility = View.GONE
            }
            Homefragment.CLASS_NAME -> {
                v_searchview.visibility = View.VISIBLE
            }

            /*TermsAndConditionsFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.termsAndConditions))
            }
            EnterMobileForgotPasscodeFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.forgotPwd))
            }
            ChangePasscodeFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.changePasscode))
            }
            AddMoneyEnterAmountFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.add))
            }
            AddMoneyPaymentStatusFragment.CLASS_NAME -> {
                imgvwGuulpayLogo.visibility = View.VISIBLE
                imgvwCommonToolbar.visibility = View.GONE
                tvCommonToolbar.visibility = View.GONE
            }
            CompleteYourPaymentFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.completeYourPayment))
            }
            NotificationFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.notification))
            }
            ViewProfileFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.profile))
            }
            EditProfileFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.editProfile))
            }
            AddReceiverAccountFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.addReceiver))
            }
            AutoLoadAmountFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.autoLoad2))
            }
            AddBankAccountFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.addBankAccount))
            }
            EnterOtpFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.verifyOtp))
            }
            SavedBanksFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.savedBanks))
            }
            SavedCardsFragment.CLASS_NAME -> {
                tvCommonToolbar.setText(getString(R.string.savedCards))
            }*/
        }
    }

    private fun verifyUser() {
        loader.show()
        val redditAPI: APIService

        redditAPI = RetrofitClient.getClient()!!.create(APIService::class.java)
        val call: Call<DashboardModel> = redditAPI.callDashboardAPI("0000","0","A")
        call.enqueue(object : Callback<DashboardModel?> {
            override fun onResponse(call: Call<DashboardModel?>, response: Response<DashboardModel?>) {
                Log.d("String", "" + response)
                if (response.isSuccessful()) {
                    dashresponse = response.body()
                    Log.e("Response",response.toString())
                    if (dashresponse!!.getStatus()== 1) {
                        //showToast(context,""+dashresponse!!.getData()!!.catRows!!.size)
                        menuAdapter = DashboardMenuAdapter(context!!, dashresponse!!.getData()!!.catRows, intermenuadapter)
                        val layoutManager1 = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        rcNavMenu.layoutManager=layoutManager1
                        rcNavMenu.setAdapter(menuAdapter)
                        parseIntent(intent)
                    } else {
                    }
                }
                loader.hide()
            }

            override fun onFailure(call: Call<DashboardModel?>, t: Throwable) {
                loader.hide()
            }
        })
    }

    override fun returnedID(id: String?) {
        showToast(context,""+id)
    }

    override fun onClick(v: View?) {
        if(v===btn_menu){
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }
}