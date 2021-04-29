package com.dicoding.movieapp.data.source.remote

data class SearchDetailShowResponse(
	val originalLanguage: String? = null,
	val numberOfEpisodes: Int? = null,
	val networks: List<NetworksItem?>? = null,
	val type: String? = null,
	val backdropPath: String? = null,
	val genres: List<GenresItem?>? = null,
	val popularity: Double? = null,
	val productionCountries: List<ProductionCountriesItem?>? = null,
	val id: Int? = null,
	val numberOfSeasons: Int? = null,
	val voteCount: Int? = null,
	val firstAirDate: String? = null,
	val overview: String? = null,
	val seasons: List<SeasonsItem?>? = null,
	val languages: List<String?>? = null,
	val createdBy: List<CreatedByItem?>? = null,
	val lastEpisodeToAir: LastEpisodeToAir? = null,
	val posterPath: String? = null,
	val originCountry: List<String?>? = null,
	val spokenLanguages: List<SpokenLanguagesItem?>? = null,
	val productionCompanies: List<ProductionCompaniesItem?>? = null,
	val originalName: String? = null,
	val voteAverage: Double? = null,
	val name: String? = null,
	val tagline: String? = null,
	val episodeRunTime: List<Int?>? = null,
	val nextEpisodeToAir: Any? = null,
	val inProduction: Boolean? = null,
	val lastAirDate: String? = null,
	val homepage: String? = null,
	val status: String? = null
)

data class LastEpisodeToAir(
	val productionCode: String? = null,
	val airDate: String? = null,
	val overview: String? = null,
	val episodeNumber: Int? = null,
	val voteAverage: Int? = null,
	val name: String? = null,
	val seasonNumber: Int? = null,
	val id: Int? = null,
	val stillPath: String? = null,
	val voteCount: Int? = null
)

data class SpokenLanguagesItem(
	val name: String? = null,
	val iso6391: String? = null,
	val englishName: String? = null
)

data class ProductionCountriesItem(
	val iso31661: String? = null,
	val name: String? = null
)

data class GenresItem(
	val name: String? = null,
	val id: Int? = null
)

data class CreatedByItem(
	val gender: Int? = null,
	val creditId: String? = null,
	val name: String? = null,
	val profilePath: Any? = null,
	val id: Int? = null
)

data class NetworksItem(
	val logoPath: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val originCountry: String? = null
)

data class SeasonsItem(
	val airDate: String? = null,
	val overview: String? = null,
	val episodeCount: Int? = null,
	val name: String? = null,
	val seasonNumber: Int? = null,
	val id: Int? = null,
	val posterPath: Any? = null
)

data class ProductionCompaniesItem(
	val logoPath: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val originCountry: String? = null
)

