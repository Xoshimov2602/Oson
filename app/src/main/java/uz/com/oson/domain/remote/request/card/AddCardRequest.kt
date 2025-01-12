package uz.com.oson.domain.remote.request.card

import com.google.gson.annotations.SerializedName

data class AddCardRequest(
    val pan : String,
    @SerializedName("expired-year") val expiredYear : String,
     @SerializedName("expired-month") val expiredMonth : String,
    val name : String
)
