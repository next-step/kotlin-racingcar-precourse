package controller

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingControllerTest {
    private val racingController = RacingController()

    companion object {
        val testCar1 = Car("test1", 10)
        val testCar2 = Car("test2", 100)
        val testCar3 = Car("test3", 9)
        val testCar4 = Car("test4", 10)
    }

    @Test
    @DisplayName("우승자 계산 로직 test - 같은 점수가 있는 경우, 우승자가 여러명이다.")
    fun calculateWinnersTest_sameDistance() {
        // given
        val inputWinners = listOf(testCar1, testCar4, testCar3)
        val expectedWinners = listOf(testCar1, testCar4)

        // when
        val winners = racingController.calculateWinner(inputWinners)

        // then
        assertThat(winners).containsExactlyInAnyOrderElementsOf(expectedWinners)
    }

    @Test
    @DisplayName("우승자 계산 로직 test - 가장 높은 점수가 우승자다.")
    fun calculateWinnersTest() {
        // given
        val inputWinners = listOf(testCar1, testCar2, testCar4, testCar3)
        val expectedWinners = listOf(testCar2)

        // when
        val winners = racingController.calculateWinner(inputWinners)

        // then
        assertThat(winners).hasSize(1)
        assertThat(winners).containsExactlyInAnyOrderElementsOf(expectedWinners)
    }
}