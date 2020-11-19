package com.dev.bitrisebugexample

import android.content.Context
import android.widget.Toast

object Validate {
    fun checkEmail(email: String): String {
        if (email.contains("@"))
            return email
        // Toast.makeText(context, "sucess", Toast.LENGTH_SHORT).show()
        else
        //  Toast.makeText(context, "not sucess", Toast.LENGTH_SHORT).show()

            return "Error"
    }

    fun checkLengthOfWord(word: String): String {
        if (word.length <= 7)
            return word
        else
            return "Error"
    }

}