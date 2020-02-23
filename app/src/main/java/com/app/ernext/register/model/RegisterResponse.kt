package com.app.ernext.register.model



data class RegisterResponse(val status: String?, val msg: String?, val data: Data?)
data class Data(val user_password: String?, val user_mobcountry_code: Boolean?, val user_mobile: String?, val user_name: String?, val user_email: String?,
                val user_status: String?, val user_otp: String?, val user_id: String?)

