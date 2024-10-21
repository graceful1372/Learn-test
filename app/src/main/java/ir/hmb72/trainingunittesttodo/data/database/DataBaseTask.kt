package ir.hmb72.trainingunittesttodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity


@Database(entities = [TaskEntity::class] , version =  1 , exportSchema = false )
abstract class DataBaseTask :RoomDatabase(){
    abstract fun DaoTask():DaoTask
}