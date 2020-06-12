package com.company.invite.service

import com.company.invite.model.Coordinates
import com.company.invite.model.Customer
import java.io.InputStream

interface ProcessorService {
    fun process(inputStream: InputStream, destination: Coordinates, range: Double): List<Customer>
}