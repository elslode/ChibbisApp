package com.elslode.chibbistestapp.presentation.review

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
import com.elslode.chibbistestapp.AppChibbis
import com.elslode.chibbistestapp.databinding.FragmentReviewBinding
import com.elslode.chibbistestapp.presentation.State
import com.elslode.chibbistestapp.presentation.ViewModelFactory
import com.elslode.chibbistestapp.presentation.review.adapterReview.ReviewAdapter
import javax.inject.Inject


class ReviewFragment : Fragment() {

    private var _binding: FragmentReviewBinding? = null
    private val binding: FragmentReviewBinding
        get() = _binding ?: throw RuntimeException("FragmentReviewBinding is null")

    private val component by lazy {
        (requireActivity().application as AppChibbis).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mViewModel: ViewModelReviews

    private val adapter by lazy {
        ReviewAdapter(activity?.applicationContext as Application)
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
        _binding = FragmentReviewBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this, viewModelFactory)[ViewModelReviews::class.java]
        binding.rvReview.adapter = adapter

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.reviewList.observe(viewLifecycleOwner){
            when(it.status) {
                State.LOADING -> {
                    binding.progressBarReview.isVisible = true
                }
                State.ERROR -> {
                    binding.progressBarReview.isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                State.SUCCESS -> {
                    binding.progressBarReview.isVisible = false
                    adapter.submitList(it.data)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ReviewFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}