package service

import model.RacingCarModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.RacingCarView

class RacingCarServiceTest {
    private lateinit var models: MutableList<RacingCarModel>
    private lateinit var view: RacingCarView
    private lateinit var service: RacingCarService

    @BeforeEach
    fun setRacingCarTest() {
        models = mutableListOf()
        view = object : RacingCarView() {
            override fun enterInputValue(): String? = null
            override fun printCarName() {}
            override fun printRacingCount() {}
            override fun printErrorMessage(message: String?) {}
            override fun printEmptyLine() {}
            override fun printGameResult() {}
            override fun printRacingCar(name: String, race: Int) {}
            override fun printGameWinner(winner: String) {}
        }
        service = RacingCarService(models, view)
    }

    @Test
    fun createRacingCarTest() {
        val cars = listOf("blue", "uvo", "gcs")

        service.createRacingCar(cars)

        assertThat(models).hasSize(3)
        assertThat(models.map { it.car }).isEqualTo(cars)
        assertThat(models.map { it.race }).containsOnly(0)
    }

    @Test
    fun updateRacingCarTest() {
        val cars = listOf("blue", "uvo", "gcs")
        models.addAll(cars.map { RacingCarModel(it,0) })

        service.updateRacingCar()

        assertThat(models).hasSize(3)
        assertThat(models.map { it.car }).isEqualTo(cars)
        assertThat(models.map { it.race }).allMatch { it == 0 || it == 1}
    }

    @Test
    fun findRacingCarWinnerTest() {
        models.addAll(listOf(RacingCarModel("blue",3), RacingCarModel("uvo",2), RacingCarModel("gcs",3)))

        service.findRacingCarWinner()

        assertThat(models.maxOfOrNull { it.race }).isEqualTo(3)
        assertThat(models.filter { it.race == 3 }.joinToString(", ") { it.car }).isEqualTo("blue, gcs")
    }
}