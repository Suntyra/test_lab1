import org.junit.jupiter.api.Test
import ru.suntyra.domain.*
import kotlin.test.assertNotNull

class DomainTest {
    @Test
    fun writeBook(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        writer.writeBook()
        assertNotNull(writer.book, "Книга не написанна")
    }

    @Test
    fun addSomeStringInBook(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        writer.writeBook()
        writer.addSomeStringInBook()
        assertNotNull(writer.book.informations[1], "Не добавлена информация")
    }

    @Test
    fun travelToAnotherPlace(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.go(Place.BLACKHOLE)
        redactor.go(Place.MERCURY)
        assert(writer.location != Place.EARTH) { "Писатель не переместился" }
        assert(redactor.location != Place.EARTH) { "Редактор не переместился" }
    }

    @Test
    fun checkBookInformationInterestForHighQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.go(Place.BLACKHOLE)
        writer.addSomeStringInBook()
        writer.go(Place.NEBULA)
        writer.addSomeStringInBook()
        val quality= redactor.checkBookInformationInterest(writer)
        assert(quality == BookQuality.HIGH_QUALITY) {"Книга несовершенна"}
    }

    @Test
    fun checkBookInformationInterestForMediumQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.addSomeStringInBook()
        writer.go(Place.NEBULA)
        writer.addSomeStringInBook()
        writer.go(Place.QUASAR)
        writer.addSomeStringInBook()
        writer.addSomeStringInBook()
        writer.go(Place.MERCURY)
        writer.addSomeStringInBook()
        val quality= redactor.checkBookInformationInterest(writer)
        assert(quality == BookQuality.MEDIUM_QUALITY) {"Эта книга не является среднячком"}
    }

    @Test
    fun checkBookInformationInterestForLowQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.addSomeStringInBook()
        writer.addSomeStringInBook()
        writer.go(Place.VENUS)
        writer.addSomeStringInBook()
        writer.addSomeStringInBook()
        val quality= redactor.checkBookInformationInterest(writer)
        assert(quality == BookQuality.LOW_QUALITY) {"Книга не ужасна"}
    }

    @Test
    fun checkCurrentInformationInterestForHighQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.go(Place.BLACKHOLE)
        writer.addSomeStringInBook()
        writer.go(Place.NEBULA)
        writer.addSomeStringInBook()
        val quality = redactor.checkCurrentInformationInterest(writer, writer.book.pageNumber - 1)
        assert(quality == BookQuality.HIGH_QUALITY) {"Данное место в книге несовершенно"}
    }

    @Test
    fun checkCurrentInformationInterestForMediumQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.go(Place.BLACKHOLE)
        writer.addSomeStringInBook()
        writer.addSomeStringInBook()
        val quality = redactor.checkCurrentInformationInterest(writer, writer.book.pageNumber - 1)
        assert(quality == BookQuality.MEDIUM_QUALITY) {"Данное место в книге не является среднячком"}
    }

    @Test
    fun checkCurrentInformationInterestForLowQuality(){
        val writer = Writer("Artem","Zaitsev",Place.EARTH)
        val redactor = Redactor("Vasia","Ivanov",Place.EARTH)
        writer.writeBook()
        writer.addSomeStringInBook()
        val quality = redactor.checkCurrentInformationInterest(writer, writer.book.pageNumber - 1)
        assert(quality == BookQuality.LOW_QUALITY) {"Данное место в книге не ужасно"}
    }
}
