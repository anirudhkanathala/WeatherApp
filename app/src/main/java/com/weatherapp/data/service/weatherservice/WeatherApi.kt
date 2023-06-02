package com.weatherapp.data.service.weatherservice

import com.weatherapp.data.remote.response.WeatherEntity
import com.weatherapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Constants.NetworkService.END_POINT)
    suspend fun getWeatherDataWithCityName(
        @Query("q") cityName: String,
        @Query("appid") apikey: String,
    ): Response<WeatherEntity>

    @GET(Constants.NetworkService.END_POINT)
    suspend fun getWeatherDataWithLocation(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
    ): Response<WeatherEntity>
}