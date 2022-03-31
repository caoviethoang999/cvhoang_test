package com.example.cvhoang_test

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cvhoang_test.databinding.BaseButtonBinding

class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: BaseButtonBinding =
        BaseButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.root
        val a = context.obtainStyledAttributes(attrs, R.styleable.BaseButton)
        try {
//            binding.txtBaseEditText.hint = a.getString(R.styleable.BaseEditText_titleEditText)
        } finally {
            a.recycle()
        }
    }

//
//    fun getText(): Editable {
//        return binding.txtBaseEditText.text as Editable
//    }
}