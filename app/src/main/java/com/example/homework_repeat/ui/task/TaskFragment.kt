package com.example.homework_repeat.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.homework_repeat.R
import com.example.homework_repeat.databinding.FragmentTaskBinding
import com.example.homework_repeat.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDescription.text.toString()
            )
//            data.copy(title = "title")
        setFragmentResult(RESULT_REQUEST_KEY, bundleOf(RESULT_KEY to data))
        findNavController().navigateUp()
        }
    }

    companion object {
    const val RESULT_REQUEST_KEY = "request.key"
    const val RESULT_KEY = "result.key"
    }
}