package pl.pancordev.bestappever.locations.repository

import retrofit2.http.GET

val TYPICODE_ENDPOINT = "https://my-json-server.typicode.com/rmielnik/samplejson/"

interface TypicodeApi {

    @GET("cities")
    suspend fun getAllCities(): List<CityDto>
}