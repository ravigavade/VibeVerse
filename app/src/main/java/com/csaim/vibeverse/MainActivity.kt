package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Retrieve scores from previous activities
        val extraversionPercentage = intent.getDoubleExtra("extraversionVSintroversion_Score", 0.0)
        val sensingPercentage = intent.getDoubleExtra("sensingVSintution_Score", 0.0)
        val thinkingPercentage = intent.getDoubleExtra("thinkingVSfeeling_Score", 0.0)
        val judgingPercentage = intent.getDoubleExtra("judgingVSperceiving_Score", 0.0)
        val mbtiType = intent.getStringExtra("mbtiType")


        binding.mbtitestbanner.setOnClickListener {
            startActivity(Intent(this,MBTItest::class.java))
        }
        binding.homeresulttv.text=mbtiType
        binding.tv1.text = "E vs I : $extraversionPercentage%"
        binding.tv2.text = "S vs I : $sensingPercentage%"
        binding.tv3.text = "T vs F : $thinkingPercentage%"
        binding.tv4.text = "J vs P : $judgingPercentage%"
        binding.homeresulttv.text =mbtiType


        binding.account.setOnClickListener{
            val intent=(Intent(this,accountpage::class.java))
            intent.putExtra("extraversionVSintroversion_Score", extraversionPercentage)
            intent.putExtra("sensingVSintution_Score", sensingPercentage)
            intent.putExtra("thinkingVSfeeling_Score", thinkingPercentage)
            intent.putExtra("judgingVSperceiving_Score", judgingPercentage)
            intent.putExtra("mbtiType", mbtiType)
            startActivity(intent)
            finish()
            overridePendingTransition(0, 0)
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        // Close all activities and exit the app
        finishAffinity()
    }
}