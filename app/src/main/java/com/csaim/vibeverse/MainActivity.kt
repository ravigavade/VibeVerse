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
            overridePendingTransition(0, 0)
        }

        //binding fpr scrollview
        binding.p1.setOnClickListener{
            startActivity(Intent(this,Istj::class.java))
        }
        binding.p2.setOnClickListener{
            startActivity(Intent(this,Isfj::class.java))
        }
        binding.p3.setOnClickListener{
            startActivity(Intent(this,Infj::class.java))
        }
        binding.p4.setOnClickListener{
            startActivity(Intent(this,Intj::class.java))
        }
        binding.p5.setOnClickListener{
            startActivity(Intent(this,Istp::class.java))
        }
        binding.p6.setOnClickListener{
            startActivity(Intent(this,Isfp::class.java))
        }
        binding.p7.setOnClickListener{
            startActivity(Intent(this,Infp::class.java))
        }
        binding.p8.setOnClickListener{
            startActivity(Intent(this,Intp::class.java))
        }
        binding.p9.setOnClickListener{
            startActivity(Intent(this,Estp::class.java))
        }
        binding.p10.setOnClickListener{
            startActivity(Intent(this,Esfp::class.java))
        }
        binding.p11.setOnClickListener{
            startActivity(Intent(this,Enfp::class.java))
        }
        binding.p12.setOnClickListener{
            startActivity(Intent(this,Entp::class.java))
        }
        binding.p13.setOnClickListener{
            startActivity(Intent(this,Estj::class.java))
        }
        binding.p14.setOnClickListener{
            startActivity(Intent(this,Esfj::class.java))
        }
        binding.p15.setOnClickListener{
            startActivity(Intent(this,Enfj::class.java))
        }
        binding.p16.setOnClickListener{
            startActivity(Intent(this,Entj::class.java))
        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        // Close all activities and exit the app
        finishAffinity()
    }
}