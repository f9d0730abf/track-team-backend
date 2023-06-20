package de.tt.tracking.group

import java.util.UUID

interface GroupStorage {
    fun get(id: UUID): Group

    fun get(ids: Set<UUID>): Set<Group>

    fun get(name: String): Group

    fun store(group: Group)

    fun store(groups: Set<Group>)
}
