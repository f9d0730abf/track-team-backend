package de.tt.tracking.member

import de.tt.tracking.Position
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("members")
data class MemberDbo(
    @Id val id: UUID,
    val name: String,
    val position: Position,
    val group: MemberGroup,
) {

    fun toMember() = Member(id, name, position, group)
}

fun Member.toDbo() = MemberDbo(this.id, this.name, this.position, this.group)
