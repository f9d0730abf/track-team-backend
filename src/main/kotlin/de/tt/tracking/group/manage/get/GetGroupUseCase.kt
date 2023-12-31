package de.tt.tracking.group.manage.get

import de.tt.tracking.group.GroupStorage
import org.springframework.stereotype.Component
import java.util.UUID
import de.tt.tracking.Position as CorePosition

@Component
class GetGroupUseCase(
    private val storage: GroupStorage
) {
    fun getGroup(groupId: UUID, memberId: UUID): Group {
        val group = storage.get(groupId)

        val members = group.members.map {
            Member(it.name, it.color, Position.from(it.position), it.id == memberId)
        }.toSet()

        return Group(group.name, members)
    }
}

data class Group(
    val name: String,
    val members: Set<Member>
)

data class Member(
    val name: String,
    val color: Int,
    val position: Position,
    val isItYou: Boolean,
)

enum class PositionState {
    NONE,
    ACTIVE,
    OUTDATED
}

data class Position(
    val state: PositionState,
    val latitude: Double,
    val longitude: Double,
) {
    companion object {
        fun from(position: CorePosition) = Position(
            PositionState.ACTIVE,
            position.latitude,
            position.longitude,
        )
    }
}

class GroupWithNameDoesNotExist(val name: String): RuntimeException("Group with name [$name] does not exist.")

class GroupWithIdDoesNotExist(val id: UUID): RuntimeException("Group with id [$id] does not exist.")
