package com.example.foodsurvey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodsurvey.databinding.FragmentFoodPreferencesBinding

class FoodPreferencesFragment : Fragment() {

    private var _binding: FragmentFoodPreferencesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodPreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitFoodPreferences.setOnClickListener {
            val favoriteCuisine = when (binding.radioGroupCuisine.checkedRadioButtonId) {
                R.id.radioCuisineChinese -> "Chinese"
                R.id.radioCuisineFrench -> "French"
                R.id.radioCuisineItalian -> "Italian"
                R.id.radioCuisineIndian -> "Indian"
                R.id.radioCuisineJapanese -> "Japanese"
                R.id.radioCuisineThai -> "Thai"
                R.id.radioCuisineTurkish -> "Turkish"
                else -> "Unknown"
            }
            val eatOutFrequency = when (binding.radioGroupEatOut.checkedRadioButtonId) {
                R.id.radioEatOutNever -> "Never"
                R.id.radioEatOutRarely -> "Rarely"
                R.id.radioEatOutSometimes -> "Sometimes"
                R.id.radioEatOutFrequently -> "Frequently"
                else -> "Unknown"
            }
            val prefersSpicy = binding.radioGroupSpicy.checkedRadioButtonId == R.id.radioSpicyYes
            val prefersVegetarian = binding.radioGroupVegetarian.checkedRadioButtonId == R.id.radioVegetarianYes
            val prefersSeafood = binding.radioGroupSeafood.checkedRadioButtonId == R.id.radioSeafoodYes

            // Output the results
            val results = """
                Favorite Cuisine: $favoriteCuisine
                Eat Out Frequency: $eatOutFrequency
                Prefers Spicy: ${prefersSpicy.toYesNoString()}
                Prefers Vegetarian: ${prefersVegetarian.toYesNoString()}
                Prefers Seafood: ${prefersSeafood.toYesNoString()}
            """.trimIndent()

            // Show the results in a Toast
            Toast.makeText(requireContext(), results, Toast.LENGTH_LONG).show()

            // Optionally navigate away or clear the survey
            // findNavController().navigate(...)
        }
    }

    private fun Boolean.toYesNoString() = if (this) "Yes" else "No"

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
