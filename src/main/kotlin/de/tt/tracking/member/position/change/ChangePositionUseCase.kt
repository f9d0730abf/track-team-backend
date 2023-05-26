package de.tt.tracking.member.position.change

import de.tt.tracking.member.Member
import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ChangePositionUseCase(
    private val storage: MemberStorage
) {
    fun changePosition(id: UUID, newLatitude: Double, newLongitude: Double): Member {
        val member = storage.get(id)

        val updatedMember = member.changePosition(newLatitude, newLongitude)

        storage.store(updatedMember)

        return updatedMember
    }
}
