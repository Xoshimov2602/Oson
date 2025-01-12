package uz.com.oson.domain.remote.request.auth

data class LoginRequest(
    val phone: String,
    val password: String
)
