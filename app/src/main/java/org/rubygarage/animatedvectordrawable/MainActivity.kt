package org.rubygarage.animatedvectordrawable

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarIconAnimation: ActionBarIconAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Simple example */
        val arrowBackToCloseDrawable =
            AnimatedVectorDrawableCompat.create(this, R.drawable.animation_arrow_back_to_close)
        val animatedImageView = findViewById<ImageView>(R.id.animatedImageView)

        animatedImageView.setOnClickListener {
            arrowBackToCloseDrawable?.let {
                animatedImageView.setImageDrawable(it)
                it.start()
            }
        }

        /* ActionBar example */
        actionBarIconAnimation = ActionBarIconAnimation(this)
        val actionBar = this.supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp)
        }
        actionBarIconAnimation.actionBar = actionBar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                actionBarIconAnimation.animate()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}