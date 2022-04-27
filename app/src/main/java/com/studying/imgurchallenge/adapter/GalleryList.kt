package com.studying.imgurchallenge.adapter

import android.content.AttributionSource
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.studying.imgurchallenge.databinding.GalleryListBinding

class GalleryList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    private val binding = GalleryListBinding.inflate(LayoutInflater.from(context), this, true)

}