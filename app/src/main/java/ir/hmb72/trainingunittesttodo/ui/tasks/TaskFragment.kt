package ir.hmb72.trainingunittesttodo.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.trainingunittesttodo.R
import ir.hmb72.trainingunittesttodo.data.database.DaoTask
import ir.hmb72.trainingunittesttodo.data.database.DataBaseTask
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import ir.hmb72.trainingunittesttodo.databinding.FragmentAddEditTaskBinding
import ir.hmb72.trainingunittesttodo.databinding.FragmentTaskBinding
import ir.hmb72.trainingunittesttodo.viewmodel.TasksViewModel
import javax.inject.Inject

@AndroidEntryPoint
class TaskFragment : Fragment() {

    //Binding
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    @Inject
     lateinit var adapterTask: AdapterTask

    //Other
    private val viewModel : TasksViewModel by viewModels()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupFab()
        getAllTask()


    }

    private fun setupFab(){
        binding.addTaskFab.setOnClickListener {
            findNavController().navigate(TaskFragmentDirections.actionTaskFragmentToAddEditTaskFragment())
        }
    }

    private fun setupRecyclerView(list:List<TaskEntity>){
        binding.tasksList.apply {
            adapterTask.setData(list)
            adapter = adapterTask
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun getAllTask(){
        viewModel.getAllTask()
        viewModel.task.observe(viewLifecycleOwner){
            setupRecyclerView(it)
        }
    }

}