package de.tt.tracking.member

import java.util.UUID

interface MemberStorage {
    fun get(id: UUID): Member

    fun get(name: String): Member

    fun exists(name: String): Boolean

    fun store(member: Member)
}
