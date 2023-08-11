package com.vishnu.selfpromo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.btnSendMessage
import kotlinx.android.synthetic.main.activity_preview.tvMessage

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
         message = intent.getSerializableExtra("Message") as Message

         messagePreviewText = """
                Hi ${message.contactName}
                
                My name is ${message.displayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards
            """.trimIndent()

        tvMessage.text = messagePreviewText
    }
    private fun setupButton() {
        btnSendMessage.setOnClickListener {
            // Send message Intent
            val sentIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}") //this ensures only sms apps responds
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(sentIntent)
        }
    }
}