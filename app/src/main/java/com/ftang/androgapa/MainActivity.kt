package com.ftang.androgapa

import android.media.MediaPlayer
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import roboguice.inject.InjectView

class MainActivity : ActionBarActivity() {

    var gapaButton: Button? = null

    var soundToPlay = R.raw.gapa1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gapaButton = findViewById(R.id.gapaButton) as Button?

        gapaButton!!.setOnClickListener {
            val mp = MediaPlayer.create(this, soundToPlay)
            mp.start();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.main_activity_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        soundToPlay = when (item.getItemId()) {
            R.id.action_gapa1 -> R.raw.gapa1
            R.id.action_gapa2 -> R.raw.gapa2
            R.id.action_gapa3 -> R.raw.gapa3
            R.id.action_gapa4 -> R.raw.gapa4

            else ->  return super.onOptionsItemSelected(item)
        }
        return true
    }
}
