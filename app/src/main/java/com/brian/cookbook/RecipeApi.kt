package com.brian.cookbook

import com.brian.cookbook.models.RandomRecipeApiResponse
import com.brian.cookbook.models.Recipe
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApi {

    @GET("/recipes/random?apiKey=934d129abf3a4e2d88b14b0230b9f9bc&number=10")
    suspend fun getRandomRecipes() : Response<RandomRecipeApiResponse>
}