import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myweatherapplication.R

class MainActivity2 : AppCompatActivity() {

    lateinit var temperatureEditTexts: Array<EditText>
    lateinit var calculateButton: Button
    lateinit var clearButton: Button
    lateinit var detailedViewButton: Button
    lateinit var exitButton: Button
    lateinit var averageTemperatureTextView: TextView

    private var temperatures: DoubleArray = DoubleArray(7)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)


        temperatureEditTexts = arrayOf(
            findViewById(R.id.monday_temp),
            findViewById(R.id.tuesday_temp),
            findViewById(R.id.wednesday_temp),
            findViewById(R.id.thursday_temp),
            findViewById(R.id.friday_temp),
            findViewById(R.id.saturday_temp),
            findViewById(R.id.sunday_temp)
        )

        calculateButton = findViewById(R.id.calculate_button)
        clearButton = findViewById(R.id.clear_button)
        detailedViewButton = findViewById(R.id.detailed_view_button)
        exitButton = findViewById(R.id.exit_button)
        averageTemperatureTextView = findViewById(R.id.average_temperature_textview)

        calculateButton.setOnClickListener { calculateAverageTemperature() }
        clearButton.setOnClickListener { clearData() }
        detailedViewButton.setOnClickListener { navigateToDetailedView() }
        exitButton.setOnClickListener { finish() }
    }

    @SuppressLint("SetTextI18n")
    fun calculateAverageTemperature() {
        var sum = 0.0
        for (i in 0 until 7) {
            try {
                temperatures[i] = temperatureEditTexts[i].text.toString().toDouble()
                sum += temperatures[i]
            } catch (e: NumberFormatException) {

                averageTemperatureTextView.text = "Error: Invalid input"
                return
            }
        }
        val average = sum / 7
        averageTemperatureTextView.text = "Average temperature: ${String.format("%.2f", average)}"
    }

    fun clearData() {
        for (i in 0 until 7) {
            temperatureEditTexts[i].text.clear()
        }
        averageTemperatureTextView.text = ""
    }
    fun navigateToDetailedView() {
        val intent = Intent(this, DetailedViewActivity::class.java)

    }
}

class DetailedViewActivity {

}
