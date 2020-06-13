package com.company.invite.service

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistanceCalculatorServiceTest {
    private val distanceCalculatorCalculatorService: DistanceCalculatorService = Factory.getDistanceCalculatorService()

    @Test
    fun `distance when both coordinates are the same should return zero`() {
        val coordinates =
            Coordinates(latitude = 52.986375, longitude = -6.043701)
        val distance = distanceCalculatorCalculatorService.calculate(coordinates, coordinates)
        assertEquals(0.0, distance)
    }

    @Test
    fun `distance when both coordinates are less than 1 km`() {
        val origin = Coordinates(
            latitude = 53.3412033,
            longitude = -6.2504976
        )
        val destination = Coordinates(
            latitude = 53.3408891,
            longitude = -6.2504718
        )
        val distance = distanceCalculatorCalculatorService.calculate(origin, destination)
        assertEquals(0.034979502829466616, distance)
    }

    @Test
    fun `distance when coordinates are more than 1000 km`() {
        val origin = Coordinates(
            latitude = 53.337433437129675,
            longitude = -6.262207031250001
        )
        val destination = Coordinates(
            latitude = 52.23789234942133,
            longitude = 21.011352539062504
        )
        val distance = distanceCalculatorCalculatorService.calculate(origin, destination)
        assertEquals(1826.9438829342037, distance)
    }
}