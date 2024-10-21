package ir.hmb72.trainingunittesttodo.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity


@Dao
interface DaoTask {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TaskEntity)

    @Query("SELECT * FROM task_table")
     fun getAllTasks(): List<TaskEntity>
}