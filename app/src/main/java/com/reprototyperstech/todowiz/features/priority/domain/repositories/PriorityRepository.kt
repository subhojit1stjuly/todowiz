package com.reprototyperstech.todowiz.features.priority.domain.repositories

import com.reprototyperstech.todowiz.core.repository.local.database.DAOs.PriorityDAO
import com.reprototyperstech.todowiz.features.priority.data.repositories.PriorityRepositoryImpl

interface PriorityRepository {
    companion object{
        fun getPriorityRepository(dao: PriorityDAO):PriorityRepository{
            return PriorityRepositoryImpl(dao)
        }
    }
}