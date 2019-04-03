package com.jay.angel

import android.graphics.Paint
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_graph3.*
import java.util.*

class Graph3Activity : AppCompatActivity() {

    private lateinit var chart: CombinedChart
    private var count = 24
    private lateinit var xLabel: Array<String>
    private var yLabel =
        arrayOf("3,920.21", "3,950.19", "3,990.21", "4,055.16", "4,120.48", "4,185.54", "4,250.30", "4,300.30")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph3)

        supportActionBar?.hide()
        chart = findViewById(R.id.combined_chart)

        xLabel = arrayOf(
            "00:00",
            "01:00",
            "02:00",
            "03:00",
            "04:00",
            "05:00",
            "06:00",
            "07:00",
            "08:00",
            "09:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00",
            "16:00",
            "17:00",
            "18:00",
            "19:00",
            "20:00",
            "21:00",
            "22:00",
            "23:00",
            "24:00"
        )
        count = 24
        initChart()

        button_day.setOnClickListener {
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
            button_week.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day_dot.isEnabled = true
            button_week_dot.isEnabled = false
            button_month_dot.isEnabled = false
            button_year_dot.isEnabled = false
            xLabel = arrayOf(
                "00:00",
                "01:00",
                "02:00",
                "03:00",
                "04:00",
                "05:00",
                "06:00",
                "07:00",
                "08:00",
                "09:00",
                "10:00",
                "11:00",
                "12:00",
                "13:00",
                "14:00",
                "15:00",
                "16:00",
                "17:00",
                "18:00",
                "19:00",
                "20:00",
                "21:00",
                "22:00",
                "23:00",
                "24:00"
            )
            count = 24
            initChart()
        }

        button_week.setOnClickListener {
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_week.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day_dot.isEnabled = false
            button_week_dot.isEnabled = true
            button_month_dot.isEnabled = false
            button_year_dot.isEnabled = false
            xLabel = arrayOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
            count = 24
            count = 34
            initChart()
        }

        button_month.setOnClickListener {
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_week.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_day_dot.isEnabled = false
            button_week_dot.isEnabled = false
            button_month_dot.isEnabled = true
            button_year_dot.isEnabled = false
            xLabel = arrayOf("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC")
            count = 44
            initChart()
        }

        button_year.setOnClickListener {
            button_day.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_week.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_month.setTextColor(ContextCompat.getColor(this, R.color.colorSlateGrey))
            button_year.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
            button_day_dot.isEnabled = false
            button_week_dot.isEnabled = false
            button_month_dot.isEnabled = false
            button_year_dot.isEnabled = true
            xLabel = arrayOf("2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019")
            count = 54
            initChart()
        }
    }

    private fun initChart() {
        chart.description.isEnabled = false
        chart.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
        chart.setDrawGridBackground(false)
        chart.setDrawBarShadow(false)
        chart.isHighlightFullBarEnabled = false
        chart.legend.isEnabled = false
        chart.drawOrder = arrayOf(
            CombinedChart.DrawOrder.BAR,
            CombinedChart.DrawOrder.CANDLE,
            CombinedChart.DrawOrder.LINE
        )
        val rightAxis = chart.axisRight
        rightAxis.setDrawGridLines(true)
        rightAxis.textColor = ContextCompat.getColor(this, R.color.colorWhite)
        rightAxis.setValueFormatter { value, _ ->
            return@setValueFormatter yLabel[value.toInt() % yLabel.size]
        }
        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textColor = ContextCompat.getColor(this, R.color.colorWhite)
        xAxis.axisMinimum = 0f
        xAxis.granularity = 1f
        xAxis.setValueFormatter { value, _ ->
            return@setValueFormatter xLabel[value.toInt() % xLabel.size]
        }
        val data = CombinedData()
        data.setData(generateLineData())
        data.setData(generateBarData())
        data.setData(generateCandleData())
        xAxis.axisMaximum = data.xMax + 0.25f
        chart.data = data
        chart.animateX(1500)
        chart.invalidate()
    }

    private fun generateLineData(): LineData {
        val dataSets = ArrayList<ILineDataSet>()
        for (z in 0..1) {
            val values = ArrayList<Entry>()
            for (i in 0 until count / 3 + 1) {
                val `val` = Math.random() * count + 50
                values.add(Entry(i.toFloat() * 3, `val`.toFloat()))
            }
            val d = LineDataSet(values, "")
            d.setDrawCircles(false)
            d.mode = LineDataSet.Mode.CUBIC_BEZIER
            dataSets.add(d)
        }
        (dataSets[0] as LineDataSet).color = ContextCompat.getColor(this, R.color.colorDodgerBlue)
        (dataSets[1] as LineDataSet).color = ContextCompat.getColor(this, R.color.colorWhite)
        val data = LineData(dataSets)
        data.setDrawValues(false)
        return data
    }

    private fun generateBarData(): BarData {
        val start = 1f
        val values = ArrayList<BarEntry>()
        var i = start.toInt()
        while (i < start + count) {
            val `val` = (Math.random() * (count / 2 + 1)).toFloat()
            if (Math.random() * 100 < 25) {
                values.add(BarEntry(i.toFloat(), `val`))
            } else {
                values.add(BarEntry(i.toFloat(), `val`))
            }
            i++
        }
        val set1: BarDataSet
        set1 = BarDataSet(values, "")
        set1.setDrawIcons(false)
        set1.color = ContextCompat.getColor(this, R.color.colorDark)
        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(set1)
        val data = BarData(dataSets)
        data.setValueTextSize(10f)
        data.barWidth = 0.6f
        return data
    }

    private fun generateCandleData(): CandleData {
        val values = ArrayList<CandleEntry>()
        for (i in 0 until count) {
            val multi = (count + 1).toFloat()
            val `val` = (Math.random() * 40).toFloat() + multi
            val high = (Math.random() * 9).toFloat() + 8f
            val low = (Math.random() * 9).toFloat() + 8f
            val open = (Math.random() * 6).toFloat() + 1f
            val close = (Math.random() * 6).toFloat() + 1f
            val even = i % 2 == 0
            values.add(
                CandleEntry(
                    i.toFloat(), `val` + high,
                    `val` - low,
                    if (even) `val` + open else `val` - open,
                    if (even) `val` - close else `val` + close
                )
            )
        }
        val set1 = CandleDataSet(values, "Data Set")
        set1.setDrawIcons(false)
        set1.axisDependency = YAxis.AxisDependency.LEFT
        set1.shadowColor = ContextCompat.getColor(this, R.color.colorGreenBlue)
        set1.shadowWidth = 0.7f
        set1.decreasingColor = ContextCompat.getColor(this, R.color.colorGrapeFruit)
        set1.decreasingPaintStyle = Paint.Style.FILL_AND_STROKE
        set1.increasingColor = ContextCompat.getColor(this, R.color.colorGreenBlue)
        set1.increasingPaintStyle = Paint.Style.FILL_AND_STROKE
        set1.neutralColor = ContextCompat.getColor(this, R.color.colorGreenBlue)
        return CandleData(set1)
    }
}