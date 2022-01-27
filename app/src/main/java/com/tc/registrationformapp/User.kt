package com.tc.registrationformapp

import java.io.Serializable

//data class to hold all inputted information
data class User(
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val country: String,
    val password: String
) : Serializable {
    fun getFullName() = "$title $firstName $lastName"
}
