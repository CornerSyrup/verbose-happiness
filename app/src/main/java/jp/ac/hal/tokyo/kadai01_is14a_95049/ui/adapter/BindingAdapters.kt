package jp.ac.hal.tokyo.kadai01_is14a_95049.ui.adapter

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter

@SuppressLint("SetTextI18n")
@BindingAdapter(value = ["year", "month", "day"], requireAll = true)
fun TextView.displayDate(year: Int, month: Int, day: Int) {
    this.text = "$year / $month / $day"
}