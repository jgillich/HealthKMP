package com.viktormykhailiv.kmp.health.records

import com.viktormykhailiv.kmp.health.HealthDataType
import com.viktormykhailiv.kmp.health.HealthDataType.CyclingPedalingCadence
import com.viktormykhailiv.kmp.health.SeriesRecord
import com.viktormykhailiv.kmp.health.records.metadata.Metadata
import kotlin.time.Instant


/**
 * Captures the user's pedaling cadence during a workout. Each record represents a series of
 * measurements.
 *
 * @param startTime The start time of the record.
 * @param endTime The end time of the record.
 * @param samples The list of cadence samples, each containing a timestamp and the pedaling rate.
 * @param metadata Associated metadata for the record.
 */
data class CyclingPedalingCadenceRecord(
    override val startTime: Instant,
    override val endTime: Instant,
    override val samples: List<Sample>,
    override val metadata: Metadata,
) : SeriesRecord<CyclingPedalingCadenceRecord.Sample> {

    override val dataType: HealthDataType = CyclingPedalingCadence

    init {
        require(startTime <= endTime) { "startTime must be before endTime." }
    }

    /**
     * A single measurement of the pedaling rate at a specific instant in time.
     *
     * @param time The point in time when the measurement was taken.
     * @param revolutionsPerMinute The pedaling rate in revolutions per minute (RPM).
     */
    data class Sample(
        val time: Instant,
        val revolutionsPerMinute: Double,
    )
}
