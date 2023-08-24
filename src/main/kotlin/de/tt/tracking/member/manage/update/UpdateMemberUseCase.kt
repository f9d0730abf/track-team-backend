package de.tt.tracking.member.manage.update

import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateMemberUseCase(
    private val memberStorage: MemberStorage,
) {
    fun updateProperties(id: UUID, color: Int) {
        val member = memberStorage.get(id)

        val updatedMember = member.changeProperties(color)

        memberStorage.store(updatedMember)
    }
}

class MemberWithIdDoesNotExist(memberId: UUID) : RuntimeException("Member mit id [$memberId] does not exist.")
