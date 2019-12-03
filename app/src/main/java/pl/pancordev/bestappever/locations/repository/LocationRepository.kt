package pl.pancordev.bestappever.locations.repository

import pl.pancordev.bestappever.locations.domain.LocationDescription

class LocationRepository {

    fun getLocationDescriptions(): List<LocationDescription> {
        return listOf(
            LocationDescription(5, "Najwyższa wiklinowa żyrafa w Europie", "https://static.wixstatic.com/media/92a131_26a0e399fed048e4bcae47b20bfd2fb2.jpg/v1/fill/w_630,h_417,al_c,q_80,usm_0.66_1.00_0.01/92a131_26a0e399fed048e4bcae47b20bfd2fb2.webp", "Rumia, Polska"),
            LocationDescription(1, "Down Town", "https://q-cf.bstatic.com/images/hotel/max500/874/87483184.jpg", "New York, United States of America"),
            LocationDescription(2, "Szmelta", "https://upload.wikimedia.org/wikipedia/commons/4/4b/Rumia_z_powietrza.JPG", "Rumia, Polska"),
            LocationDescription(3, "UMG", "https://static2.s-trojmiasto.pl/zdj/c/n/9/2137/620x0/2137451-Zmiana-nazwy-to-dla-uczelni-pewnego-rodzaju-nobilitacja-a-dla-studentow-ktorzy.jpg", "Gdynia, Polska"),
            LocationDescription(4, "Elektryk", "https://szkolnictwo.pl/zdj/B0/B00155.jpg", "Wejherowo, Polska")
        )
    }
}