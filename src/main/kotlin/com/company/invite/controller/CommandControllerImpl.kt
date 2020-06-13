package com.company.invite.controller

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import com.company.invite.view.MessageView
import com.company.invite.view.RequestView

class CommandControllerImpl: CommandController {
    private val commandService = Factory.getCommandService()

    override fun execute(requestView: RequestView): MessageView {
        return MessageView(
            commandService.execute(
                originFilePath = requestView.originFile,
                destinationFilePath = requestView.outputFile,
                destinationCoordinates = Coordinates(
                    requestView.destinationLongitude, requestView.destinationLatitude
                ),
                range = requestView.range
            )
        )
    }
}