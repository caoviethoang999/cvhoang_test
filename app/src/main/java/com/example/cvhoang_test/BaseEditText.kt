package com.example.cvhoang_test

import android.content.Context
import android.text.Editable
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cvhoang_test.databinding.BaseEdittextBinding

class BaseEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: BaseEdittextBinding =
        BaseEdittextBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.root
        val a = context.obtainStyledAttributes(attrs, R.styleable.BaseEditText)
        try {
            binding.txtBaseEditText.inputType =
                a.getInt(R.styleable.BaseEditText_android_inputType, EditorInfo.TYPE_NULL)
            binding.txtBaseEditText.hint = a.getString(R.styleable.BaseEditText_titleEditText)
        } finally {
            a.recycle()
        }
    }


    fun getText(): Editable? {
        return binding.txtBaseEditText.text
    }

    fun getFocus(): EditText {
        return binding.txtBaseEditText
    }

    fun transformPassword() {
        binding.txtBaseEditText.transformationMethod = BiggerDotPasswordTransformationMethod
    }
}

private object BiggerDotPasswordTransformationMethod : PasswordTransformationMethod() {

    override fun getTransformation(source: CharSequence, view: View): CharSequence {
        return PasswordCharSequence(super.getTransformation(source, view))
    }

    private class PasswordCharSequence(
        val transformation: CharSequence
    ) : CharSequence by transformation {
        override fun get(index: Int): Char = if (transformation[index] == DOT) {
            BIGGER_DOT
        } else {
            transformation[index]
        }
    }

    private const val DOT = '\u2022'
    private const val BIGGER_DOT = '＊'
}