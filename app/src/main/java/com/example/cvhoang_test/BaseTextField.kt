package com.example.cvhoang_test

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cvhoang_test.databinding.BaseTextviewBinding


@SuppressLint("CustomViewStyleable")
class BaseTextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: BaseTextviewBinding =
        BaseTextviewBinding.inflate(LayoutInflater.from(context), this, true)

    private fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    init {
        binding.root
        val a = context.obtainStyledAttributes(attrs, R.styleable.BaseText)
        try {
            if (a.getBoolean(R.styleable.BaseText_isCustomize, false)) {
                val color = a.getColor(R.styleable.BaseText_textColor, 0)
                binding.txtBaseText.setTextColor(color)
                binding.txtBaseText.textSize = convertPixelsToDp(
                    a.getDimensionPixelSize(R.styleable.BaseText_textSize, 0).toFloat(), context
                )
                binding.txtBaseText.lineHeight = convertPixelsToDp(
                    a.getDimensionPixelSize(R.styleable.BaseText_textLineHeight, 0).toFloat(),
                    context
                ).toInt()
            }
            binding.txtBaseText.text = a.getString(R.styleable.BaseText_title)
        } finally {
            a.recycle()
        }
    }


    fun getText(): String {
        return binding.txtBaseText.text.toString()
    }

}