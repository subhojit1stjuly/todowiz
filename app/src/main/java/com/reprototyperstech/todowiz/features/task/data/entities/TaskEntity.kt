package com.reprototyperstech.todowiz.features.task.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.reprototyperstech.todowiz.features.category.data.entities.CategoryEntity
import com.reprototyperstech.todowiz.features.priority.data.entities.PriorityEntity
import java.sql.Date

@Entity(
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = arrayOf("Category_id"),
        childColumns = arrayOf("category"),
        onDelete = CASCADE
    ), ForeignKey(
        entity = PriorityEntity::class,
        parentColumns = arrayOf("Priority_id"),
        childColumns = arrayOf("priority"),
        onDelete = CASCADE
    )]
)
data class TaskEntity(
    @ColumnInfo(name = "Task_id")@PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "category") val category: Int,
    @ColumnInfo(name = "dueOn") val dueOn:Date,
    @ColumnInfo(name = "completedOn") val completedOn:Date,
    @ColumnInfo(name = "isCompleted") val isCompleted:Boolean,
    @ColumnInfo(name = "subTaskId") val subTaskId:Int?
)