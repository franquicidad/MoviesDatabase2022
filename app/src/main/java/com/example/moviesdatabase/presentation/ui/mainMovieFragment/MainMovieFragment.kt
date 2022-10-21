package com.example.moviesdatabase.presentation.ui.mainMovieFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesdatabase.databinding.MainMoviesFragmentBinding
import com.example.moviesdatabase.presentation.adapters.MovieAdapter
import com.example.moviesdatabase.presentation.adapters.MovieByChipAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMovieFragment : Fragment() {

    private var _binding: MainMoviesFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel:MainMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainMoviesFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            viewModel.recyclerNinetyThree.observe(viewLifecycleOwner) { ninetyThree ->
                binding.recyclerByChip.apply {
                    adapter = MovieByChipAdapter(ninetyThree)
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}