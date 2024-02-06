package com.reprototyperstech.todowiz.features.task.data.repositories

import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.TaskDAO
import com.reprototyperstech.todowiz.features.task.data.entities.TaskEntity
import com.reprototyperstech.todowiz.features.task.domain.entities.Task
import com.reprototyperstech.todowiz.features.task.domain.repositories.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.sql.Date

class TaskRepositoryImpl(private val dao: TaskDAO) : TaskRepository {
    override fun getFilteredTasks(
        titleKeyword: String?,
        dueDate: Date?,
        isCompleted: Boolean,
        category: Int,
        priority: Int
    ): Flow<List<Task>> = dao.getFilteredTasks(
        titleKeyword = titleKeyword,
        dueDate = dueDate,
        isCompleted = isCompleted,
        category = category,
        priority = priority
    ).flowOn(Dispatchers.IO)
        .distinctUntilChanged()
        .map { entities -> entities.map { it.toTask() } }


    override suspend fun add(task: Task) = withContext(Dispatchers.IO) {
        dao.addTask(task.toTaskEntity())
    }

    override suspend fun update(task: Task) {
        dao.updateTask(task.toTaskEntity())
    }

    override suspend fun delete(id: Int) {
        dao.delete(id)
    }

    private fun Task.toTaskEntity(): TaskEntity {
        return TaskEntity(
            id = id,
            title = title,
            desc = desc,
            priority = priority,
            category = category,
            dueOn = dueOn,
            completedOn = completedOn,
            isCompleted = isCompleted,
            subTaskId = subTaskId
        )
    }

    private fun TaskEntity.toTask(): Task {
        return Task(
            id = id,
            title = title,
            desc = desc,
            priority = priority,
            category = category,
            dueOn = dueOn,
            completedOn = completedOn,
            isCompleted = isCompleted,
            subTaskId = subTaskId
        )
    }
}