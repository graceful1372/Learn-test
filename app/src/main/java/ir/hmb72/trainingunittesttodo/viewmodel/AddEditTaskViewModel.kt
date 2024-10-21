package ir.hmb72.trainingunittesttodo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import ir.hmb72.trainingunittesttodo.data.repository.TaskRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    fun insertTask(entity: TaskEntity) = viewModelScope.launch {
        repository.insert(entity)
    }
}
