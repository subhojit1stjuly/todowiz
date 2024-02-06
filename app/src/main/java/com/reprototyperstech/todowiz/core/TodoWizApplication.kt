package com.reprototyperstech.todowiz.core

import android.app.Application
import com.reprototyperstech.todowiz.core.repository.local.database.TodoDatabase
import com.reprototyperstech.todowiz.features.category.domain.repositories.CategoryRepository
import com.reprototyperstech.todowiz.features.priority.domain.repositories.PriorityRepository
import com.reprototyperstech.todowiz.features.task.domain.repositories.TaskRepository

class TodoWizApplication: Application() {
   private val localDatabase by lazy { TodoDatabase.getDatabase(this) }
   val taskRepository by lazy { TaskRepository.getRepository(localDatabase.getTaskDao())}
   val categoryRepository by lazy { CategoryRepository.getCategoryRepository(localDatabase.getCategoryDao()) }
   val priorityRepository by lazy { PriorityRepository.getPriorityRepository(localDatabase.getPriorityDao()) }
}