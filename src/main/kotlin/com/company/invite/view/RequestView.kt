package com.company.invite.view

data class RequestView(val originFile: String,
                       val outputFile: String,
                       val destinationLatitude: Double,
                       val destinationLongitude: Double,
                       val range: Double
)