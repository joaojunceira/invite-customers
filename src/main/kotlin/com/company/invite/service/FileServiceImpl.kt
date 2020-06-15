package com.company.invite.service

import com.company.invite.exception.DomainException
import com.company.invite.factory.Factory
import com.company.invite.model.Customer
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.logging.Logger

class FileServiceImpl: FileService {
    private val logger = Logger.getLogger(FileServiceImpl::javaClass.name)
    private val objectMapper = Factory.getObjectMapper()

    override fun readFile(path: String): InputStream {
        return try {
            FileInputStream(path)
        } catch (e: Exception) {
            logger.warning { e.message }
            throw DomainException("File not found for path: $path")
        }
    }

    override fun writeFile(path: String, customers: List<Customer>) {
        try {
            val file = File(path)
            file.createNewFile()
            val fileOutputStream = FileOutputStream(file)
            fileOutputStream.bufferedWriter().use {
                customers.forEach { a ->
                    it.appendln(objectMapper.writeValueAsString(a))
                }
            }
        } catch (e: Exception) {
            logger.warning { e.message }
            throw DomainException("Failed to write in Output file")
        }

    }
}