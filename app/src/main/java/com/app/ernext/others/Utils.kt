package com.app.ernext.others

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Camera
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
import android.transition.Fade
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.app.ernext.fragments.chefdetails.ChefDetails
import kr.co.namee.permissiongen.PermissionGen
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import java.lang.reflect.AccessibleObject.setAccessible
import java.lang.reflect.Array.setBoolean
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.util.Log
import android.widget.Toast


object Utils {

    /**
     * The `fragment` is added to the container view with id `frameId`. The operation is
     * performed by the `fragmentManager`.
     */
    fun replaceFragmentInActivityFadeAnimation(fragmentManager: FragmentManager?, fragment: Fragment, frameId: Int, addToBackstack: Boolean, tag: String) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(frameId, fragment, tag)
        if (addToBackstack)
            transaction?.addToBackStack(tag)
        fragment.enterTransition = Fade(Fade.IN)
        fragment.exitTransition = Fade(Fade.OUT)

        transaction?.commit()
    }


    object BottomNavigationViewHelper {
        @SuppressLint("RestrictedApi")
        fun removeShiftMode(view: BottomNavigationView) {
            val menuView = view.getChildAt(0) as BottomNavigationMenuView
            try {
                val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
                shiftingMode.isAccessible = true
                shiftingMode.setBoolean(menuView, false)
                shiftingMode.isAccessible = false
                for (i in 0 until menuView.childCount) {
                    val item = menuView.getChildAt(i) as BottomNavigationItemView
                    item.setShifting(false)
                    // set once again checked value, so view will be updated
                    item.setChecked(item.itemData.isChecked)
                }
            } catch (e: NoSuchFieldException) {
                Log.e("BottomNav", "Unable to get shift mode field", e)
            } catch (e: IllegalAccessException) {
                Log.e("BottomNav", "Unable to change value of shift mode", e)
            }
        }
    }

    fun addFragmentInActivityFadeAnimation(fragmentManager: FragmentManager?, fragment: Fragment, frameId: Int, addToBackstack: Boolean, tag: String) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.add(frameId, fragment, tag)
        if (addToBackstack)
            transaction?.addToBackStack(tag)
        fragment.enterTransition = Fade(Fade.IN)
        fragment.exitTransition = Fade(Fade.OUT)
        transaction?.commit()
    }


    fun addFragmentInActivityFadeAnimationBundle(fragmentManager: FragmentManager?, fragment: Fragment, frameId: Int, addToBackstack: Boolean, tag: String) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.add(frameId, fragment, tag)
        if (addToBackstack)
            transaction?.addToBackStack(tag)
        fragment.enterTransition = Fade(Fade.IN)
        fragment.exitTransition = Fade(Fade.OUT)

        transaction?.commit()
    }

    /* Handle network availability */
    fun isConnectedToNetwork(context: Context): Boolean {
        return true
        /* val info = getNetworkInfo(context)
         return info != null && info!!.isConnected()*/
    }

    private fun getNetworkInfo(context: Context?): NetworkInfo {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo
    }

    /* Show Snackbar on validation check */
    fun showSnackbar(parentLayoutId: View, msg: String, timeInMillis: Int) {
        Snackbar.make(parentLayoutId, msg, timeInMillis).show()
    }

    /* Show Snackbar on validation check */
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    /* Hide keyboard while changing from one activity to another fragment */
    fun hideKeyboard(activity: Activity?) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity?.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.currentFocus
                    .getApplicationWindowToken(), 0)
    }

    /* Hide keyboard on outside touch */
    fun hideKeyboardOnOutsideTouch(view: View, activity: Activity) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { view, motionEvent ->
                hideKeyboard(activity)
                false
            }
        }
    }

    /* Camera flash on */
    fun makeFlashOn(context: Context?) {
        val cam = Camera.open()
        val p = cam.getParameters()
        p.flashMode = Camera.Parameters.FLASH_MODE_TORCH
        cam.parameters = p
        cam.startPreview()
    }

    /* Camera flash off */
    fun makeFlashOff(context: Context?) {
        val cam = Camera.open()
        val p = cam.parameters
        p.flashMode = Camera.Parameters.FLASH_MODE_OFF
        cam.parameters = p
        cam.stopPreview()
        cam.release()
    }

    @SuppressLint("MissingPermission")
    /* To make phone call on Help & Support */
    fun setPhoneCall(numberToCall: String, context: Context?) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:" + numberToCall)
        context?.startActivity(intent)
    }

    /* Check for runtime permissions */
    fun checkPermissions(context: AppCompatActivity) {
        PermissionGen.with(context)
                .addRequestCode(Constants.RequestCodes.REQUEST_CODE_PERMISSIONS)
                .permissions(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.CAMERA,
                        Manifest.permission.USE_FINGERPRINT,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request()

    }

    /* Format date (day,month,year) */
    fun formatDate(dayOfMonth: Int, monthOfYear: Int, year: Int): CharSequence? {

        var date = dayOfMonth.toString()+getDaySuffix(dayOfMonth)
        var month = getMonth(monthOfYear)
        var formattedDate = date+" "+month+" "+year

        return formattedDate
    }

    private fun getMonth(monthOfYear: Int): Any? {

        if (monthOfYear == 1){
            return "Jan"
        }
        else if (monthOfYear == 2){
            return "Feb"
        }
        else if (monthOfYear == 3){
            return "Mar"
        }
        else if (monthOfYear == 4){
            return "April"
        }
        else if (monthOfYear == 5){
            return "May"
        }
        else if (monthOfYear == 6){
            return "Jun"
        }
        else if (monthOfYear == 7){
            return "July"
        }
        else if (monthOfYear == 8){
            return "Aug"
        }
        else if (monthOfYear == 9){
            return "Sep"
        }
        else if (monthOfYear == 10){
            return "Oct"
        }
        else if (monthOfYear == 11){
            return "Nov"
        }
        else {
            return "Dec"
        }
    }

    private fun getDaySuffix(dayOfMonth: Int): Any {

        if (dayOfMonth == 1 || dayOfMonth == 21 || dayOfMonth == 31){
            return "st"
        }
        else if (dayOfMonth == 2 || dayOfMonth == 22){
            return "nd"
        }
        else if (dayOfMonth == 3 && dayOfMonth == 23){
            return "rd"
        }
        else{
            return "th"
        }
    }

}