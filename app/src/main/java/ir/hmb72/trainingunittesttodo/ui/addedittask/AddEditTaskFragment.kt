package ir.hmb72.trainingunittesttodo.ui.addedittask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.room.Insert
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import ir.hmb72.trainingunittesttodo.databinding.FragmentAddEditTaskBinding
import ir.hmb72.trainingunittesttodo.viewmodel.AddEditTaskViewModel
import ir.hmb72.trainingunittesttodo.viewmodel.TasksViewModel
import javax.inject.Inject

@AndroidEntryPoint
class AddEditTaskFragment : Fragment() {

    //Binding
    private var _binding: FragmentAddEditTaskBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var entity: TaskEntity

    //Other
    private val viewModel: AddEditTaskViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddEditTaskBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        addTask()
    }

    private fun addTask() {
        binding.apply {


            saveTaskFab.setOnClickListener {
                val title = addTaskTitleEditText.text.toString()
                val description = addTaskDescriptionEditText.text.toString()
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    entity.title = title
                    entity.description = description
                    viewModel.insertTask(entity)
                    findNavController().navigateUp()
                }

            }



        }

    }


}
