package com.vishnu.selfpromo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.btnPreview
import kotlinx.android.synthetic.main.activity_main.cbImmediate
import kotlinx.android.synthetic.main.activity_main.cbjunior
import kotlinx.android.synthetic.main.activity_main.etContactNumber
import kotlinx.android.synthetic.main.activity_main.etDisplayName
import kotlinx.android.synthetic.main.activity_main.etName
import kotlinx.android.synthetic.main.activity_main.etStartDate
import kotlinx.android.synthetic.main.activity_main.spinnerJobTitle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPreview.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinnerJobTitle.adapter = spinnerAdapter
    }


    private fun onPreviewClicked() {

        val message = Message(
            etName.text.toString(),
            etContactNumber.text.toString(),
            etDisplayName.text.toString(),
            cbjunior.isChecked,
            spinnerJobTitle.selectedItem?.toString(),
            cbImmediate.isChecked,
            etStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}