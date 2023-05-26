package de.tt.tracking.member

import java.util.UUID

data class Member(
    val id: UUID,
    val name: String,
    val groups: Set<UUID>,
) {
    constructor(name: String) : this(
        UUID.randomUUID(),
        name,
        emptySet(),
    )

    fun addGroup(groupId: UUID) = copy(
        groups = groups + groupId
    )
}
