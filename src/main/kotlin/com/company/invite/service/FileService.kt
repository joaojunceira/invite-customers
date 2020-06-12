package com.company.invite.service

import com.company.invite.model.Customer
import java.io.InputStream

interface FileService {
    fun readFile(path: String): InputStream

    fun writeFile(path: String, customers: List<Customer>)
}