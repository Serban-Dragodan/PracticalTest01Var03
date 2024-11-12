package lab03.eim.systems.cs.pub.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var output: TextView

    private var topNumber = 0
    private var bottomNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)
        enableEdgeToEdge()
        input1 = findViewById(R.id.editTextText)
        input2 = findViewById(R.id.editTextText2)
        output = findViewById(R.id.textView2)

        val plusButton = findViewById<Button>(R.id.plusButton)
        plusButton.setOnClickListener {
            performOperation("+")
        }
        val minusButton = findViewById<Button>(R.id.minusButton)
        minusButton.setOnClickListener {
            performOperation("-")
        }
        if (savedInstanceState != null) {
            topNumber = savedInstanceState.getInt("topNumber", 0)
            bottomNumber = savedInstanceState.getInt("bottomNumber", 0)
            input1.setText(topNumber.toString())
            input2.setText(bottomNumber.toString())

            Toast.makeText(
                this,
                "Valori restaurate: input1=$topNumber, input2=$bottomNumber",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun performOperation(operation: String) {
        val number1 = input1.text.toString()
        val number2 = input2.text.toString()

        // Verificăm dacă valorile sunt numere întregi
        val num1 = number1.toIntOrNull()
        val num2 = number2.toIntOrNull()

        if (num1 == null || num2 == null) {
            // Afișează Toast cu mesaj de eroare dacă valorile nu sunt numere întregi valide
            Toast.makeText(this, "Introduceți numere întregi valide!", Toast.LENGTH_SHORT).show()
        } else {
            // Efectuăm operația corespunzătoare și afișăm rezultatul
            val result = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                else -> 0
            }
            // Setează textul rezultatului în TextView
            output.text = "Rezultat: $num1 $operation $num2 = $result"
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("topNumber", input1.text.toString().toIntOrNull() ?: 0)
        outState.putInt("bottomNumber", input2.text.toString().toIntOrNull() ?: 0)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        topNumber = savedInstanceState.getInt("topNumber", 0)
        bottomNumber = savedInstanceState.getInt("bottomNumber", 0)
        input1.setText(topNumber.toString())
        input2.setText(bottomNumber.toString())
    }
}