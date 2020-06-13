package com.company.invite.factory

import com.company.invite.controller.CommandController
import com.company.invite.controller.CommandControllerImpl
import com.company.invite.model.Customer
import com.company.invite.service.*
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

object Factory {
    fun getDistanceCalculatorService(): DistanceCalculatorService = DistanceCalculatorInKMServiceImpl()

    fun getFileService(): FileService = FileServiceImpl()

    fun getProcessorService(): ProcessorService = ProcessorServiceImpl()

    fun getObjectMapper(): ObjectMapper = ObjectMapper().
        configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)

    fun getCommandController(): CommandController = CommandControllerImpl()

    fun getCommandService(): CommandService = CommandServiceImpl()
}