package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val itemNames = ArrayList<String>()
        val categories = ArrayList<String>()
        val quantities = ArrayList<Int>()
        val comments = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        val edtItem = findViewById<EditText>(R.id.edtItemName)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComment = findViewById<EditText>(R.id.edtComment)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)

        calculateTotal(txtTotal)

        btnAdd.setOnClickListener {

            if (edtItem.text.isEmpty() ||
                edtCategory.text.isEmpty() ||
                edtQuantity.text.isEmpty() ||
                edtComment.text.isEmpty()) {

                Toast.makeText(
                    this,
                    "Fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                itemNames.add(edtItem.text.toString())
                categories.add(edtCategory.text.toString())
                quantities.add(edtQuantity.text.toString().toInt())
                comments.add(edtComment.text.toString())

                Toast.makeText(
                    this,
                    "Gear Added",
                    Toast.LENGTH_SHORT
                ).show()

                calculateTotal(txtTotal)

                edtItem.text.clear()
                edtCategory.text.clear()
                edtQuantity.text.clear()
                edtComment.text.clear()
            }
        }

        btnView.setOnClickListener {

            startActivity(
                Intent(this, DetailActivity::class.java)
            )
        }
    }

    private fun calculateTotal(txtTotal: TextView) {

        var total = 0

        for (quantity in quantities) {
            total += quantity
        }

        txtTotal.text = "Total Items Packed: $total"
    }
}