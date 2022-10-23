package com.example.moviesdatabase.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesdatabase.R
import com.example.moviesdatabase.databinding.MovieItemBinding
import com.example.moviesdatabase.domain.model.MoviesDto

class MovieByChipAdapter(private val movieList: List<MoviesDto>): RecyclerView.Adapter<MovieByChipAdapter.Holder>() {
    private var navController: NavController? = null
    private var bundle: Bundle? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        val model: MoviesDto = movieList[position]
        holder.bind(movieList[position], position)
        holder.itemView.setOnClickListener {
            navController = Navigation.findNavController(it)
            val movieOrTv = "movie"
            val url = MovieAdapter.IMAGE_URL + model.poster_path
            val backImage = MovieAdapter.IMAGE_URL + model.backdrop_path

            bundle = bundleOf(
                "movieOrTv" to movieOrTv,
                "id" to model.id.toString(),
                "movieName" to model.title,
                "overview" to model.overview,
                "poster" to url,
                "lang" to model.original_language,
                "release" to model.release_date,
                "backimage" to backImage,
            )

            navController?.let {
                navController!!.navigate(R.id.action_navigation_main_movies_fragment_to_navigation_detail_fragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return 6
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding = MovieItemBinding.bind(itemView)

        fun bind(movie: MoviesDto, position:Int){
            val url = IMAGE_URL + movie.poster_path
            Glide.with(itemView).load(url).into(binding.movieImageView)
            binding.movieTextView.text = movie.title

        }

    }

    companion object{
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"
    }

}
