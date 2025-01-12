package uz.com.oson.domain.remote.request.card

data class UpdateCardRequest(
    val id : Int,
    val name : String,
    val themeType : Int,
    val isVisible : Boolean
)
