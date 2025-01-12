package uz.com.oson.domain.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.com.oson.domain.local.entity.UserEntity


@Dao
interface UserDao {

    @Query("select * from UserEntity")
    fun getAllUsers () : List<UserEntity>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun addUser (data : UserEntity)

    @Update
    fun updateUser (data : UserEntity)

    @Query("delete  from userentity where :phone = phone")
    fun deleteUser (phone : String)
}