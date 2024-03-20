package com.example.foodsurvey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodsurvey.databinding.FragmentSurveySelectionBinding

class SurveySelectionFragment : Fragment() {

    private var binding: FragmentSurveySelectionBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSurveySelectionBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startSurveyButton?.setOnClickListener {
            when (binding?.radioGroupSurvey?.checkedRadioButtonId) {
                R.id.radioFoodPreferences -> navigateToFoodPreferences()
                R.id.radioDietaryHabits -> navigateToDietaryHabits()
            }
        }
    }

    private fun navigateToFoodPreferences() {
        findNavController().navigate(R.id.action_surveySelectionFragment_to_foodPreferencesFragment)
    }

    private fun navigateToDietaryHabits() {
        findNavController().navigate(R.id.action_surveySelectionFragment_to_dietaryHabitsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

