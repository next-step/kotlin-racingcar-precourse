import controller.RacingController
import model.RacingCar
import model.RacingCarRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.RacingCarView

class RacingCarTest {
    private lateinit var racingCarRepository: RacingCarRepository
    private lateinit var racingCarView: RacingCarView
    private lateinit var racingController: RacingController

    @BeforeEach
    fun setUp() {
        racingCarView = RacingCarView()
        racingCarRepository = RacingCarRepository()
        racingController = RacingController(racingCarView, racingCarRepository)

        val racingCarList = mutableListOf<RacingCar>(
            RacingCar("kwak", 0),
            RacingCar("kim", 0),
            RacingCar("ahn", 5),
        )
        racingCarRepository.addRacingCar(racingCarList)
        racingCarRepository.setRacingCount(1)
    }

    @Test
    fun `Create Racing Car`() {
        val racingCar = RacingCar("kwak", 0)
        assertThat(racingCar).isNotNull()
        assertThat(racingCar.name).isEqualTo("kwak")
    }

    @Test
    fun `Validation for Car List`() {
        assertThat(racingCarRepository.getAllRacingCar()).isNotNull()
        assertThat(racingCarRepository.getAllRacingCar()[0].name).isEqualTo("kwak")
    }

    @Test
    fun `Check a racing Count`() {
        val racingCount = racingCarRepository.getRacingCount()
        assertThat(racingCount).isNotNull()
        assertThat(racingCount).isEqualTo(1)
    }

    @Test
    fun `Play racing`() {
        racingController.playRacing()
        val racingWinner = racingCarRepository.getFinalWinner()
        assertThat(racingWinner).isNotNull()
        assertThat(racingWinner).isEqualTo("ahn")
    }
}
