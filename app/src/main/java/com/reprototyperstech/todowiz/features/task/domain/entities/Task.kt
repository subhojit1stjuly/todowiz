package com.reprototyperstech.todowiz.features.task.domain.entities
import java.sql.Date

data class Task(
    val id: Int,
    val title: String,
    val desc: String,
    val priority: Int,
    val category: Int,
    val dueOn: Date,
    val completedOn: Date,
    val isCompleted: Boolean,
    val subTaskId: Int?
)