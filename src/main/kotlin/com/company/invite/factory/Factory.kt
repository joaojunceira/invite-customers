package com.company.invite.factory

import com.company.invite.mvc.CommandController
import com.company.invite.mvc.CommandControllerImpl
import com.company.invite.service.*
import com.fasterxml.jackson.databind.ObjectMapper

object Factory {
    fun getDistanceCalculatorService(): DistanceCalculatorService = DistanceCalculatorServiceImpl()

    fun getFileService(): FileService = FileServiceImpl()

    fun getProcessorService(): ProcessorService = ProcessorServiceImpl()

    fun getObjectMapper(): ObjectMapper = ObjectMapper()

    fun getCommandController(): CommandController = CommandControllerImpl()

    fun getCommandService(): CommandService = CommandServiceImpl()
}