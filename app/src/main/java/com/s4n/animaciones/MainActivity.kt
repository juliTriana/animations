package com.s4n.animaciones

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()

        image.apply {
            setImageResource(R.drawable.animated_logo)
            (drawable as Animatable).start()
        }
        Handler().postDelayed({
            if(this@MainActivity.isFinishing.not()) {
                (image.drawable as Animatable).stop()
                goToBase()
            }
        },3000)

    }

    fun goToBase()
    {
        val intent= Intent(this,BaseActivity::class.java)
        val options=ActivityOptionsCompat.makeSceneTransitionAnimation(this,image as View,image.transitionName)
        startActivity(intent,options.toBundle())

    }
}
