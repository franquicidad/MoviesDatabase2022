package com.example.moviesdatabase.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.moviesdatabase.R
import com.example.moviesdatabase.databinding.DetailFragmentBinding
import com.example.moviesdatabase.databinding.MainMoviesFragmentBinding
import com.example.moviesdatabase.util.loadUrl

class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val detailViewModel: DetailViewModel by viewModels()

    private var _binding: DetailFragmentBinding? = null

    private val binding get() = _binding!!

    var typeMovieOrTv: String? = null
    var theSelectedRecyclerViewid: Int? = null
    var movieName: String? = null
    var overview: String? = null
    var posterImage: String? = null
    var rating: Double? = null
    var lang: String? = null
    var release: String? = null
    var backdropImage: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        typeMovieOrTv = arguments?.getString("movieOrTv")
        theSelectedRecyclerViewid = arguments?.getInt("id")
        movieName = arguments?.getString("movieName")
        overview = arguments?.getString("overview")
        posterImage = arguments?.getString("poster")
        rating = arguments?.getDouble("rating")
        lang = arguments?.getString("lang")
        release = arguments?.getString("release")
        backdropImage = arguments?.getString("backimage")



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        UpdateUI()
        binding.toolBarDetail.setOnClickListener{
            findNavController().popBackStack()
        }
    }


    private fun UpdateUI() {
        with(binding){
            movieNameTextView.text = movieName
            movieImageView.loadUrl(posterImage.toString())
        }
    }
}