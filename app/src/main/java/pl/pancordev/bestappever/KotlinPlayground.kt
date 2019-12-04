package pl.pancordev.bestappever

fun main() {
    val personA = Person("Jan", "Kowalski")
    val personB = Person("Jan", "Kowalski")

    if (personA == personB) {
        "EQUALS".log()
    } else {
        "NOT EQUALS".log()
    }

    val screamer = NoisyPerson()
    doScream(screamer)
}

class Person(val name: String, val lastName: String) {

//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (lastName != other.lastName) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + lastName.hashCode()
//        return result
//    }
}

fun doScream(screamer: Screamer) {
    screamer.scream()
}

interface Screamer {

    fun scream()
}

class NoisyPerson : Screamer{
    override fun scream() {
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".log()
    }
}



