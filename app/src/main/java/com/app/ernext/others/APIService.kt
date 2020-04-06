package com.app.ernext.others

import com.app.ernext.home.DashboardModel
import com.app.ernext.otp.model.OTPResponse
import com.app.ernext.register.model.RegisterResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

/* All Retrofit interfaces here */
interface APIService {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("register/format/json/")
    fun callSignUpAPI(@Field("name") fullname: String,
                      @Field("email") email: String,
                      @Field("password") password: String,
                      @Field("isdCode") isdCode: String,
                      @Field("mobile") phoneNo: String,
                      @Field("mode") confirm_password: String,
                      @Field("device_token") device_token: String,
                      @Field("device_id") device_id: String,
                      @Field("device_type") device_type: String): Observable<RegisterResponse>

    @POST("otp/format/json/")
    @FormUrlEncoded
    fun callOTPAPI(@Field("user_id") user_id: String,
                      @Field("otp") otp: String,
                      @Field("device_type") device_type: String,
                      @Field("device_id") device_id: String): Observable<OTPResponse>

    @GET("dashboard/format/json/")
    fun callDashboardAPI(@Query("device_id") device_id: String,
                         @Query("user_id") user_id: String,
                         @Query("device_type") device_type: String): Call<DashboardModel>


    /*fullname:String,
    email:String,
    password: String,
    isdCode:String,
    phoneNo: String,
    isTerms:String,
    mode:String,
    device_token:String,
    device_type:String*/

    /*fun UserRegistration(
            @Query("fname") fname: String,
            @Query("lname") lname: String,
            @Query("phone") phone: String,
            @Query("email") email: String,
            @Query("password") password: String,
            @Query("confirm_password") confirm_password: String,
            @Query("address") address: String,
            @Query("state") state: String,
            @Query("city") city: String,
            @Query("zip") zip: String,
            @Query("flag") flag: String, @Query("unique_id") unique_id: String
    ): Call<RegistrationResponse>*/
    /*@POST("login")
    fun callLoginAPI(@Body loginRequestModel: LoginRequestModel): Observable<BaseResponse>

    @POST("otpafterrigistration")
    fun callotpafterrigistration(@Body otpafterrigistrationRequest: OtpafterrigistrationRequest): Observable<BaseResponse>

    @POST("loginafterrigistration")
    fun callloginafterrigistration(@Body enterOTPRequest: EnterOTPRequest): Observable<BaseResponse>

    @POST("forgotpassword")
    fun callForgotpasswordAPI(@Body forgotPasswordRequest: ForgotPasswordRequest): Observable<BaseResponse>

    @GET("getcallprefixcode")
    fun callCountryCodeAPI(): Observable<BaseResponse>

    @POST("getoperatorlist")
    fun callOperatorListAPI(@Body operatorListRequest: OperatorListRequest): Observable<BaseResponse>

    @POST("otpvalidation")
    fun callVerifyOTPAPI(@Body verifyOTPRequest: VerifyOTPRequest): Observable<BaseResponse>

    @POST("resendotp")
    fun callResendOTPAPI(@Body verifyOTPRequest: ResendOTPRequest): Observable<BaseResponse>

    @POST("createnewpassword")
    fun callcreatenewpasswordAPI(@Body createPasswordRequest: CreatePasswordRequest): Observable<BaseResponse>

    @POST("add-money-to-wallet")
    fun calladdmoenttowalletAPI(@Body addMoneyWalletRequest: AddMoneyWalletRequest): Observable<BaseResponse>

    @POST("getpages")
    fun callAboutusAPI(@Field("json_string") json_string: String): Observable<BaseResponse>

    @POST("mobilerecharge")
    fun callmobileRechargeApi(@Body mobileRechargeRequest: MobileRechargeRequest): Observable<BaseResponse>

    @POST("userforcelogin")
    fun callforceloginApi(@Body forceLoginRequest: ForceLoginRequest): Observable<BaseResponse>

    @POST("otpafterlogin")
    fun callotpafterloginApi(@Body verifyOTPRequest: VerifyOTPRequest): Observable<BaseResponse>

    @POST("getpages")
    fun callAboutusPostAPI(@Body aboutUsRequest: AboutUsRequest): Observable<BaseResponse>

    @POST("contactus")
    fun callContactusPostAPI(@Body contactUsRequest: ContactUsRequest): Observable<BaseResponse>

    @POST("profiledetails")
    fun callProfiledetailsPostAPI(@Body userProfileRequest: UserProfileRequest): Observable<BaseResponse>

    @POST("editprofile")
    fun callEditProfilePostAPI(@Body userEditRequest: UserEditRequest): Observable<BaseResponse>

    @Multipart
    @POST("editprofileimage")
    fun callProfileImagePostAPI(@Part image: MultipartBody.Part, @Query("user_id") user_id: String): Observable<BaseResponse>

    @POST("msisdninfo")
    fun callMsisdninfoApi(@Body mobileRechargeRequest: MsisdninfoRequest): Observable<BaseResponse>

    @POST("mobilerechargelist")
    fun callRechargehistApi(@Body transactionRequest: TransactionRequest): Observable<BaseResponse>

    @POST("foreign-exchange-list")
    fun callTransactionListAPI(@Body baseCurrencyRequest: BaseCurrencyRequest): Observable<BaseResponse>

    @POST("changepassword")
    fun callChangepasswordAPI(@Body contactUsRequest: ChangePasscodeRequest): Observable<BaseResponse>

    @POST("useremailvalidation")
    fun callVerifyEmailPostAPI(@Body userProfileRequest: UserEmailVerificationRequest): Observable<BaseResponse>

    @POST("kyc-verification")
    fun callKYCURLGeneratorPostAPI(@Body kYCRequestVerificationModel: KYCRequestVerificationModel): Observable<BaseResponse>

    @POST("kyc-methods")
    fun callKYCURLMethodPostAPI(@Body kYCMethodsCheckRequest: KYCMethodsCheckRequest): Observable<BaseResponse>

    @POST("useremailvalidation")
    fun callUserEmailValidate(@Body userEmailVerify: UserEmailVerify): Observable<BaseResponse>

    @POST("/guulpayapi/api/user-notification-list")
    fun callnotificationRequest(@Body notificationRequest: NotificationRequest): Observable<BaseResponse>


    @POST("/guulpayapi/api/currencylist")
    fun callCurrencyList(@Body currencyList : CurrencyListRequest): Observable<BaseResponse>

    @POST("/guulpayapi/api/foreign-exchange-list")
    fun callForeignExchangeList(@Body forExList: ForExListRequest): Observable<BaseResponse>

    @POST("/guulpayapi/api/currencypairprice")
    fun callCalculateAmountList(@Body calculateAmount:CalculateAmountRequest):Observable<BaseResponse>

    @POST("/guulpayapi/api/addforexcartbuy")
    fun callForexCartBuy(@Body forexCartBuy: ForexCartBuyRequest):Observable<BaseResponse>

    @POST("/guulpayapi/api/transactiondetails")
    fun callTransactionHistory(@Body transactionHistory:TransactionHistoryRequest):Observable<BaseResponse>*/

}
