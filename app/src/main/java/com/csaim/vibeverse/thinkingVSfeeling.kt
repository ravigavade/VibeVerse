package com.csaim.vibeverse

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityThinkingVsfeelingBinding

class thinkingVSfeeling : AppCompatActivity() {
    private lateinit var binding:ActivityThinkingVsfeelingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityThinkingVsfeelingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //variable to calculate the final on this activity
        var result=0
        var prev=0

        //colors for the agree disagree text
//        #F60255 dark red
//        #F44336 light red
//        #117D16 dark green
//        #56B55A light green


        //first question
        binding.oone.setOnClickListener{
            result-=prev
            result -= 2
            binding.firsttv.visibility=android.view.View.VISIBLE
            binding.firsttv.text="Strongly disagree"
            binding.firsttv.setTextColor(Color.parseColor("#F60255"))
            binding.radiogroup1.visibility=android.view.View.GONE
        }
        binding.otwo.setOnClickListener{
            result-=prev
            result =result-1

            binding.firsttv.visibility=android.view.View.VISIBLE

            binding.firsttv.text="Disagree"
            binding.firsttv.setTextColor(Color.parseColor("#F44336"))
            binding.radiogroup1.visibility=android.view.View.GONE


        }
        binding.othree.setOnClickListener{
            result-=prev
            result += 1
            binding.radiogroup1.visibility=android.view.View.GONE
            binding.firsttv.visibility=android.view.View.VISIBLE

            binding.firsttv.text="Agree"
            binding.firsttv.setTextColor(Color.parseColor("#56B55A"))
            Toast.makeText(this, "result: $result", Toast.LENGTH_SHORT).show()
        }
        binding.ofour.setOnClickListener{
            result-=prev
            result += 2
            binding.radiogroup1.visibility=android.view.View.GONE
            binding.firsttv.visibility=android.view.View.VISIBLE

            binding.firsttv.text="Strongly Disagree"
            binding.firsttv.setTextColor(Color.parseColor("#117D16"))
        }



        //second question
        binding.tone.setOnClickListener{
            result-=prev
            result -= 2
            binding.secondttv.visibility=android.view.View.VISIBLE
            binding.secondttv.text="Strongly disagree"
            binding.secondttv.setTextColor(Color.parseColor("#F60255"))
            binding.radiogroup2.visibility=android.view.View.GONE
        }
        binding.ttow.setOnClickListener{
            result-=prev
            result -= 1
            binding.secondttv.visibility=android.view.View.VISIBLE

            binding.secondttv.text="Disagree"
            binding.secondttv.setTextColor(Color.parseColor("#F44336"))
            binding.radiogroup2.visibility=android.view.View.GONE

        }
        binding.tthree.setOnClickListener{
            result-=prev
            result += 1
            binding.radiogroup2.visibility=android.view.View.GONE
            binding.secondttv.visibility=android.view.View.VISIBLE

            binding.secondttv.text="Agree"
            binding.secondttv.setTextColor(Color.parseColor("#56B55A"))
            Toast.makeText(this, "result: $result", Toast.LENGTH_SHORT).show()
        }
        binding.tfour.setOnClickListener{
            result-=prev
            result += 2
            binding.radiogroup2.visibility=android.view.View.GONE
            binding.secondttv.visibility=android.view.View.VISIBLE

            binding.secondttv.text="Strongly Disagree"
            binding.secondttv.setTextColor(Color.parseColor("#117D16"))
        }




        //third question
        binding.thone.setOnClickListener{
            result-=prev
            result -= 2
            binding.thirdtv.visibility=android.view.View.VISIBLE

            binding.thirdtv.text="Strongly disagree"
            binding.thirdtv.setTextColor(Color.parseColor("#F60255"))
            binding.radiogroup3.visibility=android.view.View.GONE
        }
        binding.thtwo.setOnClickListener{
            result-=prev
            result -= 1
            binding.thirdtv.visibility=android.view.View.VISIBLE

            binding.thirdtv.text="Disagree"
            binding.thirdtv.setTextColor(Color.parseColor("#F44336"))
            binding.radiogroup3.visibility=android.view.View.GONE

        }
        binding.ththree.setOnClickListener{
            result-=prev
            result += 1
            binding.radiogroup3.visibility=android.view.View.GONE
            binding.thirdtv.visibility=android.view.View.VISIBLE

            binding.thirdtv.text="Agree"
            binding.thirdtv.setTextColor(Color.parseColor("#56B55A"))
            Toast.makeText(this, "result: $result", Toast.LENGTH_SHORT).show()
        }
        binding.thfour.setOnClickListener{
            result-=prev
            result += 2
            binding.radiogroup3.visibility=android.view.View.GONE
            binding.thirdtv.visibility=android.view.View.VISIBLE

            binding.thirdtv.text="Strongly Disagree"
            binding.thirdtv.setTextColor(Color.parseColor("#117D16"))
        }




        //fourth question
        binding.foone.setOnClickListener{
            result-=prev
            result -= 2
            binding.fourthtv.visibility=android.view.View.VISIBLE

            binding.fourthtv.text="Strongly disagree"
            binding.fourthtv.setTextColor(Color.parseColor("#F60255"))
            binding.radiogroup4.visibility=android.view.View.GONE
        }
        binding.fotwo.setOnClickListener{
            result-=prev
            result -= 1
            binding.fourthtv.visibility=android.view.View.VISIBLE

            binding.fourthtv.text="Disagree"
            binding.fourthtv.setTextColor(Color.parseColor("#F44336"))
            binding.radiogroup4.visibility=android.view.View.GONE

        }
        binding.fothree.setOnClickListener{
            result-=prev
            result += 1
            binding.radiogroup4.visibility=android.view.View.GONE
            binding.fourthtv.visibility=android.view.View.VISIBLE

            binding.fourthtv.text="Agree"
            binding.fourthtv.setTextColor(Color.parseColor("#56B55A"))
        }
        binding.fofour.setOnClickListener{
            result-=prev
            result += 2
            binding.radiogroup4.visibility=android.view.View.GONE
            binding.fourthtv.visibility=android.view.View.VISIBLE

            binding.fourthtv.text="Strongly Disagree"
            binding.fourthtv.setTextColor(Color.parseColor("#117D16"))
        }





        //fifth question
        binding.fione.setOnClickListener{
            result-=prev
            result -= 2
            binding.fifthtv.visibility=android.view.View.VISIBLE

            binding.fifthtv.text="Strongly disagree"
            binding.fifthtv.setTextColor(Color.parseColor("#F60255"))
            binding.radiogroup5.visibility=android.view.View.GONE
        }
        binding.fitwo.setOnClickListener{
            result-=prev
            result -= 1
            binding.fifthtv.visibility=android.view.View.VISIBLE

            binding.fifthtv.text="Disagree"
            binding.fifthtv.setTextColor(Color.parseColor("#F44336"))
            binding.radiogroup5.visibility=android.view.View.GONE

        }
        binding.fithree.setOnClickListener{
            result-=prev
            result += 1
            binding.radiogroup5.visibility=android.view.View.GONE
            binding.fifthtv.visibility=android.view.View.VISIBLE

            binding.fifthtv.text="Agree"
            binding.fifthtv.setTextColor(Color.parseColor("#56B55A"))
        }
        binding.fifour.setOnClickListener {
            result -= prev
            result += 2
            binding.radiogroup5.visibility = android.view.View.GONE
            binding.fifthtv.visibility = android.view.View.VISIBLE

            binding.fifthtv.text = "Strongly Disagree"
            binding.fifthtv.setTextColor(Color.parseColor("#117D16"))
        }

        // Retrieve the scores from previous activities
        val extraversionScore = intent.getIntExtra("extraversionVSintroversion_Score", 0)
        val sensingScore = intent.getIntExtra("sensingVSintution_Score", 0)

        binding.nextbtn.setOnClickListener {
            val intent = Intent(this, judgingVSperceving::class.java)
            intent.putExtra("extraversionVSintroversion_Score", extraversionScore)
            intent.putExtra("sensingVSintution_Score", sensingScore)
            intent.putExtra("thinkingVSfeeling_Score", result)
            startActivity(intent)
            finish()
        }

    }
}