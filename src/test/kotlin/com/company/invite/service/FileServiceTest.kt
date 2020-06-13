package com.company.invite.service

import com.company.invite.exception.DomainException
import com.company.invite.factory.Factory
import com.company.invite.model.Customer
import com.company.invite.util.FileUtils.getFilePath
import com.company.invite.util.FileUtils.getTempFilePath
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileInputStream

class FileServiceTest {
    private val fileService = Factory.getFileService()

    @Test
    fun `read file should be open successfully`() {
        val path = getFilePath("singleEntry.txt")
        val inputStream = fileService.readFile(path)
        assertTrue(inputStream.available()>0)
    }

    @Test
    fun `wrong file path read should fail with Exception`() {
        val path = "noFile.txt"
        val expectedMessage = "File not found for path: noFile.txt"
        val exception = assertThrows<DomainException> {
            fileService.readFile(path)
        }
        assertEquals(expectedMessage, exception.message)
    }

    @Test
    fun `correct file path write should write successfully`() {
        val path = getTempFilePath("output.txt")
        fileService.writeFile(path, listOf(
            Customer(latitude = 52.986375, userId = 12,
            name = "Christina McArdle", longitude = -6.043701)
        ))
        FileInputStream(path).use {
            assertTrue(it.available()>0)
        }
    }

    @Test
    fun `empty list should create empty file`() {
        val path = getTempFilePath("output.txt")
        fileService.writeFile(path, emptyList())
        FileInputStream(path).use {
            assertTrue(it.available()==0)
        }
    }
}