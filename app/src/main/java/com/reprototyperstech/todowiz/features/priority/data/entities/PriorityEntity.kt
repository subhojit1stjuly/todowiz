package com.reprototyperstech.todowiz.features.priority.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PriorityEntity")
data class PriorityEntity(
    @ColumnInfo(name = "Priority_id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "level") val level: String,
    @ColumnInfo(name = "color") val colorCode:String
)
