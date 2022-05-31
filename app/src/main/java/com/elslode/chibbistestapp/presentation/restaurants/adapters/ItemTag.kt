package com.elslode.chibbistestapp.presentation.restaurants.adapters

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.elslode.chibbistestapp.R

class ItemTag: FrameLayout {
    constructor(context: Context): super(context)
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int): super(context, attributeSet, defStyle)

    init {
        inflate(context, R.layout.tag_item, this)
    }

    fun init(tag: String) {
        findViewById<TextView>(R.id.textTagOfFood).text = context.getString(R.string.food_tag).format(tag)
    }
}