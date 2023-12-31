package de.tt.tracking.member.position.change

import de.tt.tracking.member.MemberStorage
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ChangePositionUseCase(
    private val memberStorage: MemberStorage,
) {
    fun changePosition(id: UUID, newLatitude: Double, newLongitude: Double) {
        val member = memberStorage.get(id)

        val updatedMember = member.changePosition(newLatitude, newLongitude)

        memberStorage.store(updatedMember)
    }
}
