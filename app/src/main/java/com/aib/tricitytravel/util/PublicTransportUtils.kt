package com.aib.tricitytravel.util

import com.aib.tricitytravel.R
import com.aib.tricitytravel.TricityTravel
import com.aib.tricitytravel.ui.publictransportfragment.DelayStatus
import java.util.concurrent.TimeUnit

class PublicTransportUtils {

    companion object {

        fun getDelayStatusFrom(delayInSeconds: Int): DelayStatus {
            return when (delayInSeconds) {
                in Int.MIN_VALUE..-61 -> DelayStatus.AHEAD_OF_TIME
                in -60..30 -> DelayStatus.ON_TIME
                in 31..Int.MAX_VALUE -> DelayStatus.DELAYED
                else -> throw IndexOutOfBoundsException("Delay is out of range.")
            }
        }

        fun getDelayStatusDescription(delayStatus: DelayStatus): String {
            return when (delayStatus) {
                DelayStatus.AHEAD_OF_TIME -> TricityTravel.res?.getString(R.string.ahead_of_time)!!
                DelayStatus.ON_TIME -> TricityTravel.res?.getString(R.string.on_time)!!
                DelayStatus.DELAYED -> TricityTravel.res?.getString(R.string.delayed)!!
            }
        }

        fun calculateDelayFrom(delayInSeconds: Int): String {
            val minutes = TimeUnit.SECONDS.toMinutes(delayInSeconds.toLong())
            return "$minutes min ${delayInSeconds - (60 * minutes)} s"
        }

        fun getImageResource(routeId: String): Int {
            return if (routeId.length >= 3)
                R.drawable.ic_bus
            else
                R.drawable.ic_tram
        }
    }
}