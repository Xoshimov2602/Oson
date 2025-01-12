package uz.com.oson.domain.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val phone : String,
    val password : String,
    val firstName : String,
    val lastName : String,
    val bornDate : String,
    val gender : String
)
