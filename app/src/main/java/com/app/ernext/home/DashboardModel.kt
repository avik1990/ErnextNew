package com.app.ernext.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DashboardModel {
    @SerializedName("status")
    @Expose
    private var status: Int? = null
    @SerializedName("msg")
    @Expose
    private var msg: String? = null
    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getStatus(): Int? {
        return status
    }

    fun setStatus(status: Int?) {
        this.status = status
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String?) {
        this.msg = msg
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }


    class Data {
        @SerializedName("banner_rows")
        @Expose
        var bannerRows: List<BannerRow>? = null
        @SerializedName("chef_rows")
        @Expose
        var chefRows: List<ChefRow>? = null
        @SerializedName("dish_rows")
        @Expose
        var dishRows: List<DishRow>? = null
        @SerializedName("cat_rows")
        @Expose
        var catRows: List<CatRow>? = null
        @SerializedName("type_rows")
        @Expose
        var typeRows: List<TypeRow>? = null
    }

    class DishRow {
        @SerializedName("dish_id")
        @Expose
        var dishId: String? = null
        @SerializedName("user_id")
        @Expose
        var userId: String? = null
        @SerializedName("category_id")
        @Expose
        var categoryId: String? = null
        @SerializedName("dishtype_id")
        @Expose
        var dishtypeId: String? = null
        @SerializedName("dish_name")
        @Expose
        var dishName: String? = null
        @SerializedName("dish_image")
        @Expose
        var dishImage: String? = null
        @SerializedName("dish_nutrition_balance")
        @Expose
        var dishNutritionBalance: String? = null
        @SerializedName("dish_description")
        @Expose
        var dishDescription: String? = null
        @SerializedName("dish_preparation")
        @Expose
        var dishPreparation: String? = null
        @SerializedName("dish_shortsummery")
        @Expose
        var dishShortsummery: String? = null
        @SerializedName("dish_full_base_price")
        @Expose
        var dishFullBasePrice: String? = null
        @SerializedName("dish_half_base_price")
        @Expose
        var dishHalfBasePrice: String? = null
        @SerializedName("dish_discount")
        @Expose
        var dishDiscount: String? = null
        @SerializedName("dish_available_full")
        @Expose
        var dishAvailableFull: String? = null
        @SerializedName("dish_available_half")
        @Expose
        var dishAvailableHalf: String? = null
        @SerializedName("dish_status")
        @Expose
        var dishStatus: String? = null
        @SerializedName("updated_by")
        @Expose
        var updatedBy: String? = null
        @SerializedName("IP")
        @Expose
        var iP: String? = null
        @SerializedName("DOC")
        @Expose
        var dOC: String? = null
        @SerializedName("DOM")
        @Expose
        var dOM: String? = null
        @SerializedName("user_on_vacation")
        @Expose
        var userOnVacation: String? = null
        @SerializedName("dish_publish_status")
        @Expose
        var dishPublishStatus: String? = null
        @SerializedName("nutrition_balance")
        @Expose
        var nutritionBalance: String? = null
        @SerializedName("cat_name")
        @Expose
        var catName: String? = null
        @SerializedName("dt_name")
        @Expose
        var dtName: String? = null
        @SerializedName("user_name")
        @Expose
        var userName: String? = null
        @SerializedName("user_avatar")
        @Expose
        var userAvatar: String? = null
        @SerializedName("user_city_id")
        @Expose
        var userCityId: String? = null
        @SerializedName("state_name")
        @Expose
        var stateName: String? = null
        @SerializedName("city_name")
        @Expose
        var cityName: String? = null
        @SerializedName("country_name")
        @Expose
        var countryName: String? = null
        @SerializedName("user_lat")
        @Expose
        var userLat: String? = null
        @SerializedName("user_lon")
        @Expose
        var userLon: String? = null
        @SerializedName("user_available")
        @Expose
        var userAvailable: String? = null
        @SerializedName("user_avl_from_date")
        @Expose
        var userAvlFromDate: String? = null
        @SerializedName("user_avl_to_date")
        @Expose
        var userAvlToDate: String? = null
        @SerializedName("user_delivery_available")
        @Expose
        var userDeliveryAvailable: String? = null
        @SerializedName("user_weekdays")
        @Expose
        var userWeekdays: String? = null
        @SerializedName("user_from_hour")
        @Expose
        var userFromHour: String? = null
        @SerializedName("user_to_hour")
        @Expose
        var userToHour: String? = null
        @SerializedName("user_feedback")
        @Expose
        var userFeedback: String? = null
        @SerializedName("user_feedback_count")
        @Expose
        var userFeedbackCount: String? = null
        @SerializedName("dish_feedback")
        @Expose
        var dishFeedback: String? = null
        @SerializedName("user_status")
        @Expose
        var userStatus: String? = null

    }

    class TypeRow {
        @SerializedName("dt_id")
        @Expose
        var dtId: String? = null
        @SerializedName("dt_name")
        @Expose
        var dtName: String? = null
        @SerializedName("dt_status")
        @Expose
        var dtStatus: String? = null
        @SerializedName("updated_by")
        @Expose
        var updatedBy: String? = null
        @SerializedName("IP")
        @Expose
        var iP: String? = null
        @SerializedName("DOC")
        @Expose
        var dOC: String? = null
        @SerializedName("DOM")
        @Expose
        var dOM: String? = null
    }

    class BannerRow {
        @SerializedName("banner_id")
        @Expose
        var bannerId: String? = null
        @SerializedName("banner_imgsrc")
        @Expose
        var bannerImgsrc: String? = null
        @SerializedName("banner_text")
        @Expose
        var bannerText: String? = null
        @SerializedName("banner_subtext")
        @Expose
        var bannerSubtext: String? = null
        @SerializedName("banner_for")
        @Expose
        var bannerFor: String? = null
        @SerializedName("banner_status")
        @Expose
        var bannerStatus: String? = null
        @SerializedName("updated_by")
        @Expose
        var updatedBy: String? = null
        @SerializedName("IP")
        @Expose
        var iP: String? = null
        @SerializedName("DOC")
        @Expose
        var dOC: String? = null
        @SerializedName("DOM")
        @Expose
        var dOM: String? = null

    }

    class ChefRow {
        @SerializedName("user_id")
        @Expose
        var userId: String? = null
        @SerializedName("user_mobcountry_code")
        @Expose
        var userMobcountryCode: String? = null
        @SerializedName("user_mobile")
        @Expose
        var userMobile: String? = null
        @SerializedName("user_mob2country_code")
        @Expose
        var userMob2countryCode: String? = null
        @SerializedName("user_mobile2")
        @Expose
        var userMobile2: String? = null
        @SerializedName("user_password")
        @Expose
        var userPassword: String? = null
        @SerializedName("user_name")
        @Expose
        var userName: String? = null
        @SerializedName("user_nickname")
        @Expose
        var userNickname: String? = null
        @SerializedName("user_address")
        @Expose
        var userAddress: String? = null
        @SerializedName("user_country_id")
        @Expose
        var userCountryId: String? = null
        @SerializedName("user_state_id")
        @Expose
        var userStateId: String? = null
        @SerializedName("user_city_id")
        @Expose
        var userCityId: String? = null
        @SerializedName("user_pincode")
        @Expose
        var userPincode: String? = null
        @SerializedName("user_email")
        @Expose
        var userEmail: String? = null
        @SerializedName("user_alternate_mobile")
        @Expose
        var userAlternateMobile: Any? = null
        @SerializedName("user_gender")
        @Expose
        var userGender: String? = null
        @SerializedName("user_fblink")
        @Expose
        var userFblink: String? = null
        @SerializedName("user_twitter")
        @Expose
        var userTwitter: String? = null
        @SerializedName("user_googleplus")
        @Expose
        var userGoogleplus: String? = null
        @SerializedName("user_youtube_url")
        @Expose
        var userYoutubeUrl: String? = null
        @SerializedName("user_weblink")
        @Expose
        var userWeblink: String? = null
        @SerializedName("user_avatar")
        @Expose
        var userAvatar: String? = null
        @SerializedName("user_aboutme")
        @Expose
        var userAboutme: String? = null
        @SerializedName("user_owner_type")
        @Expose
        var userOwnerType: String? = null
        @SerializedName("user_expertise")
        @Expose
        var userExpertise: String? = null
        @SerializedName("user_experience_summary")
        @Expose
        var userExperienceSummary: String? = null
        @SerializedName("user_experience_year")
        @Expose
        var userExperienceYear: String? = null
        @SerializedName("user_delivery_available")
        @Expose
        var userDeliveryAvailable: String? = null
        @SerializedName("user_registration_no")
        @Expose
        var userRegistrationNo: String? = null
        @SerializedName("user_dishcats")
        @Expose
        var userDishcats: String? = null
        @SerializedName("user_registration_photoid")
        @Expose
        var userRegistrationPhotoid: String? = null
        @SerializedName("user_payment_method")
        @Expose
        var userPaymentMethod: String? = null
        @SerializedName("user_tracklocation")
        @Expose
        var userTracklocation: String? = null
        @SerializedName("user_experience_videos")
        @Expose
        var userExperienceVideos: String? = null
        @SerializedName("paypal_id")
        @Expose
        var paypalId: String? = null
        @SerializedName("bank_ac_no")
        @Expose
        var bankAcNo: String? = null
        @SerializedName("bank_name")
        @Expose
        var bankName: String? = null
        @SerializedName("bank_ifsc_code")
        @Expose
        var bankIfscCode: String? = null
        @SerializedName("bank_address")
        @Expose
        var bankAddress: String? = null
        @SerializedName("user_available")
        @Expose
        var userAvailable: String? = null
        @SerializedName("user_avl_from_date")
        @Expose
        var userAvlFromDate: String? = null
        @SerializedName("user_avl_to_date")
        @Expose
        var userAvlToDate: String? = null
        @SerializedName("user_delivery_charges")
        @Expose
        var userDeliveryCharges: String? = null
        @SerializedName("user_weekdays")
        @Expose
        var userWeekdays: String? = null
        @SerializedName("user_avg_delivery_time")
        @Expose
        var userAvgDeliveryTime: String? = null
        @SerializedName("user_from_hour")
        @Expose
        var userFromHour: String? = null
        @SerializedName("user_to_hour")
        @Expose
        var userToHour: String? = null
        @SerializedName("user_lat")
        @Expose
        var userLat: Any? = null
        @SerializedName("user_lon")
        @Expose
        var userLon: Any? = null
        @SerializedName("user_ssn")
        @Expose
        var userSsn: String? = null
        @SerializedName("user_driving_lic_no")
        @Expose
        var userDrivingLicNo: String? = null
        @SerializedName("user_driving_lic")
        @Expose
        var userDrivingLic: Any? = null
        @SerializedName("user_type")
        @Expose
        var userType: String? = null
        @SerializedName("user_isprovider")
        @Expose
        var userIsprovider: String? = null
        @SerializedName("user_isdelivery")
        @Expose
        var userIsdelivery: String? = null
        @SerializedName("user_profile_status")
        @Expose
        var userProfileStatus: String? = null
        @SerializedName("user_featured")
        @Expose
        var userFeatured: String? = null
        @SerializedName("user_verification_status")
        @Expose
        var userVerificationStatus: String? = null
        @SerializedName("user_status")
        @Expose
        var userStatus: String? = null
        @SerializedName("user_otp")
        @Expose
        var userOtp: String? = null
        @SerializedName("updated_by")
        @Expose
        var updatedBy: String? = null
        @SerializedName("IP")
        @Expose
        var iP: String? = null
        @SerializedName("DOC")
        @Expose
        var dOC: String? = null
        @SerializedName("DOM")
        @Expose
        var dOM: String? = null
        @SerializedName("user_on_vacation")
        @Expose
        var userOnVacation: String? = null
        @SerializedName("out_of_station")
        @Expose
        var outOfStation: String? = null
        @SerializedName("city_name")
        @Expose
        var cityName: String? = null
        @SerializedName("state_name")
        @Expose
        var stateName: String? = null
        @SerializedName("country_name")
        @Expose
        var countryName: String? = null
        @SerializedName("avg_user_rating")
        @Expose
        var avgUserRating: String? = null
    }

    class CatRow {
        @SerializedName("cat_id")
        @Expose
        var catId: String? = null
        @SerializedName("parent_cat_id")
        @Expose
        var parentCatId: String? = null
        @SerializedName("cat_name")
        @Expose
        var catName: String? = null
        @SerializedName("cat_status")
        @Expose
        var catStatus: String? = null
        @SerializedName("updated_by")
        @Expose
        var updatedBy: String? = null
        @SerializedName("IP")
        @Expose
        var iP: String? = null
        @SerializedName("DOC")
        @Expose
        var dOC: String? = null
        @SerializedName("DOM")
        @Expose
        var dOM: String? = null

    }


}