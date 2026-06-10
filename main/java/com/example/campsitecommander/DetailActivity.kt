package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        var display = ""

        for (i in MainActivity.itemNames.indices) {

            display +=
                "Item: ${MainActivity.itemNames[i]}\n" +
                        "Category: ${MainActivity.categories[i]}\n" +
                        "Quantity: ${MainActivity.quantities[i]}\n" +
                        "Comments: ${MainActivity.comments[i]}\n\n"
        }

        txtDetails.text = display

        btnBack.setOnClickListener {
            finish()
        }
    }
}