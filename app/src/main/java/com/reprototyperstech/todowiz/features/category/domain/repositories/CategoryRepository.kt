package com.reprototyperstech.todowiz.features.category.domain.repositories

import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.CategoryDAO
import com.reprototyperstech.todowiz.features.category.data.repositories.CategoryRepositoryImpl
import com.reprototyperstech.todowiz.features.category.domain.entities.Category

interface CategoryRepository {
    suspend fun getAllCategory():List<Category>
    suspend fun add(category: Category)
    suspend fun update(category: Category)
    companion object{
        @JvmStatic
        fun getCategoryRepository(dao:CategoryDAO):CategoryRepository{
            return CategoryRepositoryImpl(dao)
        }
    }
}