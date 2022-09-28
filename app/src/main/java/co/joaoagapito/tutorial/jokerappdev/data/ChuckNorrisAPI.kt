package co.joaoagapito.tutorial.jokerappdev.data

import co.joaoagapito.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey: String = HTTPClient.API_Key): Call<List<String>>

    @GET("jokes/random")
    fun findRandom(@Query("category") categoryName: String? = null, @Query("apiKey") apiKey: String = HTTPClient.API_Key): Call<Joke>
}