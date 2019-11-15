/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.android.diceroller.R.drawable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    lateinit var rollButton: Button
    lateinit var clearButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = dice_image1
        diceImage2 = dice_image2
        rollButton = roll_button
        clearButton = clear_button
        rollButton.setOnClickListener { rollDice() }
        clearButton.setOnClickListener { clearImages() }

    }

    private fun getRandomDiceImage(): Int {
        return when (Random().nextInt(6) + 1) {
            1 -> drawable.dice_1
            2 -> drawable.dice_2
            3 -> drawable.dice_3
            4 -> drawable.dice_4
            5 -> drawable.dice_5
            else -> drawable.dice_6
        }
    }

    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun clearImages() {
        diceImage1.setImageResource(drawable.empty_dice)
        diceImage2.setImageResource(drawable.empty_dice)
    }
}
