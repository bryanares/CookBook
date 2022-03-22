package com.brian.cookbook.models

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)