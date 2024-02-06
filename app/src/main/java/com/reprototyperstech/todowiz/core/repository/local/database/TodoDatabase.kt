package com.reprototyperstech.todowiz.core.repository.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.CategoryDAO
import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.PriorityDAO
import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.TaskDAO
import com.reprototyperstech.todowiz.features.category.data.entities.CategoryEntity
import com.reprototyperstech.todowiz.features.priority.data.entities.PriorityEntity
import com.reprototyperstech.todowiz.core.utils.ToDoWizConstants
import com.reprototyperstech.todowiz.features.task.data.entities.TaskEntity

@Database(
    entities = [TaskEntity::class, PriorityEntity::class, CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDAO
    abstract fun getCategoryDao(): CategoryDAO
    abstract fun getPriorityDao(): PriorityDAO

    companion object {
        private var INSTANCE: TodoDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    ToDoWizConstants.DATABASE
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
}