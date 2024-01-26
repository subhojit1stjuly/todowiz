package com.reprototyperstech.todowiz.core.repository.remote.model

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String
)