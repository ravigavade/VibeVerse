package com.csaim.vibeverse

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csaim.vibeverse.databinding.ActivityJudgingVspercevingBinding

class judgingVSperceving : AppCompatActivity() {
    private lateinit var binding: ActivityJudgingVspercevingBinding
    private var result = 0
    private var prev = 0
    private var isFirstQuestionAnswered = false
    private var isSecondQuestionAnswered = false
    private var isThirdQuestionAnswered = false
    private var isFourthQuestionAnswered = false
    private var isFifthQuestionAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJudgingVspercevingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listeners for each question
        setupQuestionClickListeners()

        // Retrieve scores from previous activities
        val extraversionScore = intent.getIntExtra("extraversionVSintroversion_Score", 0)
        val sensingScore = intent.getIntExtra("sensingVSintution_Score", 0)
        val thinkingScore = intent.getIntExtra("thinkingVSfeeling_Score", 0)

        // Handle the "Submit" button click
        binding.submitbtn.setOnClickListener {
            if (isAllQuestionsAnswered()) {
                val intent = Intent(this, ResultePage::class.java)
                intent.putExtra("extraversionVSintroversion_Score", extraversionScore)
                intent.putExtra("sensingVSintution_Score", sensingScore)
                intent.putExtra("thinkingVSfeeling_Score", thinkingScore)
                intent.putExtra("judgingVSperceiving_Score", result)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
            } else {
                Toast.makeText(this, "Please answer all questions before proceeding.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupQuestionClickListeners() {
        // First question
        binding.oone.setOnClickListener { handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.firsttv, binding.radiogroup1, 1) }
        binding.otwo.setOnClickListener { handleAnswerChange(-1, "Disagree", "#F44336", binding.firsttv, binding.radiogroup1, 1) }
        binding.othree.setOnClickListener { handleAnswerChange(1, "Agree", "#56B55A", binding.firsttv, binding.radiogroup1, 1) }
        binding.ofour.setOnClickListener { handleAnswerChange(2, "Strongly Agree", "#117D16", binding.firsttv, binding.radiogroup1, 1) }

        // Second question
        binding.tone.setOnClickListener { handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.secondttv, binding.radiogroup2, 2) }
        binding.ttwo.setOnClickListener { handleAnswerChange(-1, "Disagree", "#F44336", binding.secondttv, binding.radiogroup2, 2) }
        binding.tthree.setOnClickListener { handleAnswerChange(1, "Agree", "#56B55A", binding.secondttv, binding.radiogroup2, 2) }
        binding.tfour.setOnClickListener { handleAnswerChange(2, "Strongly Agree", "#117D16", binding.secondttv, binding.radiogroup2, 2) }

        // Third question
        binding.thone.setOnClickListener { handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.thirdtv, binding.radiogroup3, 3) }
        binding.thtwo.setOnClickListener { handleAnswerChange(-1, "Disagree", "#F44336", binding.thirdtv, binding.radiogroup3, 3) }
        binding.ththree.setOnClickListener { handleAnswerChange(1, "Agree", "#56B55A", binding.thirdtv, binding.radiogroup3, 3) }
        binding.thfour.setOnClickListener { handleAnswerChange(2, "Strongly Agree", "#117D16", binding.thirdtv, binding.radiogroup3, 3) }

        // Fourth question
        binding.foone.setOnClickListener { handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.fourthtv, binding.radiogroup4, 4) }
        binding.fotwo.setOnClickListener { handleAnswerChange(-1, "Disagree", "#F44336", binding.fourthtv, binding.radiogroup4, 4) }
        binding.fothree.setOnClickListener { handleAnswerChange(1, "Agree", "#56B55A", binding.fourthtv, binding.radiogroup4, 4) }
        binding.fofour.setOnClickListener { handleAnswerChange(2, "Strongly Agree", "#117D16", binding.fourthtv, binding.radiogroup4, 4) }

        // Fifth question
        binding.fione.setOnClickListener { handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.fifthtv, binding.radiogroup5, 5) }
        binding.fitwo.setOnClickListener { handleAnswerChange(-1, "Disagree", "#F44336", binding.fifthtv, binding.radiogroup5, 5) }
        binding.fithree.setOnClickListener { handleAnswerChange(1, "Agree", "#56B55A", binding.fifthtv, binding.radiogroup5, 5) }
        binding.fifour.setOnClickListener { handleAnswerChange(2, "Strongly Agree", "#117D16", binding.fifthtv, binding.radiogroup5, 5) }
    }

    private fun handleAnswerChange(change: Int, answerText: String, color: String, textView: android.widget.TextView, radioGroup: android.widget.RadioGroup, questionIndex: Int) {
        result -= prev
        result += change
        textView.visibility = android.view.View.VISIBLE
        textView.text = answerText
        textView.setTextColor(Color.parseColor(color))
        radioGroup.visibility = android.view.View.GONE
        prev = change
        markQuestionAsAnswered(questionIndex)
    }

    private fun markQuestionAsAnswered(questionIndex: Int) {
        when (questionIndex) {
            1 -> isFirstQuestionAnswered = true
            2 -> isSecondQuestionAnswered = true
            3 -> isThirdQuestionAnswered = true
            4 -> isFourthQuestionAnswered = true
            5 -> isFifthQuestionAnswered = true
        }
        checkAllQuestionsAnswered()
    }

    private fun isAllQuestionsAnswered(): Boolean {
        return isFirstQuestionAnswered && isSecondQuestionAnswered && isThirdQuestionAnswered && isFourthQuestionAnswered && isFifthQuestionAnswered
    }

    private fun checkAllQuestionsAnswered() {
        binding.submitbtn.isEnabled = isAllQuestionsAnswered()
    }
}
