package com.alfredthomas.casinostrategy.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.alfredthomas.casinostrategy.R
import com.alfredthomas.casinostrategy.VideoPokerFragment
import com.alfredthomas.casinostrategy.data.GameTypes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<LinearLayout>(R.id.games_list).let {
            for (gameType in GameTypes.entries) {
                it.addView(Button(this).apply {
                    text = gameType.name
                    setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            if (gameType == GameTypes.VIDEOPOKER) {
                                supportFragmentManager.commit {
                                    add(android.R.id.content, VideoPokerFragment())
                                    addToBackStack(null)
                                }
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    "${gameType.name} clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
                }
                )
            }
        }
    }

}