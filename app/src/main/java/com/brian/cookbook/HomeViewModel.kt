package com.brian.cookbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brian.cookbook.models.Recipe

class HomeViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes


}