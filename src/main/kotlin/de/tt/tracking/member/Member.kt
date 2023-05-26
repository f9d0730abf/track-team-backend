package de.tt.tracking.member

import de.tt.tracking.NoId
import de.tt.tracking.NoPosition
import de.tt.tracking.Position
import de.tt.tracking.PositionState.ACTIVE
import java.time.LocalDateTime.now
import java.util.UUID

data class Member(
    val id: UUID,
    val name: String,
    val position: Position,
    val group: MemberGroup,
) {
    constructor(name: String) : this(
        UUID.randomUUID(),
        name,
        NoPosition,
        NoMemberGroup,
    )

    fun changePosition(newLatitude: Double, newLongitude: Double) = this.copy(
        position = Position(
            ACTIVE,
            newLatitude,
            newLongitude,
            now()
        )
    )
}

data class MemberGroup(
    val hasGroup: Boolean,
    val groupId: UUID,
)

val NoMemberGroup = MemberGroup(
    false,
    NoId
)
