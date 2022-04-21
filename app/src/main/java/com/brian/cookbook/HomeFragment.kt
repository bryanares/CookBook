package com.brian.cookbook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brian.cookbook.databinding.FragmentHomeBinding
import com.brian.cookbook.models.RandomRecipeApiResponse
import com.brian.cookbook.models.Recipe
import retrofit2.HttpException
import java.io.IOException

const val TAG = "HomeFragment"
private lateinit var recipeAdapter: RecipeAdapter

class HomeFragment : Fragment(), RecipeAdapter.OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*view?.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToRecipeDetailsFragment(this.toString(), this.toString())
            Navigation.findNavController(binding.root)
                .navigate(action)
        }*/


        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recipeAdapter = RecipeAdapter(mutableListOf(), this)
        val adapter = recipeAdapter
        binding.rvRecipes.apply {
            binding.rvRecipes.adapter = adapter
            binding.rvRecipes.layoutManager =
                LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        }
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getRandomRecipes()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, You may not have an internet connection")
                binding.progressBar.isVisible = false
                return@launchWhenCreated

            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                recipeAdapter.recipes = response.body()!!.recipes
            } else {
                Log.e(TAG, "Response not successful")
            }
            binding.progressBar.isVisible = false
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this.context, "Recipe $position clicked", Toast.LENGTH_SHORT).show()
        val action = HomeFragmentDirections.actionHomeFragmentToRecipeDetailsFragment(String(), String())
        Navigation.findNavController(binding.root)
            .navigate(action)
        val clickedItem = position
        recipeAdapter.notifyItemChanged(position)
    }


}

