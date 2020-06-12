package com.company.invite.service

import com.company.invite.model.Coordinates

interface CommandService {
    fun execute(originFilePath: String, destinationFilePath: String,
                destinationCoordinates: Coordinates, range: Double): String
}