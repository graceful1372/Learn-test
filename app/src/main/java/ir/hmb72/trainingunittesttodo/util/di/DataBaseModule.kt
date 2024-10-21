package ir.hmb72.trainingunittesttodo.util.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.hmb72.trainingunittesttodo.data.database.DaoTask
import ir.hmb72.trainingunittesttodo.data.database.DataBaseTask
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideEntity() = TaskEntity()

    @Provides
    @Singleton
    fun provideDaoTask (db:DataBaseTask) = db.DaoTask()

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context:Context) = Room.databaseBuilder(
        context , DataBaseTask::class.java , "task_database"
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()


}