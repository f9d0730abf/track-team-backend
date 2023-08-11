package de.tt.tracking

import de.tt.tracking.PositionState.NONE
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

data class Position(
    val state: PositionState = NONE,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val lastUpdated: LocalDateTime = now(),
    val id: UUID = UUID.randomUUID(),
) {
    fun change(newLatitude: Double, newLongitude: Double) = Position(
        PositionState.ACTIVE,
        newLatitude,
        newLongitude,
        now(),
        id
    )
}
