package com.reprototyperstech.todowiz.features.category.data.repositories

import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.CategoryDAO
import com.reprototyperstech.todowiz.features.category.data.entities.CategoryEntity
import com.reprototyperstech.todowiz.features.category.domain.entities.Category
import com.reprototyperstech.todowiz.features.category.domain.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepositoryImpl(private val dao: CategoryDAO) : CategoryRepository {
    override suspend fun getAllCategory(): List<Category>  {
        return dao.getAllCategories().map { it.toCategory() }
    }

    override suspend fun add(category: Category) = withContext(Dispatchers.IO) {
        dao.addCategory(category.toCategoryEntity())
    }

    override suspend fun update(category: Category) = withContext(Dispatchers.IO){
        dao.update(category.toCategoryEntity())
    }

    private fun Category.toCategoryEntity(): CategoryEntity {
        return CategoryEntity(
            id = id,
            name = name,
            colorCode = colorCode,
            subCategory = subCategory
        )
    }

    private fun CategoryEntity.toCategory(): Category {
        return Category(id = id, name = name, colorCode = colorCode, subCategory = subCategory)
    }


}