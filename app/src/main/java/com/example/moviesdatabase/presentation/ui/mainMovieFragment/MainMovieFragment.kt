package com.example.moviesdatabase.presentation.ui.mainMovieFragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesdatabase.R
import com.example.moviesdatabase.data.connectivityManager.ConnectionLiveData
import com.example.moviesdatabase.databinding.MainMoviesFragmentBinding
import com.example.moviesdatabase.presentation.adapters.MovieAdapter
import com.example.moviesdatabase.presentation.adapters.MovieByChipAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMovieFragment : Fragment() {

    private var _binding: MainMoviesFragmentBinding? = null
    private lateinit var connectionLiveData: ConnectionLiveData
    private val binding get() = _binding!!

    private val viewModel: MainMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = MainMoviesFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        connectionLiveData = ConnectionLiveData(requireActivity())
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUpcomingMovies()
        viewModel.getTopRatedMovies()
        viewModel.getSpanishMovies()
        viewModel.getNinetyThreeMovies()
        viewModel.getNetworkConnection()
        showSpanishRecyclerView()

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

        binding.spanishChip.setOnClickListener {
            showSpanishRecyclerView()
        }

        binding.chipByYear.setOnClickListener {
            viewModel.getNinetyThreeMovies()
            viewModel.recyclerNinetyThree.observe(viewLifecycleOwner) { ninetyThree ->
                binding.recyclerByChip.apply {
                    adapter = MovieByChipAdapter(ninetyThree)
                }
            }

            viewModel.isNetworkAvailable.observe(viewLifecycleOwner) { isNetworkAvailable ->
                val textForNetwork = isNetworkAvailable.value
                if (textForNetwork == true) {
                    binding.networkConnectionBoolean.visibility = View.GONE
                } else {
                    binding.networkConnectionBoolean.visibility = View.VISIBLE
                    binding.networkConnectionBoolean.text = resources.getText(R.string.no_internet)
                }
            }

        }
    }


    private fun showSpanishRecyclerView() {
        viewModel.recyclerSpanish.observe(viewLifecycleOwner) { spanishList ->
            binding.recyclerByChip.apply {
                adapter = MovieByChipAdapter(spanishList)
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
