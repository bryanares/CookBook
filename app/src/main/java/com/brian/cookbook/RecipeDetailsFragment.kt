package com.brian.cookbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.brian.cookbook.databinding.FragmentHomeBinding
import com.brian.cookbook.databinding.FragmentRecipeDetailsBinding


class RecipeDetailsFragment : Fragment() {
    private var _binding: FragmentRecipeDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val args: RecipeDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)

        /*val recipeImage = args.image
        val recipeTitle = args.title*/

        binding.descriptionImage.setOnClickListener { Navigation.findNavController(binding.root).navigate(R.id.action_recipeDetailsFragment_to_homeFragment) }
        return binding.root
    }

}