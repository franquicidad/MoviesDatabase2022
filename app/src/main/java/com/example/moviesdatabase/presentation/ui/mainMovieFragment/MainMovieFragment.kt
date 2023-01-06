package com.example.moviesdatabase.presentation.ui.mainMovieFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesdatabase.databinding.MainMoviesFragmentBinding
import com.example.moviesdatabase.presentation.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMovieFragment : Fragment() {

    private var _binding: MainMoviesFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = MainMoviesFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGetMainScreenMovies()

        viewModel.recyclerUpcoming.observe(viewLifecycleOwner) { upcomingList ->
            binding.recyclerUpcoming.apply {
                adapter = MovieAdapter(upcomingList)
            }
        }

        viewModel.recyclerTopRated.observe(viewLifecycleOwner) { topRatedList ->
            binding.recyclerTopRated.apply {
                adapter = MovieAdapter(topRatedList)
            }
        }

        viewModel.isNetworkAvailable.observe(viewLifecycleOwner) { isNetworkAvailable ->
            if (isNetworkAvailable.hasConnectivity) {
                binding.noInternetConnectivity.root.visibility = View.GONE
            } else {
                binding.noInternetConnectivity.root.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
