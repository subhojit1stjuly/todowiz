package com.reprototyperstech.todowiz.features.category.domain.entities

data class Category(
val id: Int,
val name: String,
val colorCode: String = "#FFFFFFFF",
val subCategory: Int?
)
