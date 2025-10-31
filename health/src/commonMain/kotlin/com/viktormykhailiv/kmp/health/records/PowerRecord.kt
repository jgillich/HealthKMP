package com.viktormykhailiv.kmp.health.records

import com.viktormykhailiv.kmp.health.HealthDataType
import com.viktormykhailiv.kmp.health.HealthDataType.Power
import com.viktormykhailiv.kmp.health.SeriesRecord
import com.viktormykhailiv.kmp.health.records.metadata.Metadata
import kotlin.time.Instant

/**
 * Represents a series of power output measurements.
 *
 * @param startTime The start time of the record.
 * @param endTime The end time of the record.
 * @param samples A list of [Sample] data points for the record.
 * @param metadata Additional metadata for the record.
 */
data class PowerRecord(
    override val startTime: Instant,
    override val endTime: Instant,
    override val samples: List<Sample>,
    override val metadata: Metadata,
) : SeriesRecord<PowerRecord.Sample> {

    override val dataType: HealthDataType = Power

    init {
        require(startTime <= endTime) { "startTime must be before endTime." }
    }

    /**
     * A single power data point.
     *
     * @property time The timestamp of the measurement.
     * @property power The power measurement, in watts.
     */
    data class Sample(
        val time: Instant,
        val power: Double,
    )
}