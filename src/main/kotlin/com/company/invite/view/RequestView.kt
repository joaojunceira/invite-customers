package com.company.invite.view

data class RequestView(val originFile: String,
                       val outputFile: String,
                       val destinationLatitude: String,
                       val destinationLongitude: String,
                       val range: String
)