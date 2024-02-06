package com.reprototyperstech.todowiz.core.repository.local.database.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.reprototyperstech.todowiz.features.category.data.entities.CategoryEntity

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM CategoryEntity")
    suspend fun getAllCategories(): List<CategoryEntity>

    @Query("SELECT * FROM CategoryEntity WHERE Category_id in (:ids)")
    suspend fun getAllSubCategories(ids: String): List<CategoryEntity>

    @Insert
    suspend fun addCategory(categoryEntity: CategoryEntity)

    @Update
    suspend fun update(categoryEntity: CategoryEntity)
}