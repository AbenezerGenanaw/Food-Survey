package com.example.foodsurvey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodsurvey.databinding.FragmentDietaryHabitsBinding

class DietaryHabitsFragment : Fragment() {

    private var _binding: FragmentDietaryHabitsBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDietaryHabitsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitDietaryHabits.setOnClickListener {
            val vegetarian = binding.radioGroupVegetarian.checkedRadioButtonId == R.id.radioVegetarianYes
            val organic = binding.radioGroupOrganic.checkedRadioButtonId == R.id.radioOrganicYes
            val dairy = binding.radioGroupDairy.checkedRadioButtonId == R.id.radioDairyYes
            val fastFood = binding.radioGroupFastFood.checkedRadioButtonId == R.id.radioFastFoodYes
            val allergies = binding.radioGroupAllergies.checkedRadioButtonId == R.id.radioAllergiesYes

            // Here you could save the data to a database or send it to a server.
            // For now, we'll just show a confirmation message.
            Toast.makeText(
                requireContext(),
                "Submission: Vegetarian - $vegetarian, Organic - $organic, Dairy - $dairy, Fast Food - $fastFood, Allergies - $allergies",
                Toast.LENGTH_LONG
            ).show()

            // Optionally navigate away or clear the survey
            // findNavController().navigate(...)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
