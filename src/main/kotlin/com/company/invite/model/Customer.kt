package com.company.invite.model

import java.io.Serializable

data class Customer(val userId: Long,
                    val name: String,
                    val latitude: Double,
                    val longitude: Double): Serializable