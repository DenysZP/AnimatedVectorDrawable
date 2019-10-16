package org.rubygarage.animatedvectordrawable

import android.content.Context
import androidx.appcompat.app.ActionBar
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class ActionBarIconAnimation(context: Context) {

    var actionBar: ActionBar? = null
    private val arrowBackToCloseDrawable =
        AnimatedVectorDrawableCompat.create(context, R.drawable.animation_arrow_back_to_close)
    private val closeToArrowBackDrawable =
        AnimatedVectorDrawableCompat.create(context, R.drawable.animation_close_to_arrow_back)
    private var isArrowState = true

    fun animate() {
        val nextAnimation = if (isArrowState) arrowBackToCloseDrawable else closeToArrowBackDrawable
        animate(nextAnimation)
    }

    private fun animate(drawable: AnimatedVectorDrawableCompat?) {
        actionBar?.let {
            it.setHomeAsUpIndicator(drawable)
            drawable?.start()
            isArrowState = !isArrowState
        }
    }
}