package com.elslode.chibbistestapp.presentation.restaurants

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
import com.elslode.chibbistestapp.R
import com.elslode.chibbistestapp.databinding.FragmentRestaurantsBinding
import com.elslode.chibbistestapp.presentation.State
import com.elslode.chibbistestapp.presentation.ViewModelFactory
import com.elslode.chibbistestapp.presentation.restaurants.adapters.RestaurantAdapter
import javax.inject.Inject

class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding: FragmentRestaurantsBinding
        get() = _binding ?: throw RuntimeException("FragmentRestaurantsBinding is null")

    private val component by lazy {
        (requireActivity().application as AppChibbis).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mViewModel: ViewModelRestaurants

    private val adapter by lazy {
        RestaurantAdapter(activity?.applicationContext as Application)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this, viewModelFactory)[ViewModelRestaurants::class.java]

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.restaurantList.observe(viewLifecycleOwner){
            when(it.status) {
                State.LOADING -> {
                    binding.progressRestaurant.isVisible = true
                }
                State.ERROR -> {
                    Toast.makeText(requireContext(), requireActivity().application.getString(R.string.error).format(it.message), Toast.LENGTH_SHORT).show()
                    binding.progressRestaurant.isVisible = false
                }
                State.SUCCESS -> {
                    binding.progressRestaurant.isVisible = false
                    binding.restaurantRecyclerView.adapter = adapter
                    adapter.submitList(it.data)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RestaurantFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}