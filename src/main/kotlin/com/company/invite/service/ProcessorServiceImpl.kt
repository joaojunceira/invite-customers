package com.company.invite.service

import com.company.invite.factory.Factory
import com.company.invite.model.Coordinates
import com.company.invite.model.Customer
import java.io.InputStream
import kotlin.streams.asSequence

class ProcessorServiceImpl : ProcessorService {
    private val objectMapper = Factory.getObjectMapper()
    private val distance = Factory.getDistanceCalculatorService()

    override fun process(inputStream: InputStream, destination: Coordinates, range: Double): List<Customer> {
        return inputStream.use { a ->
            a.bufferedReader().lines().asSequence().map { mapToCustomer(it) }.
            filter { isInRange(it, destination, range) }.sortedBy { it.userId }.toList()
        }
    }

    private fun isInRange(customer: Customer, destination: Coordinates, range: Double) =
        distance.calculateInKm(
            Coordinates(
                customer.longitude,
                customer.latitude
            ), destination) <= range

    private fun mapToCustomer(line: String): Customer =
        objectMapper.readValue(line, Customer::class.java)
}