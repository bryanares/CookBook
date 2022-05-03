package com.brian.cookbook.models

data class RandomRecipeApiResponse(
    val recipes: List<Recipe>, val ingredients: List<Ingredient>
)