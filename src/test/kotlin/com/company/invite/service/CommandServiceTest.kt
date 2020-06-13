package com.company.invite.service

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import com.company.invite.util.FileUtils.getFilePath
import com.company.invite.util.FileUtils.getTempFilePath
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.FileInputStream

class CommandServiceTest {
    private val commandService = Factory.getCommandService()

    @Test
    fun `empty file input should return empty file`() {
        val originFilePath = getFilePath("empty.txt")
        val destinationFilePath = getTempFilePath("invalidCoordinatesOutput.txt")
        val destinationCoordinates = Coordinates(latitude = 53.339428, longitude = -6.257664)
        val range = 100.0
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandService.execute(originFilePath, destinationFilePath, destinationCoordinates, range)
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `input file with 5 entries should return all entries`() {
        val originFilePath = getFilePath("fiveEntries.txt")
        val destinationFilePath = getTempFilePath("invalidCoordinatesOutput.txt")
        val destinationCoordinates = Coordinates(latitude = 53.339428, longitude = -6.257664)
        val range = 1000.0
        val expectedEntries = 5
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandService.execute(originFilePath, destinationFilePath, destinationCoordinates, range)
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `provided file with range zero should return empty file`() {
        val originFilePath = getFilePath("customers.txt")
        val destinationFilePath = getTempFilePath("invalidCoordinatesOutput.txt")
        val destinationCoordinates = Coordinates(latitude = 53.339428, longitude = -6.257664)
        val range = 0.0
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandService.execute(originFilePath, destinationFilePath, destinationCoordinates, range)
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `invalid coordinates should return empty file`() {
        val originFilePath = getFilePath("customers.txt")
        val destinationFilePath = getTempFilePath("invalidCoordinatesOutput.txt")
        val destinationCoordinates = Coordinates(latitude = -53.339428, longitude = -126.257664)
        val range = 100.0
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandService.execute(originFilePath, destinationFilePath, destinationCoordinates, range)
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `provided file should return successfully with supplied inputs`() {
        val originFilePath = getFilePath("customers.txt")
        val destinationFilePath = getTempFilePath("output.txt")
        val destinationCoordinates = Coordinates(latitude = 53.339428, longitude = -6.257664)
        val range = 100.0
        val expectedEntries = 16
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandService.execute(originFilePath, destinationFilePath, destinationCoordinates, range)
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }
}