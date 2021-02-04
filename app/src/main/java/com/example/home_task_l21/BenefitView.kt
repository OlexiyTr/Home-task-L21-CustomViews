package com.example.home_task_l21

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.home_task_l21.R
import com.example.home_task_l21.databinding.BenefitViewBinding

class BenefitView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var binding: BenefitViewBinding =
        BenefitViewBinding.bind(inflate(context,
            R.layout.benefit_view, this))

    init {
        val imageView: ImageView = findViewById(R.id.image)
        val textView: TextView = findViewById(R.id.caption)

        val attributes = context.obtainStyledAttributes(attrs,
            R.styleable.BenefitView
        )
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
        textView.text = attributes.getString(R.styleable.BenefitView_text)
        attributes.recycle()
    }

    fun changeText(@StringRes stringRes: Int) {
        binding.caption.setText(stringRes)
    }

    fun changeImage(@DrawableRes drawableRes: Int){
        binding.image.setImageResource(drawableRes)
    }

}