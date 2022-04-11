package com.brian.cookbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.brian.cookbook.databinding.RecipeItemBinding
import com.brian.cookbook.models.RandomRecipeApiResponse
import com.brian.cookbook.models.Recipe
import com.squareup.picasso.Picasso

private lateinit var binding: RecipeItemBinding

class RecipeAdapter(recipesList: MutableList<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: RecipeItemBinding ) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Recipe>(){
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var recipes: List<Recipe>
    get() = differ.currentList
    set(value) {differ.submitList(value)}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecipeItemBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.apply {
            val currentRecipe = recipes[position]
            Picasso.get().load(currentRecipe.image).into(recipeImage)
            recipeTitle.text = currentRecipe.title
            recipeIngredients.text = currentRecipe.extendedIngredients.toString()
            recipeInstructions.text = currentRecipe.instructions
        }
    }

    override fun getItemCount(): Int {
       return recipes.size
    }

}

