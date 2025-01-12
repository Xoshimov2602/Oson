package uz.com.oson.domain.remote.request.transfer

data class TransferVerifyRequest(
    val token  :String,
    val code : String
)
