package com.weatherapp.di.modules

import com.weatherapp.data.remote.NetworkMapper
import com.weatherapp.data.remote.WeatherRepository
import com.weatherapp.data.service.weatherservice.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        weatherApi: WeatherApi,
        networkMapper: NetworkMapper,
    ): WeatherRepository {
        return WeatherRepository(
            weatherApi,
            networkMapper,
        )
    }
}