package com.csaim.vibeverse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.csaim.vibeverse.databinding.ActivityDetailedresultsBinding

class detailedresults : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedresultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedresultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve scores from previous activities
        val extraversionScore = intent.getIntExtra("extraversionVSintroversion_Score", 0)
        val sensingScore = intent.getIntExtra("sensingVSintution_Score", 0)
        val thinkingScore = intent.getIntExtra("thinkingVSfeeling_Score", 0)
        val judgingScore = intent.getIntExtra("judgingVSperceiving_Score", 0)
        val mbtiType = intent.getStringExtra("mbtiType")

        // Normalize the score to a percentage
        fun normalizeScore(score: Int): Float {
            return when (score) {
                -2 -> 10f
                -1 -> 35f
                0 -> 50f
                1 -> 65f
                2 -> 90f
                else -> 50f  // Default to 50% if something unexpected occurs
            }
        }

        // Normalize each score
        val extraversionPercentage = normalizeScore(extraversionScore)
        val sensingPercentage = normalizeScore(sensingScore)
        val thinkingPercentage = normalizeScore(thinkingScore)
        val judgingPercentage = normalizeScore(judgingScore)

        // Set the typeName, description, traits, and famous personalities based on MBTI type
        var typeName = ""
        var description = ""
        var trait1 = ""
        var trait2 = ""
        var trait3 = ""
        var trait4 = ""
        var famousPerson1 = ""
        var famousPerson2 = ""
        var famousPerson3 = ""
        var famousPerson4 = ""

        when (mbtiType) {
            "ISTJ" -> {
                typeName = "The Inspector"
                description = "Responsible and dependable, ISTJs value tradition and loyalty. They are practical and excel at organizing and implementing detailed plans."
                trait1 = "• Highly organized and methodical"
                trait2 = "• Detail-oriented with strong focus"
                trait3 = "• Loyal and dependable friend"
                trait4 = "• Responsible in all aspects"
                famousPerson1 = "• George Washington"
                famousPerson2 = "• Angela Merkel"
                famousPerson3 = "• Warren Buffett"
                famousPerson4 = "• John D. Rockefeller"
            }
            "ISFJ" -> {
                typeName = "The Protector"
                description = "Caring and devoted, ISFJs are highly attentive to others' needs. They value harmony and are known for their loyalty and reliability."
                trait1 = "• Nurturing with strong empathy"
                trait2 = "• Dependable in challenging times"
                trait3 = "• Attentive to others' needs"
                trait4 = "• Strives for social harmony"
                famousPerson1 = "• Mother Teresa"
                famousPerson2 = "• Rosa Parks"
                famousPerson3 = "• Queen Elizabeth II"
                famousPerson4 = "• Jimmy Carter"
            }
            "INFJ" -> {
                typeName = "The Counselor"
                description = "Insightful and deeply empathetic, INFJs have a strong sense of intuition. They are dedicated to helping others and making the world a better place."
                trait1 = "• Idealistic with deep convictions"
                trait2 = "• Compassionate towards others' struggles"
                trait3 = "• Visionary with long-term perspective"
                trait4 = "• Reserved but deeply caring"
                famousPerson1 = "• Nelson Mandela"
                famousPerson2 = "• Martin Luther King Jr."
                famousPerson3 = "• Eleanor Roosevelt"
                famousPerson4 = "• Maya Angelou"
            }
            "INTJ" -> {
                typeName = "The Mastermind"
                description = "Strategic and analytical, INTJs are independent thinkers. They thrive on tackling complex problems and implementing long-term plans."
                trait1 = "• Strategic with clear vision"
                trait2 = "• Independent thinker with originality"
                trait3 = "• Innovative problem solver"
                trait4 = "• Analytical with high efficiency"
                famousPerson1 = "• Elon Musk"
                famousPerson2 = "• Bill Gates"
                famousPerson3 = "• Mark Zuckerberg"
                famousPerson4 = "• Isaac Newton"
            }
            "ISTP" -> {
                typeName = "The Craftsman"
                description = "Curious and hands-on, ISTPs love to explore how things work. They are logical and practical, excelling at problem-solving in real-time."
                trait1 = "• Practical problem-solving skills"
                trait2 = "• Analytical approach to challenges"
                trait3 = "• Independent and self-reliant"
                trait4 = "• Adventurous with hands-on experience"
                famousPerson1 = "• Steve Jobs"
                famousPerson2 = "• Amelia Earhart"
                famousPerson3 = "• Bruce Lee"
                famousPerson4 = "• James Bond"
            }
            "ISFP" -> {
                typeName = "The Composer"
                description = "Creative and sensitive, ISFPs value personal expression and individuality. They are deeply in touch with their surroundings and emotions."
                trait1 = "• Creative with artistic flair"
                trait2 = "• Sensitive to personal experiences"
                trait3 = "• Artistic in expression and style"
                trait4 = "• Spontaneous and flexible"
                famousPerson1 = "• Frida Kahlo"
                famousPerson2 = "• Bob Dylan"
                famousPerson3 = "• David Bowie"
                famousPerson4 = "• Michael Jackson"
            }
            "INFP" -> {
                typeName = "The Healer"
                description = "Idealistic and empathetic, INFPs are deeply connected to their values. They seek to help others and create harmony in the world."
                trait1 = "• Idealistic with strong values"
                trait2 = "• Empathetic towards others' needs"
                trait3 = "• Creative in problem-solving"
                trait4 = "• Thoughtful and introspective"
                famousPerson1 = "• J.K. Rowling"
                famousPerson2 = "• William Shakespeare"
                famousPerson3 = "• John Lennon"
                famousPerson4 = "• Virginia Woolf"
            }
            "INTP" -> {
                typeName = "The Architect"
                description = "Innovative and logical, INTPs enjoy exploring complex ideas. They are highly independent thinkers who value intellectual exploration."
                trait1 = "• Innovative with new ideas"
                trait2 = "• Analytical with logical thinking"
                trait3 = "• Curious about complex concepts"
                trait4 = "• Independent and self-sufficient"
                famousPerson1 = "• Albert Einstein"
                famousPerson2 = "• Stephen Hawking"
                famousPerson3 = "• René Descartes"
                famousPerson4 = "• Marie Curie"
            }
            "ESTP" -> {
                typeName = "The Dynamo"
                description = "Energetic and spontaneous, ESTPs are natural problem-solvers. They love taking action and often thrive in fast-paced environments."
                trait1 = "• Energetic with high drive"
                trait2 = "• Action-oriented problem solver"
                trait3 = "• Practical with immediate results"
                trait4 = "• Spontaneous and adaptable"
                famousPerson1 = "• Donald Trump"
                famousPerson2 = "• Ernest Hemingway"
                famousPerson3 = "• Richard Branson"
                famousPerson4 = "• Alexander the Great"
            }
            "ESFP" -> {
                typeName = "The Performer"
                description = "Outgoing and fun-loving, ESFPs love being the center of attention. They are highly sociable and enjoy making people smile and feel entertained."
                trait1 = "• Outgoing with social charm"
                trait2 = "• Fun-loving and lively personality"
                trait3 = "• Sociable with high energy"
                trait4 = "• Enthusiastic and engaging"
                famousPerson1 = "• Marilyn Monroe"
                famousPerson2 = "• Elvis Presley"
                famousPerson3 = "• Leonardo DiCaprio"
                famousPerson4 = "• Jennifer Lawrence"
            }
            "ENFP" -> {
                typeName = "The Champion"
                description = "Enthusiastic and imaginative, ENFPs are passionate about inspiring others. They are highly creative and value personal freedom and expression."
                trait1 = "• Enthusiastic with boundless energy"
                trait2 = "• Imaginative and creative thinker"
                trait3 = "• Passionate about personal goals"
                trait4 = "• Inspiring and motivational"
                famousPerson1 = "• Robin Williams"
                famousPerson2 = "• Walt Disney"
                famousPerson3 = "• Jim Carrey"
                famousPerson4 = "• Richard Branson"
            }
            "ENTP" -> {
                typeName = "The Visionary"
                description = "Innovative and quick-witted, ENTPs thrive on intellectual challenges. They enjoy debating ideas and exploring new possibilities."
                trait1 = "• Innovative with unique ideas"
                trait2 = "• Quick-witted with sharp intellect"
                trait3 = "• Debater with strong arguments"
                trait4 = "• Curious and open-minded"
                famousPerson1 = "• Steve Jobs"
                famousPerson2 = "• Thomas Edison"
                famousPerson3 = "• Mark Twain"
                famousPerson4 = "• Benjamin Franklin"
            }
            "ESTJ" -> {
                typeName = "The Supervisor"
                description = "Organized and pragmatic, ESTJs are natural leaders. They excel at managing projects and are known for their reliability and efficiency."
                trait1 = "• Organized with strong leadership"
                trait2 = "• Practical and efficient"
                trait3 = "• Reliable and trustworthy"
                trait4 = "• Strong focus on results"
                famousPerson1 = "• Margaret Thatcher"
                famousPerson2 = "• George W. Bush"
                famousPerson3 = "• Andrew Carnegie"
                famousPerson4 = "• John D. Rockefeller"
            }
            "ESFJ" -> {
                typeName = "The Provider"
                description = "Warm and sociable, ESFJs are dedicated to supporting others. They thrive in collaborative environments and are committed to their communities."
                trait1 = "• Warm and caring personality"
                trait2 = "• Dedicated to helping others"
                trait3 = "• Strong sense of community"
                trait4 = "• Collaborative and cooperative"
                famousPerson1 = "• Oprah Winfrey"
                famousPerson2 = "• Taylor Swift"
                famousPerson3 = "• Sally Field"
                famousPerson4 = "• Jennifer Garner"
            }
            "ENFJ" -> {
                typeName = "The Teacher"
                description = "Charismatic and empathetic, ENFJs excel in guiding and inspiring others. They are driven by a desire to improve the lives of those around them."
                trait1 = "• Charismatic with strong communication"
                trait2 = "• Empathetic towards others"
                trait3 = "• Inspiring and motivating"
                trait4 = "• Visionary with a focus on growth"
                famousPerson1 = "• Martin Luther King Jr."
                famousPerson2 = "• Nelson Mandela"
                famousPerson3 = "• John F. Kennedy"
                famousPerson4 = "• Eleanor Roosevelt"
            }
            "ENTJ" -> {
                typeName = "The Commander"
                description = "Decisive and confident, ENTJs are natural leaders. They are strategic thinkers who excel at planning and implementing complex projects."
                trait1 = "• Decisive with strong leadership"
                trait2 = "• Strategic with long-term vision"
                trait3 = "• Confident and assertive"
                trait4 = "• Efficient and goal-oriented"
                famousPerson1 = "• Napoleon Bonaparte"
                famousPerson2 = "• Margaret Thatcher"
                famousPerson3 = "• Steve Jobs"
                famousPerson4 = "• Elon Musk"
            }
        }

        // Set the text views and other UI elements
        binding.typeName.text = typeName
        binding.description.text = description
        binding.trait1.text = trait1
        binding.trait2.text = trait2
        binding.trait3.text = trait3
        binding.trait4.text = trait4
        binding.famoustype.text="Famous $mbtiType"

        // Set the famous personalities
        binding.famousPerson1.text = famousPerson1
        binding.famousPerson2.text = famousPerson2
        binding.famousPerson3.text = famousPerson3
        binding.famousPerson4.text = famousPerson4

        // You can also use the percentages to update any UI elements that reflect the normalized scores
        // Example: binding.extraversionProgressBar.progress = extraversionPercentage.toInt()
        // Add similar code for other percentages if needed
    }
}
