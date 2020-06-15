package com.company.invite

import com.company.invite.factory.Factory
import com.company.invite.view.RequestView


fun main(args: Array<String>) {
    if (args.size < 5) {
        println("Invalid Arguments")
    }
    val requestModel = RequestView(
        originFile = args[0],
        outputFile = args[1],
        destinationLatitude = args[2],
        destinationLongitude = args[3],
        range = args[4]
    )
    val commandController = Factory.getCommandController()
    val message = try {
        commandController.execute(requestModel).message
    } catch (e: RuntimeException) {
        e.message
    }
    println(message)
}