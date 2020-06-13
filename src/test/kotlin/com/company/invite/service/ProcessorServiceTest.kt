package com.company.invite.service

import com.company.invite.exception.DomainException
import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import com.company.invite.model.Customer
import com.company.invite.util.FileUtils.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProcessorServiceTest {
    private val processorService: ProcessorService = Factory.getProcessorService()

    @Test
    fun `invalid input with badly formatted JSON should throw exception`() {
        val inputStream = loadFile("badlyJson.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        assertThrows<DomainException> {
            processorService.process(inputStream, destination, 10.0)
        }
    }

    @Test
    fun `empty input stream should create empty list`() {
        val inputStream = loadFile("empty.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        val list = processorService.process(inputStream, destination, 1000.0)
        assertTrue(list.isEmpty())
    }

    @Test
    fun `empty latitude and longitude in JSON should throw an Exception`() {
        val inputStream = loadFile("wrongCoordinates.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        val expectedMessage =
            """Invalid Entry: {"latitude": "52.986375", "user_id": 12, "name": "Christina McArdle", "longitude": null}"""
        val exception = assertThrows<DomainException> {
            processorService.process(inputStream, destination, 1000.0)
        }
        assertEquals(expectedMessage, exception.message)
    }

    @Test
    fun `empty user id should be throw an Exception`() {
        val inputStream = loadFile("wrongUserId.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        val expectedMessage =
            """Invalid Entry: {"latitude": "52.986375", "user_id": null, "name": "Christina McArdle", "longitude": "-6.043701"}"""
        val exception = assertThrows<DomainException> {
            processorService.process(inputStream, destination, 1000.0)
        }
        assertEquals(expectedMessage, exception.message)
    }

    @Test
    fun `single entry in file should be processed successfully`() {
        val inputStream = loadFile("singleEntry.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        val expectedSize = 1
        val expectedEntry = Customer(latitude = 52.986375, userId = 12,
            name = "Christina McArdle", longitude = -6.043701)
        val list = processorService.process(inputStream, destination, 10000.0)
        assertEquals(expectedSize, list.size)
        assertEquals(expectedEntry, list.first())
    }

    @Test
    fun `5 entries in file should be processed successfully`() {
        val inputStream = loadFile("fiveEntries.txt")
        val destination =
            Coordinates(latitude = 53.339428, longitude = -6.257664)
        val expectedSize = 1
        val list = processorService.process(inputStream, destination, 100.0)
        assertEquals(expectedSize, list.size)
    }
}