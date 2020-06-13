package com.company.invite.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class Customer(@JsonProperty("user_id") val userId: Long,
                    @JsonProperty("name") val name: String,
                    @JsonProperty("latitude") val latitude: Double,
                    @JsonProperty("longitude") val longitude: Double): Serializable