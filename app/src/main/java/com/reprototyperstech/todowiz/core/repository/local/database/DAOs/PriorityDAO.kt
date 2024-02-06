package com.reprototyperstech.todowiz.core.repository.local.database.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.reprototyperstech.todowiz.features.priority.data.entities.PriorityEntity

@Dao
interface PriorityDAO {

    @Query("SELECT * FROM PriorityEntity")
    suspend fun getAllPriority():List<PriorityEntity>

    @Insert
    suspend fun addPriority(priorityEntity: PriorityEntity)
    @Update
    suspend fun update(priorityEntity: PriorityEntity)
}