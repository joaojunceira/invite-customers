package com.company.invite.service

import com.company.invite.model.Coordinates

interface DistanceCalculatorService {
    fun calculate(origin: Coordinates, destination: Coordinates): Double
}