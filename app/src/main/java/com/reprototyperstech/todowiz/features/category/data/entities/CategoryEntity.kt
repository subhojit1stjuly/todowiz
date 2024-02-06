package com.reprototyperstech.todowiz.features.category.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CategoryEntity")
data class CategoryEntity(
    @ColumnInfo(name = "Category_id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val colorCode: String,
    @ColumnInfo(name = "subCategory") val subCategory: Int?
)