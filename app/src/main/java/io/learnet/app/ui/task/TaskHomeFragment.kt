package io.learnet.app.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.adapter.TaskHomeAdapter

class TaskHomeFragment : Fragment() {
   val task = DemoTaskCreator.createEmptyTask()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTaskHome = view?.findViewById(R.id.rv_task_home) as RecyclerView
        val taskHomeItems = ArrayList<Any>()
        taskHomeItems.add(task)

        val adapter = TaskHomeAdapter(taskHomeItems)
        rvTaskHome.adapter = adapter
        rvTaskHome.layoutManager = LinearLayoutManager(activity)

    }
}