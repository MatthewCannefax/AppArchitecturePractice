package com.example.android.architecture.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android.architecture.LOG_TAG
import com.example.android.architecture.R
import com.example.android.architecture.util.DiceHelper

class DiceviewModel(app: Application): AndroidViewModel(app) {
    val headline = MutableLiveData<String>()
    val dice = MutableLiveData<IntArray>()
    val context = app

    init{
        Log.i(LOG_TAG, "Veiw Model Created")
        headline.value = context.getString(R.string.welcome)
        dice.value = intArrayOf(6,6,6,6,6)
    }

    fun rollDice(){
        dice.value = DiceHelper.rollDice()
        headline.value = DiceHelper.evaluateDice(context, dice.value)
    }
}