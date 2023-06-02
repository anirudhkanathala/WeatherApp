package com.weatherapp.data

import java.io.Serializable

data class LocationData(
    val latitude: Double,
    val longitude: Double
) : Serializable