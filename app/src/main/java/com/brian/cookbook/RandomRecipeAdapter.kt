package com.brian.cookbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.brian.cookbook.databinding.RecipeItemBinding
import com.brian.cookbook.models.Recipe

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
            recipeImage.setImageURI(currentRecipe.image)
            recipeTitle.text = currentRecipe.title
            recipeIngredients.text = currentRecipe.extendedIngredients.toString()
            recipeInstructions.text = currentRecipe.instructions
        }
    }

    override fun getItemCount(): Int {
       return recipes.size
    }

}

private fun ImageView.setImageURI(image: String) {


}
