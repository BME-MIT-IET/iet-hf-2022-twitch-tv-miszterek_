package peczedavid.nhf.animation

import peczedavid.nhf.model.Point

data class MovementInfo (
    val start: Point,
    val end: Point,
    val startValue: Int,
    val endValue: Int,
) {
    val sum : Boolean
        get() = startValue != endValue
}