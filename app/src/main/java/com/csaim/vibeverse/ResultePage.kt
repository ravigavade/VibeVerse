package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityLoginPageBinding
import com.csaim.vibeverse.databinding.ActivityResultePageBinding
import com.google.firebase.auth.FirebaseAuth
import pl.droidsonroids.gif.GifDrawable

class ResultePage : AppCompatActivity() {
    private lateinit var binding: ActivityResultePageBinding
    private lateinit var binding1: ActivityLoginPageBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding=ActivityResultePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access GifImageView through ViewBinding
        val gifImageView = binding.gifImageView

        // Load GIF drawable
        val gifDrawable = gifImageView.drawable as GifDrawable

        // Set the loop count to 1 (play only once)
        gifDrawable.loopCount = 1

        // Optionally start playback
        gifDrawable.start()

        // Get the current user's email
//        val currentUser = auth.currentUser
//        val email = currentUser?.email ?: "Unknown User"
//
//        binding.resulttv.text="Congratulations $email"

        // Retrieve scores from previous activities
        val extraversionScore = intent.getIntExtra("extraversionVSintroversion_Score", 0)
        val sensingScore = intent.getIntExtra("sensingVSintution_Score", 0)
        val thinkingScore = intent.getIntExtra("thinkingVSfeeling_Score", 0)
        val judgingScore = intent.getIntExtra("judgingVSperceiving_Score", 0)

        // Calculate MBTI type
        val mbtiType = calculateMBTIType(extraversionScore, sensingScore, thinkingScore, judgingScore)
        binding.resulttv.text = "$mbtiType"

        binding.conttbtn.setOnClickListener {
            val intent = Intent(this, detailedresults::class.java)
            intent.putExtra("extraversionVSintroversion_Score", extraversionScore)
            intent.putExtra("sensingVSintution_Score", sensingScore)
            intent.putExtra("thinkingVSfeeling_Score", thinkingScore)
            intent.putExtra("judgingVSperceiving_Score", judgingScore)
            intent.putExtra("mbtiType", mbtiType)
            startActivity(intent)
            finish()
        }


    }
    private fun calculateMBTIType(extraversion: Int, sensing: Int, thinking: Int, judging: Int): String {
        val eOrI = if (extraversion >= 0) "E" else "I"
        val sOrN = if (sensing >= 0) "S" else "N"
        val tOrF = if (thinking >= 0) "T" else "F"
        val jOrP = if (judging >= 0) "J" else "P"
        return "$eOrI$sOrN$tOrF$jOrP"
    }
}