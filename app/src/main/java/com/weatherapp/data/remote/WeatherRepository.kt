package com.weatherapp.data.remote

import com.weatherapp.data.LocationData
import com.weatherapp.data.model.WeatherModel
import com.weatherapp.data.service.weatherservice.WeatherApi
import com.weatherapp.utils.Constants
import java.net.UnknownHostException

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val networkMapper: NetworkMapper,
) {
    suspend fun getWeatherDataWithCityName(cityName: String): WeatherModel? {
        try {
            val weatherData = weatherApi.getWeatherDataWithCityName(
                cityName,
                Constants.NetworkService.API_KEY
            )
            StatusCode.statusCode = weatherData.code()
            return weatherData.body()?.let { networkMapper.mapFromEntity(it) }
        } catch (e: UnknownHostException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getWeatherDataWithLocation(locationData: LocationData): WeatherModel? {
        try {
            val weatherData = weatherApi.getWeatherDataWithLocation(
                locationData.latitude,
                locationData.longitude,
                Constants.NetworkService.API_KEY
            )
            StatusCode.statusCode = weatherData.code()
            return weatherData.body()?.let { networkMapper.mapFromEntity(it) }
        } catch (e: UnknownHostException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }
}