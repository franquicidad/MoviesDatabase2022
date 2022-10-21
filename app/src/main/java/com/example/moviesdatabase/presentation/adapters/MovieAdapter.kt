package com.example.moviesdatabase.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesdatabase.R
import com.example.moviesdatabase.databinding.MovieItemBinding
import com.example.moviesdatabase.domain.model.MoviesDto


class MovieAdapter(private val movieList: List<MoviesDto>): RecyclerView.Adapter<MovieAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        holder.bind(movieList[position], position)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding = MovieItemBinding.bind(itemView)

        fun bind(movie: MoviesDto, position:Int){
            val url = IMAGE_URL + movie.poster_path
            Glide.with(itemView).load(url).into(binding.movieImageView)
            binding.movieTextView.text = movie.title

            itemView.setOnClickListener{
                val bundle = bundleOf(
                    "movieTitle" to movie.title,
                )
            }
        }

    }

    companion object{
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"
    }

}