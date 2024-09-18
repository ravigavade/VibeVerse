package com.csaim.vibeverse

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csaim.vibeverse.databinding.ActivityExtraversionVsintroverseionBinding

class extraversionVSintroverseion : AppCompatActivity() {
    private lateinit var binding: ActivityExtraversionVsintroverseionBinding
    private var isFirstQuestionAnswered = false
    private var isSecondQuestionAnswered = false
    private var isThirdQuestionAnswered = false
    private var isFourthQuestionAnswered = false
    private var isFifthQuestionAnswered = false
    private var result = 0
    private var prev = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtraversionVsintroverseionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // First question logic
        binding.oone.setOnClickListener {
            handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.firsttv, binding.radiogroup1)
            isFirstQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.otwo.setOnClickListener {
            handleAnswerChange(-1, "Disagree", "#F44336", binding.firsttv, binding.radiogroup1)
            isFirstQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.othree.setOnClickListener {
            handleAnswerChange(1, "Agree", "#56B55A", binding.firsttv, binding.radiogroup1)
            isFirstQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.ofour.setOnClickListener {
            handleAnswerChange(2, "Strongly Agree", "#117D16", binding.firsttv, binding.radiogroup1)
            isFirstQuestionAnswered = true
            checkAllQuestionsAnswered()
        }

        // Second question logic
        binding.tone.setOnClickListener {
            handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.secondttv, binding.radiogroup2)
            isSecondQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.ttwo.setOnClickListener {
            handleAnswerChange(-1, "Disagree", "#F44336", binding.secondttv, binding.radiogroup2)
            isSecondQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.tthree.setOnClickListener {
            handleAnswerChange(1, "Agree", "#56B55A", binding.secondttv, binding.radiogroup2)
            isSecondQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.tfour.setOnClickListener {
            handleAnswerChange(2, "Strongly Agree", "#117D16", binding.secondttv, binding.radiogroup2)
            isSecondQuestionAnswered = true
            checkAllQuestionsAnswered()
        }

        // Third question logic
        binding.thone.setOnClickListener {
            handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.thirdtv, binding.radiogroup3)
            isThirdQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.thtwo.setOnClickListener {
            handleAnswerChange(-1, "Disagree", "#F44336", binding.thirdtv, binding.radiogroup3)
            isThirdQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.ththree.setOnClickListener {
            handleAnswerChange(1, "Agree", "#56B55A", binding.thirdtv, binding.radiogroup3)
            isThirdQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.thfour.setOnClickListener {
            handleAnswerChange(2, "Strongly Agree", "#117D16", binding.thirdtv, binding.radiogroup3)
            isThirdQuestionAnswered = true
            checkAllQuestionsAnswered()
        }

        // Fourth question logic
        binding.foone.setOnClickListener {
            handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.fourthtv, binding.radiogroup4)
            isFourthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fotwo.setOnClickListener {
            handleAnswerChange(-1, "Disagree", "#F44336", binding.fourthtv, binding.radiogroup4)
            isFourthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fothree.setOnClickListener {
            handleAnswerChange(1, "Agree", "#56B55A", binding.fourthtv, binding.radiogroup4)
            isFourthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fofour.setOnClickListener {
            handleAnswerChange(2, "Strongly Agree", "#117D16", binding.fourthtv, binding.radiogroup4)
            isFourthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }

        // Fifth question logic
        binding.fione.setOnClickListener {
            handleAnswerChange(-2, "Strongly disagree", "#F60255", binding.fifthtv, binding.radiogroup5)
            isFifthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fitwo.setOnClickListener {
            handleAnswerChange(-1, "Disagree", "#F44336", binding.fifthtv, binding.radiogroup5)
            isFifthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fithree.setOnClickListener {
            handleAnswerChange(1, "Agree", "#56B55A", binding.fifthtv, binding.radiogroup5)
            isFifthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }
        binding.fifour.setOnClickListener {
            handleAnswerChange(2, "Strongly Agree", "#117D16", binding.fifthtv, binding.radiogroup5)
            isFifthQuestionAnswered = true
            checkAllQuestionsAnswered()
        }

        // Next button listener
        binding.nextbtn.setOnClickListener {
            if (isAllQuestionsAnswered()) {
                val intent = Intent(this, sensingVSintution::class.java)
                intent.putExtra("extraversionVSintroversion_Score", result)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
            } else {
                Toast.makeText(this, "Please answer all questions before proceeding.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Helper function to update result and UI
    private fun handleAnswerChange(change: Int, answerText: String, color: String, textView: android.widget.TextView, radioGroup: android.widget.RadioGroup) {
        result -= prev
        result += change
        textView.visibility = android.view.View.VISIBLE
        textView.text = answerText
        textView.setTextColor(Color.parseColor(color))
        radioGroup.visibility = android.view.View.GONE
        prev = change
    }

    // Check if all questions are answered
    private fun isAllQuestionsAnswered(): Boolean {
        return isFirstQuestionAnswered && isSecondQuestionAnswered && isThirdQuestionAnswered && isFourthQuestionAnswered && isFifthQuestionAnswered
    }

    // Enable/disable next button based on answers
    private fun checkAllQuestionsAnswered() {
        binding.nextbtn.isEnabled = isAllQuestionsAnswered()
    }
}
