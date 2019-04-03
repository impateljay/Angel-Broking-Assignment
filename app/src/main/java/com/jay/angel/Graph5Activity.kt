package com.jay.angel

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import kotlinx.android.synthetic.main.activity_graph5.*
import java.util.*
import kotlin.collections.HashMap

class Graph5Activity : AppCompatActivity() {

    private lateinit var chart: LineChart
    private var xLabelMap: HashMap<Int, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph5)

        supportActionBar?.hide()

        chart = findViewById(R.id.line_chart)

        xLabelMap[0] = "00:00"
        xLabelMap[7] = "03:00"
        xLabelMap[15] = "06:00"
        xLabelMap[23] = "09:00"
        xLabelMap[31] = "12:00"
        initChart(40)

        button_ten_min.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            xLabelMap[0] = "01:00"
            xLabelMap[3] = "01:02"
            xLabelMap[7] = "01:04"
            xLabelMap[9] = "01:06"
            xLabelMap[11] = "01:08"
            xLabelMap[15] = "01:10"
            initChart(20)
        }

        button_hour.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            xLabelMap[0] = "01:00"
            xLabelMap[5] = "01:15"
            xLabelMap[11] = "01:30"
            xLabelMap[17] = "01:45"
            xLabelMap[23] = "02:00"
            initChart(30)
        }

        button_day.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            xLabelMap[0] = "00:00"
            xLabelMap[7] = "03:00"
            xLabelMap[15] = "06:00"
            xLabelMap[23] = "09:00"
            xLabelMap[31] = "12:00"
            initChart(40)
        }

        button_month.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            xLabelMap[0] = "WEEK 1"
            xLabelMap[9] = "WEEK 2"
            xLabelMap[19] = "WEEK 3"
            xLabelMap[29] = "WEEK 4"
            xLabelMap[39] = "WEEK 5"
            initChart(50)
        }

        button_three_months.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            xLabelMap[0] = "JAN"
            xLabelMap[11] = ""
            xLabelMap[23] = "FEB"
            xLabelMap[35] = ""
            xLabelMap[47] = "MAR"
            xLabelMap[6] = "01:10"
            initChart(60)
        }

        button_year.setOnClickListener {
            button_ten_min.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_hour.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_three_months.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorDodgerBlue))
            xLabelMap[0] = "JAN"
            xLabelMap[15] = "APR"
            xLabelMap[31] = "JUL"
            xLabelMap[47] = "OCT"
            xLabelMap[63] = "DEC"
            initChart(80)
        }
    }

    private fun initChart(count: Int) {
        chart.setViewPortOffsets(0f, 0f, 0f, 0f)
        chart.description.isEnabled = false
        chart.setTouchEnabled(true)
        chart.isDragEnabled = true
        chart.setScaleEnabled(true)
        chart.setPinchZoom(false)
        chart.setDrawGridBackground(false)

        val x = chart.xAxis
        x.setLabelCount(6, true)
        x.textColor = ContextCompat.getColor(this, R.color.colorSlateGrey)
        x.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        x.setDrawGridLines(true)
        x.axisLineColor = ContextCompat.getColor(this, R.color.colorSlateGrey)
        x.setCenterAxisLabels(true)
        x.setValueFormatter { value, _ ->
            return@setValueFormatter xLabelMap[value.toInt()] ?: value.toString()
        }

        val y = chart.axisLeft
        y.textColor = ContextCompat.getColor(this, R.color.colorWhite)
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
        y.setDrawGridLines(true)
        y.axisLineColor = ContextCompat.getColor(this, R.color.colorSlateGrey)
        y.setCenterAxisLabels(true)

        chart.axisRight.isEnabled = false
        chart.legend.isEnabled = false
        chart.animateX(2000)
        setData(count, 1F)
        chart.invalidate()
    }

    private fun setData(count: Int, range: Float) {
        val values = ArrayList<Entry>()
        for (i in 0 until count) {
            val `val` = (Math.random() * (range + 1)).toFloat() + 500
            values.add(Entry(i.toFloat(), `val`))
        }
        val set1: LineDataSet
        if (chart.data != null && chart.data.dataSetCount > 0) {
            set1 = chart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            set1 = LineDataSet(values, "")
            set1.mode = LineDataSet.Mode.LINEAR
            set1.cubicIntensity = 0.2f
            set1.setDrawFilled(false)
            set1.setDrawCircles(false)
            set1.lineWidth = 1.8f
            set1.highLightColor = Color.rgb(244, 117, 117)
            set1.color = ContextCompat.getColor(this, R.color.colorDodgerBlue)
            set1.fillColor = Color.WHITE
            set1.fillAlpha = 100
            set1.setDrawHorizontalHighlightIndicator(false)
            set1.fillFormatter = IFillFormatter { _, _ -> chart.axisLeft.axisMinimum }
            val data = LineData(set1)
            data.setDrawValues(false)
            chart.data = data
        }
    }
}