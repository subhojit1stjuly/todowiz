package com.reprototyperstech.todowiz.features.priority.domain.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Priority(
    val id: Int,
    val level: String,
    val colorCode:String
)
