package com.company.invite.mvc

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates

class CommandControllerImpl: CommandController {
    private val commandService = Factory.getCommandService()

    override fun execute(requestModel: RequestModel): MessageView {
        return MessageView(commandService.execute(
            originFilePath = requestModel.originFile,
            destinationFilePath = requestModel.outputFile,
            destinationCoordinates = Coordinates(
                requestModel.destinationLongitude, requestModel.destinationLatitude),
            range = requestModel.range
        ))
    }
}