package com.viktormykhailiv.kmp.health.aggregate

import com.viktormykhailiv.kmp.health.HealthAggregatedRecord
import com.viktormykhailiv.kmp.health.HealthDataType
import com.viktormykhailiv.kmp.health.HealthDataType.Power
import kotlin.time.Instant

/**
 * Captures the aggregated user's power output rate.
 *
 * @param avg Average watts.
 * @param min Minimum watts.
 * @param max Maximum watts.
 */
data class PowerAggregatedRecord(
    val startTime: Instant,
    val endTime: Instant,
    val avg: Double,
    val min: Double,
    val max: Double,
) : HealthAggregatedRecord {

    override val dataType: HealthDataType = Power
}
