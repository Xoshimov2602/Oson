package uz.com.oson.domain.remote.response.auth

import com.google.gson.annotations.SerializedName

data class VerifyResponse(
    @SerializedName("refresh-token") val refreshToken : String,
    @SerializedName("access-token") val accessToken : String
)
