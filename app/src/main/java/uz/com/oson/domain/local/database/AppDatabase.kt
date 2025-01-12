package uz.com.oson.domain.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.com.oson.domain.local.dao.UserDao
import uz.com.oson.domain.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase  : RoomDatabase(){
    abstract fun userDao () : UserDao
}