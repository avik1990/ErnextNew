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
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.app.ernext.fragments.chefdetails.ChefDetails
import kr.co.namee.permissiongen.PermissionGen

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

    fun addFragmentInActivityFadeAnimation(fragmentManager: FragmentManager?, fragment: Fragment, frameId: Int, addToBackstack: Boolean, tag: String) {
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
        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH)
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