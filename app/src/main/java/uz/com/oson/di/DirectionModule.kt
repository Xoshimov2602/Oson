package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.com.oson.directions.MainDirections
import uz.com.oson.utils.MainContract

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {
    @Binds
    fun bindsMainDirections(impl: MainDirections): MainContract.Directions
}