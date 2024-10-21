package ir.hmb72.trainingunittesttodo.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.hmb72.trainingunittesttodo.data.model.TaskEntity
import ir.hmb72.trainingunittesttodo.databinding.ItemTaskBinding
import javax.inject.Inject

class AdapterTask @Inject constructor() : RecyclerView.Adapter<AdapterTask.ViewHolder>() {

    //binding
    private lateinit var binding: ItemTaskBinding
    private var item = emptyList<TaskEntity>()

    inner class ViewHolder(binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(taskEntity: TaskEntity) {
            binding.apply {
                completeCheckbox.isChecked = taskEntity.complected
                titleText.text = taskEntity.title

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    fun setData(list: List<TaskEntity>) {
        val diffUtil = TaskDiffUtils(item, list)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        item = list
        diffResult.dispatchUpdatesTo(this)
    }

    class TaskDiffUtils(private val oldItem: List<TaskEntity>, private val newItem: List<TaskEntity>) : DiffUtil.Callback() {
        override fun getOldListSize() = oldItem.size

        override fun getNewListSize() = newItem.size


        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }
    }
}