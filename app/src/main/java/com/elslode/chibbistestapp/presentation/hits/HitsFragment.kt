package com.elslode.chibbistestapp.presentation.hits

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.elslode.chibbistestapp.AppChibbis
import com.elslode.chibbistestapp.databinding.FragmentHitsBinding
import com.elslode.chibbistestapp.presentation.State
import com.elslode.chibbistestapp.presentation.ViewModelFactory
import com.elslode.chibbistestapp.presentation.hits.adapters.HitsAdapter
import javax.inject.Inject

class HitsFragment : Fragment() {

    private var _binding: FragmentHitsBinding? = null
    private val binding: FragmentHitsBinding
        get() = _binding ?: throw RuntimeException("FragmentHitsBinding is null")

    private val component by lazy {
        (requireActivity().application as AppChibbis).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mViewModel: ViewModelHits

    //TODO: другой адаптер
    private val adapter by lazy {
        HitsAdapter(activity?.applicationContext as Application)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHitsBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this, viewModelFactory)[ViewModelHits::class.java]

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHits.adapter = adapter
        binding.rvHits.layoutManager = GridLayoutManager(requireContext(), 2)
        mViewModel.hitsList.observe(viewLifecycleOwner){
            when(it.status) {
                State.LOADING -> {
                    binding.progressHits.isVisible = true
                }
                State.ERROR -> {
                    binding.progressHits.isVisible = false
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
                State.SUCCESS -> {
                    binding.progressHits.isVisible = false
                    adapter.submitList(it.data)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HitsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}