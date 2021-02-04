package com.example.home_task_l21

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import com.example.home_task_l21.R

class RotationImage @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {
    private var rotationDegrees = 0
    private var delta: Int = 0

    init {
        val bitmap = BitmapFactory.decodeResource(resources,
            R.drawable.ventilator_icon
        )
        setImageBitmap(bitmap)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(width / 2.toFloat(), height / 2.toFloat())
        canvas.rotate(rotation().toFloat())
        canvas.translate(-width / 2.toFloat(), -height / 2.toFloat())
        postInvalidateOnAnimation()
        super.onDraw(canvas)
    }

    private fun rotation(): Int {
        rotationDegrees = (rotationDegrees + delta) % 360
        return rotationDegrees
    }

    fun setDelta(value : Int){
        delta = value
    }
}

