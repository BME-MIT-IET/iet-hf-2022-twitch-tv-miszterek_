package peczedavid.nhf.model

import kotlin.math.roundToInt

class Utils {
    companion object {
        fun getIndex(i: Int, j: Int) : Int {
            return (i * 4) + j
        }

        fun toPixels(dps: Int, density: Float) : Int {
            return (dps * density + 0.5F).toInt()
        }

        fun getIndex(point: Point) : Int {
            return (point.x.toInt() * 4) + point.y.toInt()
        }

        fun getPoint(index: Int) : Point {
            val i = index / 4
            val j = index % 4
            return Point(i.toFloat(), j.toFloat())
        }

        fun formatTime(time: Double) : String {
            val resultInt = time.roundToInt()
            val hours = resultInt % 86400 / 3600
            val minutes = resultInt % 86400 % 3600 / 60
            val seconds = resultInt % 86400 % 3600 % 60

            return String.format("%02d:%02d:%02d", hours, minutes, seconds)
        }
    }
}