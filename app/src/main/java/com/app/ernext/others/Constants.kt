package com.app.ernext.others

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Constants {

    /* For all Keys Hashmap, CryptoPrefs, Intents, etc. */
    object Keys {
        /* All preferences are stored in one file, changing the _key and _secretKey*/
        val _CryptoPrefsFilename = "_CryptoPrefsFilename"
        val _CryptoPrefsFilenameToken = "_CryptoPrefsFilenameToken"

        /* Required for finger print check */
        val _KEYSTORE_TYPE = "AndroidKeyStore"
        val _KEYSTORE_ALIASNAME = "_KEYSTORE_ALIASNAME"
        val _SecretKeyFingerPrint = "_SecretKeyFingerPrint"
        /* To check whether the app is installed for the first time or not */
        val _SecretKeyIsFirstTimeInstalled = "_SecretKeyIsFirstTimeInstalled"
        val _KeyFirstTimeInstalled = "_KeyFirstTimeInstalled"
        /* Fragment name key. Required to redirect in specific fragment from HomeFragment/DashboardActivity */
        val KEY_FRAGMENT_NAME: String = "fragmentName"
        val KEY_FROM_WHICH_FRAGMENT_CALLING: String = "fromWhichFragmentCalling"
        val _KeyCryptoPreference = "_cryptopreference"  /// change in the MyFirebaseInstanceService

        /* Used in Enter OTP page, to show mobile number */
        val KEY_MOBILE_NUMBER = "keyMobileNumber"

        /* Tab position for : Send, Request and Pay money in payments */
        val KEY_TAB_POSITION: String = "tabPositon"
        val SEND_MONEY_TAB_POSITION = 0
        val REQUEST_MONEY_TAB_POSITION = 1
        val PAY_MONEY_TAB_POSITION = 2
        val DEVICE_TYPE = "A"
        val _password = "password"
        val _device_type = "device_type"
        val _device_token = "device_token"
        val _country_code = "country_code"
        /* Required to select country codes and return to the calling activity with result */
        val KEY_SELECTED_COUNTRY_CODE = "keySelectedCountryCode"
    }

    object Values {
        /* Required to detect ScanQrFragment is opening from which purpose/screen */
        val TO_PAY_MONEY = "toPayMoneyScreen"
        val TO_SEND_MONEY = "toSendMoney"
        /* Max date for DOB --> 1st Jan 2002 */
        val MAX_YEAR = 2002
        val MAX_MONTH = 0
        val MAX_DAY = 1
    }

    /* For OnActivityResult */
    object RequestCodes {
        /* Required to select country codes and return to the calling activity with result */
        val REQUEST_CODE_COUNTRY = 123
        /* PermissionGen library request code for runtime permissions */
        val REQUEST_CODE_PERMISSIONS = 100
        /* Required to open Gallery */
        val REQUEST_CODE_GALLERY = 456
    }

    object Services {
        val BASE_URL = "https://neuifood.com/api/user/"
    }

    fun setTimeOut(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
                .connectTimeout(100 * 20, TimeUnit.SECONDS)
                .readTimeout(100 * 20, TimeUnit.SECONDS)
                .writeTimeout(100 * 20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor { chain ->
                    val request = chain.request()
                            ?.newBuilder()
                            //?.addHeader("Content-Type", "application/json")
                            ?.addHeader("Content-Type", "application/json; charset=utf-8")
                            ?.build()
                    chain.proceed(request)
                }
                .addInterceptor(loggingInterceptor)
                .build()
    }
}