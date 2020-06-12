package com.company.invite.service

import com.company.invite.factory.Factory
import com.company.invite.model.Customer
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

class FileServiceImpl: FileService {
    private val objectMapper = Factory.getObjectMapper()

    override fun readFile(path: String): InputStream {
        return FileInputStream(path)
    }

    override fun writeFile(path: String, customers: List<Customer>) {
        val fileOutputStream = FileOutputStream(File(path))
        customers.forEach { a ->
            fileOutputStream.use {
                it.bufferedWriter().appendln(objectMapper.writeValueAsString(a))
            }
        }
    }
}