package de.tt.tracking.member

import java.util.UUID

interface MemberStorage {
    fun get(id: UUID): Member

    fun store(member: Member)
}
