package ir.hmb72.trainingunittesttodo.data.repository

import ir.hmb72.trainingunittesttodo.data.database.DaoTask
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import javax.inject.Inject

class TaskRepository @Inject constructor(private val dao: DaoTask) {

    suspend fun insert(entity: TaskEntity) = dao.insert(entity)
//    suspend fun update(entity: TaskEntity) = dao.update(entity)
//    suspend fun delete(entity: TaskEntity) = dao.delete(entity)
    fun getAllTask() = dao.getAllTasks()


}