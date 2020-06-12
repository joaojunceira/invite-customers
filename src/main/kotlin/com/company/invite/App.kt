package com.company.invite

import com.company.invite.factory.Factory
import com.company.invite.mvc.RequestModel

fun main(args: Array<String>) {
    val requestModel = RequestModel(
        originFile = args[0],
        outputFile = args[1],
        destinationLatitude = args[2].toDouble(),
        destinationLongitude = args[3].toDouble(),
        range = args[4].toDouble()
    )
    val commandController = Factory.getCommandController()
    val message = commandController.execute(requestModel).message
    println(message)
}