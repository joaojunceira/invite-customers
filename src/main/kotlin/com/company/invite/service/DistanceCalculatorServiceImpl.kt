package com.company.invite.service

import com.company.invite.model.Coordinates
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class DistanceCalculatorServiceImpl : DistanceCalculatorService {
    private val earthRadiusInKm = 6371

    override fun calculateInKm(origin: Coordinates, destination: Coordinates): Double {
        val distanceRadians = calculateDistanceRadians(origin.toRadians(), destination.toRadians())
        return distanceRadians * earthRadiusInKm
    }

    private fun Coordinates.toRadians(): Coordinates =
        Coordinates(
            longitude = Math.toRadians(this.longitude),
            latitude = Math.toRadians(this.latitude)
        )

    private fun calculateDistanceRadians(origin: Coordinates, destination: Coordinates): Double =
        acos(sin(origin.latitude) * sin(destination.latitude) +
                cos(origin.latitude) * cos(destination.latitude) *
                cos(origin.longitude - destination.longitude)
        )
}