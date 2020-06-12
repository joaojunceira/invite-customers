package com.company.invite.mvc

data class RequestModel(val originFile: String,
                        val outputFile: String,
                        val destinationLatitude: Double,
                        val destinationLongitude: Double,
                        val range: Double
)