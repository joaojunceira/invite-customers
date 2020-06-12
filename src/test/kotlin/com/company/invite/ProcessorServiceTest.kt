package com.company.invite

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import com.company.invite.service.ProcessorService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProcessorServiceTest {
    private val processorService: ProcessorService = Factory.getProcessorService()

    @Test
    fun `invalid input with badly formatted JSON should throw exception`() {
        val inputStream = this.javaClass.classLoader.getResourceAsStream("badlyJson.txt")!!
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        assertThrows<Exception> {
            processorService.process(inputStream, destination, 10.0)
        }
    }

    @Test
    fun `empty input stream should create empty file`() {

    }

    @Test
    fun `empty latitude and longitude in JSON should be ignored while processing`() {

    }

    @Test
    fun `empty user id should be ignored in processing`() {

    }

    @Test
    fun `single entry in file should be processed successfully`() {
        val inputStream = this.javaClass.classLoader.getResourceAsStream("singleEntry.txt")!!
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        processorService.process(inputStream, destination, 10000.0)
    }

    @Test
    fun `10 randomly generated entries in file should be processed successfully`() {

    }

    @Test
    fun `100 randomly generated entries in file should be processed successfully`() {

    }
}