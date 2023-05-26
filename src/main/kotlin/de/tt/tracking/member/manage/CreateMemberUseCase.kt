package de.tt.tracking.member.manage

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateMemberUseCase(
    private val storage: MemberStorage
) {
    fun createMember(name: String): UUID {
        val newMember = Member(name)

        storage.store(newMember)

        return newMember.id
    }
}
