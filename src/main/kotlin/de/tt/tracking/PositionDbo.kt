package de.tt.tracking

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
class PositionDbo(
    val state: PositionState,
    val latitude: Double,
    val longitude: Double,
    val lastUpdated: LocalDateTime,
    @Id val id: UUID,
) {
    fun toPosition() = Position(state, latitude, longitude, lastUpdated, id)
}

fun Position.toDbo() = PositionDbo(state, latitude, longitude, lastUpdated, id)
