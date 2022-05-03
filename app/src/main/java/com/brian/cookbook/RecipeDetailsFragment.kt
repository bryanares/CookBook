package com.brian.cookbook

import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class RecipeDetailsFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_recipe_details)

        val recipeImage = findViewById<ImageView>(R.id.description_image)
        val recipeTitle = findViewById<TextView>(R.id.description_title)
        val recipeSummary = findViewById<TextView>(R.id.description_summary)
        val recipeInstruction = findViewById<TextView>(R.id.description_instructions)
        val recipeIngredients = findViewById<TextView>(R.id.description_ingredients)

        recipeTitle.text = intent.getStringExtra("RecipeTitle").toString()
        recipeSummary.text = Html.fromHtml(intent.getStringExtra("RecipeSummary").toString())
        recipeInstruction.text = Html.fromHtml(intent.getStringExtra("RecipeInstructions").toString())
        recipeIngredients.text = intent.getStringExtra("RecipeIngredients").toString()
        Picasso.get().load(intent.getStringExtra("RecipeImage")).into(recipeImage)

    }
}