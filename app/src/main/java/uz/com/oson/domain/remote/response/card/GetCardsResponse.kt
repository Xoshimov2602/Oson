package uz.com.oson.domain.remote.response.card

data class GetCardsResponse (
    val id : Int,
    val name  :String,
    val amount : Long,
    val owner : String,
    val pan : String,
    val expiredYear : Int,
    val expiredMonth : Int,
    val themeType : Int,
    var isVisible : Boolean
)