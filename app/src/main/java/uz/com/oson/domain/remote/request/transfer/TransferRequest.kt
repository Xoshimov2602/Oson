package uz.com.oson.domain.remote.request.transfer

import com.google.gson.annotations.SerializedName

data class TransferRequest(
    val type : String,
    @SerializedName("sender-id") val senderId : String,
    @SerializedName("receiver-pan") val receiverPan : String,
    val amount : Int
)
