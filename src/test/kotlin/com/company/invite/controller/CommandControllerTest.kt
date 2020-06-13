package com.company.invite.controller

import com.company.invite.factory.Factory
import com.company.invite.util.FileUtils
import com.company.invite.view.RequestView
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.FileInputStream

class CommandControllerTest {
    private val commandController = Factory.getCommandController()

    @Test
    fun `empty file input should return empty file`() {
        val originFilePath = FileUtils.getFilePath("empty.txt")
        val destinationFilePath = FileUtils.getTempFilePath("invalidCoordinatesOutput.txt")
        val range = 100.0
        val requestView = RequestView(
            originFile = originFilePath, outputFile = destinationFilePath,
            destinationLatitude = 53.339428, destinationLongitude = -6.257664, range = range
        )
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandController.execute(requestView).message
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `input file with 5 entries should return all entries`() {
        val originFilePath = FileUtils.getFilePath("fiveEntries.txt")
        val destinationFilePath = FileUtils.getTempFilePath("invalidCoordinatesOutput.txt")
        val range = 1000.0
        val requestView = RequestView(
            originFile = originFilePath, outputFile = destinationFilePath,
            destinationLatitude = 53.339428, destinationLongitude = -6.257664, range = range
        )
        val expectedEntries = 5
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandController.execute(requestView).message
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `provided file with range zero should return empty file`() {
        val originFilePath = FileUtils.getFilePath("customers.txt")
        val destinationFilePath = FileUtils.getTempFilePath("invalidCoordinatesOutput.txt")
        val range = 0.0
        val requestView = RequestView(
            originFile = originFilePath, outputFile = destinationFilePath,
            destinationLatitude = 53.339428, destinationLongitude = -6.257664, range = range
        )
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandController.execute(requestView).message
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `invalid coordinates should return empty file`() {
        val originFilePath = FileUtils.getFilePath("customers.txt")
        val destinationFilePath = FileUtils.getTempFilePath("invalidCoordinatesOutput.txt")
        val range = 100.0
        val requestView = RequestView(
            originFile = originFilePath, outputFile = destinationFilePath,
            destinationLatitude = -53.339428, destinationLongitude = -126.257664, range = range
        )
        val expectedEntries = 0
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandController.execute(requestView).message
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }

    @Test
    fun `provided file should return successfully with supplied inputs`() {
        val originFilePath = FileUtils.getFilePath("customers.txt")
        val destinationFilePath = FileUtils.getTempFilePath("output.txt")
        val range = 100.0
        val requestView = RequestView(
            originFile = originFilePath, outputFile = destinationFilePath,
            destinationLatitude = 53.339428, destinationLongitude = -6.257664, range = range
        )
        val expectedEntries = 16
        val expected = "File Processed Successfully with $expectedEntries entries"
        val actual = commandController.execute(requestView).message
        assertEquals(expected, actual)
        FileInputStream(destinationFilePath).use {
            assertEquals(expectedEntries.toLong(), it.bufferedReader().lines().count())
        }
    }
}