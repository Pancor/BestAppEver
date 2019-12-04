package pl.pancordev.bestappever.locations.repository

import pl.pancordev.bestappever.locations.domain.LocationDescription
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationRepository {

    private val api: TypicodeApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(TYPICODE_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(TypicodeApi::class.java)
    }

    suspend fun getCitiesFromServer() = api.getAllCities()

    fun getLocationDescriptions(): List<LocationDescription> {
        //val fromServer = api.getAllCities()
        return listOf(
            LocationDescription(5, "Najwyższa wiklinowa żyrafa w Europie", "https://static.wixstatic.com/media/92a131_26a0e399fed048e4bcae47b20bfd2fb2.jpg/v1/fill/w_630,h_417,al_c,q_80,usm_0.66_1.00_0.01/92a131_26a0e399fed048e4bcae47b20bfd2fb2.webp", "Rumia, Polska"),
            LocationDescription(6, "Gdyńska ryba", "https://zasoby.ekologia.pl/artykulyNew/23455/xxl/carp-2393788-960-720_800x600.jpg", "Gdynia, Polska"),
            LocationDescription(7, "Latająca taczka z Szóstki", "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-8/s960x960/22254764_1966718096875351_127425821230839056_o.jpg?_nc_cat=106&_nc_ohc=zOQH1Zhc_vYAQmihTgHloRZI2lUaqbOJAbGzqrY_n2aFLMQcyJvkNHfpg&_nc_ht=scontent-waw1-1.xx&oh=6395a24cd9bcd41bc876382a480ffe52&oe=5E745D37", "LO VI, Gdynia, Polska"),
            LocationDescription(1, "Down Town", "https://q-cf.bstatic.com/images/hotel/max500/874/87483184.jpg", "New York, United States of America"),
            LocationDescription(2, "Szmelta", "https://upload.wikimedia.org/wikipedia/commons/4/4b/Rumia_z_powietrza.JPG", "Rumia, Polska"),
            LocationDescription(3, "UMG", "https://static2.s-trojmiasto.pl/zdj/c/n/9/2137/620x0/2137451-Zmiana-nazwy-to-dla-uczelni-pewnego-rodzaju-nobilitacja-a-dla-studentow-ktorzy.jpg", "Gdynia, Polska"),
            LocationDescription(4, "Elektryk", "https://szkolnictwo.pl/zdj/B0/B00155.jpg", "Wejherowo, Polska")
        )
    }
}