package com.dicoding.movieapp.data.source.local

data class TVShowDetailEntity(
    var showId: String,
    var director: String,
    var overview: String,
    var trailerLink: String,
    var trailerThumbnail: String,
    var cast: ArrayList<ActorEntity>
)