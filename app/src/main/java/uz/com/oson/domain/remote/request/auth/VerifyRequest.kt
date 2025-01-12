package uz.com.oson.domain.remote.request.auth

data class VerifyRequest(
    val token : String,
    val code : String
)
