package uz.com.oson.domain.remote.response.transfer

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
   @SerializedName("total-elements") val totalElements : Int,
    @SerializedName ("total-pages") val totalPages : Int,
   @SerializedName("current-page") val currentPage : Int,
    val child : List<HistoryItems>
)

data class HistoryItems (
    val type : String,
    val from : String,
    val to  :String,
    val amount : Int,
    val time : Long
)
