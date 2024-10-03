package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    companion object {
        const val TEXT_SIZE_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        // Step 1: Launch TextSizeActivity when button clicked
        textSizeSelectorButton.setOnClickListener {
            val intent = Intent(this, TextSizeActivity::class.java)
            startActivityForResult(intent, TEXT_SIZE_REQUEST_CODE)
        }
    }

    // Step 3: Handle returned value from TextSizeActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_SIZE_REQUEST_CODE && resultCode == RESULT_OK) {
            val selectedSize = data?.getIntExtra("selectedSize", 16) ?: 16
            lyricsDisplayTextView.textSize = selectedSize.toFloat()
        }
    }
}
