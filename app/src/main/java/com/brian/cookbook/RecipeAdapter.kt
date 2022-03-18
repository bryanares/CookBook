package com.brian.cookbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brian.cookbook.databinding.RecipeItemBinding

private lateinit var binding: RecipeItemBinding

class RecipeAdapter (var recipes: List<Recipe>): RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: RecipeItemBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecipeItemBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.apply {
            val currentRecipe = recipes[position]
            recipeImage.setImageResource(currentRecipe.recipeImage)
            recipeTitle.text = currentRecipe.recipeTitle
            recipeIngredients.text = currentRecipe.recipeIngredients
            recipeInstructions.text = currentRecipe.recipeInstructions
        }
    }

    override fun getItemCount(): Int {
       return recipes.size
    }

}