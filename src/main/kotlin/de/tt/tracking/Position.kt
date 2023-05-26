package de.tt.tracking

import de.tt.tracking.PositionState.NONE
import java.time.LocalDateTime
import java.time.LocalDateTime.now

data class Position(
    val state: PositionState,
    val latitude: Double,
    val longitude: Double,
    val lastUpdated: LocalDateTime,
)

val NoPosition = Position(
    NONE,
    0.0,
    0.0,
    // MIN geht nicht, da das LocalDateTime dann nicht in die MongoDb geschrieben werden kann
    now()
)
