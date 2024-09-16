package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityMbtitestBinding

class MBTItest : AppCompatActivity() {

    private lateinit var binding:ActivityMbtitestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMbtitestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.takeTestButton.setOnClickListener {
            startActivity(Intent(this,extraversionVSintroverseion::class.java))
        }


    }
}