package com.danik.tutuapp.presentation.screens.xml.list_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danik.tutuapp.R
import com.danik.tutuapp.databinding.ActivityMainBinding
import com.danik.tutuapp.databinding.FragmentListBinding
import com.danik.tutuapp.domain.model.Train
import com.danik.tutuapp.presentation.screens.xml.main_screen.TrainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {


    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private var heroes: Flow<PagingData<Train>>? = null
    private var heroAdapter: TrainAdapter? = null

    private val listScreenViewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("ListFragment", "onCreate")
        super.onCreate(savedInstanceState)
        heroes = listScreenViewModel.allTrains
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("ListFragment", "onCreateView")
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)



        heroAdapter = TrainAdapter()
        lifecycleScope.launch {

            heroes?.collectLatest {
                heroAdapter?.submitData(it)
            }
        }

        Log.d("ListFragment", "$heroes")
        binding.bindAdapter(heroAdapter)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

private fun FragmentListBinding.bindAdapter(trainAdapter: TrainAdapter?) {
    list.adapter = trainAdapter
    list.layoutManager = LinearLayoutManager(list.context)
    val decoration = DividerItemDecoration(list.context, DividerItemDecoration.VERTICAL)
    list.addItemDecoration(decoration)
}
