package de.tt.tracking.member.position.change

import de.tt.tracking.member.MemberStorage
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ChangePositionUseCase(
    private val memberStorage: MemberStorage,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun changePosition(id: UUID, newLatitude: Double, newLongitude: Double) {
        val member = memberStorage.get(id)

        val updatedMember = member.changePosition(newLatitude, newLongitude)

        memberStorage.store(updatedMember)

        logger.info("Updated Position of ${member.name} to ($newLatitude, $newLongitude)")
    }
}
