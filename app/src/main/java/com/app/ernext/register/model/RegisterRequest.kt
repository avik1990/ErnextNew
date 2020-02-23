package com.app.ernext.register.model

data class RegisterRequest(val fullname:String,
                           val email:String,
                           val password: String,
                           val isdCode:String,
                           val phoneNo: String,
                           val isTerms: String,
                           val mode:String,
                           val device_token:String,
                           val device_type:String)
