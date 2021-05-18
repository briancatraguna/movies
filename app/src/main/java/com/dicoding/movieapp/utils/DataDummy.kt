package com.dicoding.movieapp.utils

import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.remote.*

object DataDummy {

    fun generateMovies():ArrayList<MovieEntity>{
        val movies = ArrayList<MovieEntity>()
        movies.add(MovieEntity("m1",
            "Yes Day",
            "1h 26m",
            "5.7/10",
            "https://cdn.medcom.id/images/content/2021/03/10/1252510/TysFEX8wtI.jpg"))
        movies.add(MovieEntity("m2",
            "Generasi 90an: Melankolia",
            "1h 31m",
            "6.2/10",
            "https://m.media-amazon.com/images/M/MV5BYTY0Zjg3ZDktZmM3ZC00OGNmLThhYmItMGE3NWQwNWQ3YmM0XkEyXkFqcGdeQXVyMTEzMTI1Mjk3._V1_.jpg"))
        movies.add(MovieEntity("m3",
            "Words on Bathroom Walls",
            "1h 51m",
            "7.1/10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFQZAAZB8qSwDuiwBqa4y_1fccjNasbTK0kdSC-WzWyeCcJD7n"))
        movies.add(MovieEntity("m4",
            "The SpongeBob Movie",
            "1h 40m",
            "6/10",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTNE5quR7o845W3iG0YtBW210Noll9lDgwO5XQBXci5ggyjtVnw"))
        movies.add(MovieEntity("m5",
            "Call",
            "1h 52m",
            "7.1/10",
            "https://www.hancinema.net/photos/fullsizephoto1264293.jpg"))
        movies.add(MovieEntity("m6",
            "Outside the Wire",
            "1h 55m",
            "5.4/10",
            "https://indfim.com/wp-content/uploads/2021/01/MV5BNmM2MWQ0NzktNzU0OS00MjYzLTkxNDYtMzliNTA5ZmNkMmZlXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"))
        movies.add(MovieEntity("m7",
            "The Beast",
            "1h 37m",
            "5.2/10",
            "https://m.media-amazon.com/images/M/MV5BNzRiMzEzN2ItZGI2ZS00MjFkLWFlYWMtMTQ1NzU3YWI1YjdkXkEyXkFqcGdeQXVyNjM3NTM0NDg@._V1_.jpg"))
        movies.add(MovieEntity("m8",
            "Love Like the Falling Rain",
            "1h 26m",
            "4.7/10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhsxrapqHykDQerpjRl5ERtv9kPnn38EtDMKmS-e2WGEF45DRa"))
        movies.add(MovieEntity("m9",
            "Extraction",
            "1h 57m",
            "6.7/10",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRELEr5bWH1Z9ZlYjofDbRoW0ToFJop6YlcJuVU8lAYt2peph_n"))
        movies.add(
            MovieEntity("m10",
            "Pieces of a Woman",
            "2h 8m",
            "7.1/10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoTgSPueDIcI6b6SYpE2YnT45XASKCRxLnzY_NCKJ6-3fVtJKC"))
        return movies
    }

    fun generateTvShows():ArrayList<TVShowEntity>{
        val tvShow = ArrayList<TVShowEntity>()
        tvShow.add(TVShowEntity("s1",
            "Do Do Sol Sol La La Sol",
            "1 season",
            "16 episodes",
            "7.4/10",
            "https://asianwiki.com/images/d/dd/Do_Do_Sol_Sol_La_La_Sol-P1.jpg"))
        tvShow.add(TVShowEntity("s2",
            "Vincenzo",
            "1 season",
            "18 episodes",
            "8.4/10",
            "https://asianwiki.com/images/0/01/Vincenzo-KD-p1.jpg"))
        tvShow.add(TVShowEntity("s3",
            "The Umbrella Academy",
            "2 seasons",
            "10 episodes",
            "8/10",
            "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1595929263/dnpclmigv2ljtw2ickqs.png"))
        tvShow.add(TVShowEntity("s4",
            "Followers",
            "1 season",
            "9 episodes",
            "6.4/10",
            "https://decider.com/wp-content/uploads/2020/02/followers_101_unit_04214-resize.jpg?quality=80&strip=all"))
        tvShow.add(TVShowEntity("s5",
            "Sisyphus: The Myth",
            "1 season",
            "16 episodes",
            "7.1/10",
            "https://mmc.tirto.id/image/2021/01/30/film-sisyphus-netflix_ratio-16x9.jpg"))
        tvShow.add(TVShowEntity("s6",
            "It's Okay to Not Be Okay",
            "1 season",
            "16 episodes",
            "8.7/10",
            "https://asianwiki.com/images/d/d5/It%27s_Okay_to_Not_Be_Okay-CPsm1.jpg"))
        tvShow.add(TVShowEntity("s7",
            "3%",
            "4 seasons",
            "7 episodes",
            "7.4/10",
            "https://m.media-amazon.com/images/M/MV5BNGMzMWFiODMtMmM3Yy00OGQ5LWExZTAtY2VjZDY1ZTliMzNkXkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_.jpg"))
        tvShow.add(TVShowEntity("s8",
            "Start-Up",
            "1 season",
            "16 episodes",
            "8.1/10",
            "https://asianwiki.com/images/d/d9/Start-Up-CP1.jpg"))
        tvShow.add(TVShowEntity("s9",
            "Itaewon Class",
            "1 season",
            "16 episodes",
            "8.2/10",
            "https://asianwiki.com/images/c/c8/Itaewon_Class-mp1.jpg"))
        tvShow.add(TVShowEntity("s10",
            "Money Heist",
            "4 seasons",
            "15 episodes",
            "9.3/10",
            "https://www.blok-a.com/file/2020/12/IMG-20201202-WA0030.jpg"))

        return tvShow
    }

    fun generateFakeMovieResponse(): List<MoviesItem>{
        val result = MoviesItem(
                overview = "The men who made millions from a global economic meltdown.",
                originalLanguage = "en",
                originalTitle = "The Big Short",
                video = false,
                title = "The Big Short",
                genreIds = listOf(35,18),
                posterPath = "/isuQWbJPbjybBEWdcCaBUPmU0XO.jpg",
                backdropPath = "/i7UCf0ysjbYYaqcSKUox9BJz4Kp.jpg",
                releaseDate = "2015-12-11",
                popularity = 28.271,
                voteAverage = 7.3,
                id = 318846,
                adult = false,
                voteCount = 6625
        )
        val myList = listOf<MoviesItem>(result)
        return myList
    }

    fun generateFakeMovieStatus(): Boolean{
        return true
    }

    fun generateFakeShowResponse(): List<ShowsItem>{
        val result = ShowsItem(
                firstAirDate = "2020-01-31",
                overview = "In a colorful Seoul neighborhood, an ex-con and his friends fight a mighty foe to make their ambitious dreams for their street bar a reality.",
                originalLanguage = "ko",
                genreIds = listOf(18),
                posterPath = "/uW91bKQhdkwPLAE2lJJkY5xdyJg.jpg",
                originCountry = listOf("KR"),
                backdropPath = "/rtYQCa2NzX8RspbOmwfAla6BemO.jpg",
                originalName = "이태원 클라쓰",
                popularity = 22.649,
                voteAverage = 8.4,
                name = "Itaewon Class",
                id = 96162,
                voteCount = 47
        )
        val myList = listOf<ShowsItem>(result)
        return myList
    }

    fun generateFakeShowStatus(): Boolean{
        return true
    }

    fun generateFakeMovieDetailResponse(): SearchDetailMovieResponse{
        val detail = SearchDetailMovieResponse(
                originalLanguage = "en",
                imdbId = "tt1596363",
                video = false,
                title = "The Big Short",
                backdropPath = "/i7UCf0ysjbYYaqcSKUox9BJz4Kp.jpg",
                revenue = 133346506,
                genres = listOf(MovieGenresItem(
                        name = "Comedy",
                        id = 35
                )),
                popularity = 28.271,
                movieProductionCountries = listOf(MovieProductionCountriesItem(
                        iso31661 = "US",
                        name = "United States of America"
                )),
                id = 318846,
                voteCount = 6625,
                budget = 28000000,
                overview = "The men who made millions from a global economic meltdown.",
                originalTitle = "The Big Short",
                runtime = 131,
                posterPath = "/isuQWbJPbjybBEWdcCaBUPmU0XO.jpg",
                movieSpokenLanguages = listOf(MovieSpokenLanguagesItem(
                        englishName = "English",
                        iso6391 = "en",
                        name = "English"
                )),
                movieProductionCompanies = listOf(MovieProductionCompaniesItem(
                        logoPath = "/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png",
                        name = "Regency Enterprises",
                        id = 508,
                        originCountry = "US"
                )),
                releaseDate = "2015-12-11",
                voteAverage = 7.3,
                belongsToCollection = null,
                tagline = "The Big Short",
                adult = false,
                homepage = "http://www.thebigshortmovie.com",
                status = "Released"
        )
        return detail
    }

    fun generateFakeShowDetailResponse(): SearchDetailShowResponse{
        val detail = SearchDetailShowResponse(
                originalLanguage = "ko",
                numberOfEpisodes = 16,
                networks = listOf(NetworksItem(
                        logoPath = "/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                        name = "Netflix",
                        id = 213,
                        originCountry = ""
                )),
                type = "Scripted",
                backdropPath = "/rtYQCa2NzX8RspbOmwfAla6BemO.jpg",
                genres = listOf(GenresItem(
                        name = "Drama",
                        id = 18
                )),
                popularity = 22.649,
                productionCountries = listOf(ProductionCountriesItem(
                        iso31661 = "KR",
                        name = "South Korea"
                )),
                id = 96162,
                numberOfSeasons = 1,
                voteCount = 47,
                firstAirDate = "2020-01-31",
                overview = "Yi-seo runs from Geun-won, who's out to put an end to everything. Desperate to salvage his crumbling legacy, Dae-hee heads to DanBam.",
                seasons = listOf(SeasonsItem(
                        airDate = "2020-01-25",
                        overview = "",
                        episodeCount = 1,
                        name = "Specials",
                        seasonNumber = 0,
                        id = 155100,
                        posterPath = null.toString()
                )),
                languages = listOf("ko","oj"),
                createdBy = listOf(CreatedByItem(
                        gender = 0,
                        creditId = "5f477bbbefca000037bb99a9",
                        name = "Gwang Jin",
                        profilePath = null.toString(),
                        id = 2756628
                )),
                lastEpisodeToAir = LastEpisodeToAir(
                        productionCode = "",
                        airDate = "2020-03-21",
                        overview = "Yi-seo runs from Geun-won, who's out to put an end to everything. Desperate to salvage his crumbling legacy, Dae-hee heads to DanBam.",
                        episodeNumber = 16,
                        voteAverage = 0,
                        name = "",
                        seasonNumber = 1,
                        id = 2192802,
                        stillPath = "/bMRTSjadhgF8hZ4JbhXTCUalus.jpg",
                        voteCount = 0
                ),
                posterPath = "/uW91bKQhdkwPLAE2lJJkY5xdyJg.jpg",
                originCountry = listOf("KR"),
                spokenLanguages = listOf(SpokenLanguagesItem(
                        name = "한국어/조선말",
                        iso6391 = "ko",
                        englishName = "Korean"
                )),
                productionCompanies = listOf(ProductionCompaniesItem(
                        logoPath = "/6ZtXJZsAJ4sQNM35ts1G3JeXaBQ.png",
                        name = "Showbox",
                        id = 3491,
                        originCountry = "KR"
                )),
                originalName = "이태원 클라쓰",
                voteAverage = 8.4,
                name = "Itaewon Class",
                tagline = "I want to live a life in which you can’t put a price on your convictions.",
                episodeRunTime = listOf(0),
                nextEpisodeToAir = null.toString(),
                inProduction = false,
                lastAirDate = "2020-03-21",
                homepage = "http://tv.jtbc.joins.com/itaewonclass",
                status = "Ended"
        )
        return detail
    }

    fun getFakeShowRoomDatabase(): List<TvShowsRoomEntity>{
        return listOf(
                getTvShowRoomEntity()
        )
    }

    fun getTvShowRoomEntity(): TvShowsRoomEntity {
        return TvShowsRoomEntity(
                id = 0,
                showId = 96162,
                title = "Itaewon Class",
                avatar = "/uW91bKQhdkwPLAE2lJJkY5xdyJg.jpg",
                releaseDate = "2020-03-21",
                rating = 8.4
        )
    }

    fun getFakeMovieRoomDatabase(): List<MoviesRoomEntity>{
        return listOf(
                getMovieRoomEntity()
        )
    }

    fun getMovieRoomEntity(): MoviesRoomEntity {
        return MoviesRoomEntity(
                id = 0,
                movieId = 318846,
                title = "The Big Short",
                avatar = "/isuQWbJPbjybBEWdcCaBUPmU0XO.jpg",
                releaseDate = "2015-12-11",
                rating = 7.3
        )
    }
}