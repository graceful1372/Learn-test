package ir.hmb72.trainingunittesttodo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import ir.hmb72.trainingunittesttodo.data.repository.TaskRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    private var _task = MutableLiveData<List<TaskEntity>>()
    val task :LiveData<List<TaskEntity>> = _task
    fun getAllTask() = viewModelScope.launch {
        _task.value = repository.getAllTask()
    }
}
