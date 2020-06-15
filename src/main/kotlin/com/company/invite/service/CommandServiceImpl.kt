package com.company.invite.service

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import java.util.logging.Logger

class CommandServiceImpl: CommandService {
    private val processorService = Factory.getProcessorService()
    private val fileService = Factory.getFileService()
    private val logger = Logger.getLogger(CommandServiceImpl::javaClass.name)

    override fun execute(originFilePath: String, destinationFilePath: String,
                         destinationCoordinates: Coordinates, range: Double): String {
        return try {
            val originFile = fileService.readFile(originFilePath)
            val customers = processorService.process(originFile, destinationCoordinates, range)
            fileService.writeFile(destinationFilePath, customers)
            "File Processed Successfully with ${customers.size} entries"
        } catch (e: Exception) {
            logger.warning { e.message }
            "Processing aborted with error: ${e.message.orEmpty()}"
        }
    }
}