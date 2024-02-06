package com.reprototyperstech.todowiz.features.task.domain.repositories

import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.TaskDAO
import com.reprototyperstech.todowiz.features.task.data.entities.TaskEntity
import com.reprototyperstech.todowiz.features.task.data.repositories.TaskRepositoryImpl
import com.reprototyperstech.todowiz.features.task.domain.entities.Task
import kotlinx.coroutines.flow.Flow
import java.sql.Date

interface TaskRepository {

    fun getFilteredTasks(
        titleKeyword: String?,
        dueDate: Date?,
        isCompleted: Boolean,
        category: Int,
        priority: Int
    ): Flow<List<Task>>

    suspend fun add(task: Task)
    suspend fun update(task: Task)
    suspend fun delete(id: Int)

    companion object{
        @JvmStatic
        fun getRepository(dao:TaskDAO): TaskRepository {
            return TaskRepositoryImpl(dao)
        }
    }
}