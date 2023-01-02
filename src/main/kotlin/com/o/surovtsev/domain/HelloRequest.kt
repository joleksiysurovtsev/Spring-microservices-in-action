package com.o.surovtsev.domain

data class HelloRequest(
    val firstName: String,
    val lastName: String
) {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}
