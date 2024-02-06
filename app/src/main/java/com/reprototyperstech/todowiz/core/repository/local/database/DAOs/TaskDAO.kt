package com.reprototyperstech.todowiz.core.repository.local.database.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.reprototyperstech.todowiz.features.task.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface TaskDAO {
    @Query(
        "SELECT * FROM TaskEntity WHERE " +
                "(:titleKeyword IS NULL OR title LIKE '%' || :titleKeyword || '%') AND " +
                "(:dueDate IS NULL OR dueOn > :dueDate) AND " +
                "(:isCompleted IS NULL OR isCompleted = :isCompleted) AND" +
                "(:category IS NULL OR category = :category) AND" +
                "(:priority IS NULL OR priority = :priority)"
    )
    fun getFilteredTasks(
        titleKeyword: String?,
        dueDate: Date?,
        isCompleted: Boolean,
        category: Int,
        priority: Int
    ): Flow<List<TaskEntity>>

    @Query("SELECT * FROM TaskEntity WHERE Task_id =:id")
    suspend fun getTaskDetails(id: Int): TaskEntity

    @Query("SELECT * FROM TaskEntity WHERE Task_id in (:ids)")
    suspend fun getAllSubTask(ids:String):List<TaskEntity>

    @Insert
    suspend fun addTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Query("DELETE FROM TaskEntity WHERE Task_id = :id")
    suspend fun delete(id: Int)
}