package edu.wccnet.mshigbee.TipCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import edu.wccnet.mshigbee.TipCalculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val input = binding.bill.text.toString()
        if (input == "") {
            "YOU MUST ENTER A BILL AMOUNT".also { binding.tooltip.text = it }
            binding.tenPercent.text = " "
            binding.fifteenPercent.text = " "
            binding.twentyPercent.text = " "
        } else {
            val amount  = input.toBigDecimal()
            val ten = BigDecimal(1.10)
            val fifteen = BigDecimal(1.15)
            val twenty = BigDecimal(1.20)
            "The tips are as follows:".also { binding.tooltip.text = it }
            amount.multiply(ten).setScale(2, RoundingMode.HALF_DOWN).toString()
                .also { binding.tenPercent.text = it }
            amount.multiply(fifteen).setScale(2, RoundingMode.HALF_DOWN).toString()
                .also { binding.fifteenPercent.text = it }
            amount.multiply(twenty).setScale(2, RoundingMode.HALF_DOWN).toString()
                .also { binding.twentyPercent.text = it }
        }
    }
}


