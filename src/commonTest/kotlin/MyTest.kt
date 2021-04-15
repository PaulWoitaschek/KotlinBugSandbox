import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus
import kotlin.test.Test

class MyTest {

    @Test
    fun test(){
        println(LocalDate(2020, 1, 1).plus(1, DateTimeUnit.DAY))
    }
}