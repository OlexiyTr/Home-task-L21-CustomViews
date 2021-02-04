package com.example.home_task_l21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home_task_l21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val DELTA_OFF = 0
        private const val DELTA_LOW = 5
        private const val DELTA_MEDIUM = 10
        private const val DELTA_HIGH = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {

        binding.btnClicker.setOnClickListener {
            changeState()
        }
        binding.btnChange.setOnClickListener {
            changeView()
        }

    }

    private fun changeView() {
        binding.apply {
            view2.changeText(R.string.new_text)
            view2.changeImage(R.drawable.ventilator_icon)
            btnChange.isEnabled = false
        }
    }

    private fun changeState() {
        binding.dialView.changeState()
        when {
            binding.dialView.getState() == FanSpeed.OFF -> {
                binding.rotationImage.setDelta(DELTA_OFF)
            }
            binding.dialView.getState() == FanSpeed.LOW -> {
                binding.rotationImage.setDelta(DELTA_LOW)
            }
            binding.dialView.getState() == FanSpeed.MEDIUM -> {
                binding.rotationImage.setDelta(DELTA_MEDIUM)
            }
            binding.dialView.getState() == FanSpeed.HIGH -> {
                binding.rotationImage.setDelta(DELTA_HIGH)
            }
        }
    }

}
