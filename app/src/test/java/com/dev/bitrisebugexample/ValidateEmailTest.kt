package com.dev.bitrisebugexample

import android.content.Context
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


class ValidateEmailTest() {

    @Test
    fun checkForSymbol() {

        val result = Validate.checkEmail("wise@")
        assertThat(result).contains("@")
    }

    @Test
    fun checkLengthOfWord() {
        val result = Validate.checkLengthOfWord("johnppprrrr")
        assertThat(result).hasLength(5)
    }
}