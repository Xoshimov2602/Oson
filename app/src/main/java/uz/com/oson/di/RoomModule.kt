package uz.com.oson.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.com.oson.domain.local.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {


    @[Provides Singleton]
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "Users.db")
            .build()

    @[Provides Singleton]
    fun providesUserDao(database: AppDatabase) = database.userDao()

}
