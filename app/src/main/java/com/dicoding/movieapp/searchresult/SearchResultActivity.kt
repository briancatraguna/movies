package com.dicoding.movieapp.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.data.source.remote.ApiConfig
import com.dicoding.movieapp.data.source.remote.MoviesItem
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.data.source.remote.SearchMovieResponse
import com.dicoding.movieapp.databinding.ActivitySearchResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultActivity : AppCompatActivity() {

    private lateinit var searchResultActivity: ActivitySearchResultBinding

    companion object {
        const val EXTRA_SEARCH = "extra_search"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchResultActivity = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(searchResultActivity.root)

        val dataSrc = RemoteDataSource.getInstance()
        getData()

        searchResultActivity.testIntent.text = "hello"

        searchResultActivity.toolbarSearchResults.backButton.setOnClickListener{
            finish()
        }
    }

    private fun getData() {
        val client = ApiConfig.getApiService().getMovies("john")
        client.enqueue(object : Callback<SearchMovieResponse> {
            override fun onResponse(
                    call: Call<SearchMovieResponse>,
                    response: Response<SearchMovieResponse>
            ) {
                var listMovies: ArrayList<MoviesItem> = ArrayList<MoviesItem>()
                if (response.isSuccessful) {
                    val rawList = response.body()?.results!!
                    for (item in rawList) {
                        listMovies.add(item)
                    }
                    searchResultActivity.testIntent.text = listMovies[0].overview
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
            }

        })
    }
}