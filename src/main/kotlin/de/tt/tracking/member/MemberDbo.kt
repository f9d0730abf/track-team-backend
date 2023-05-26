package de.tt.tracking.member

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("members")
data class MemberDbo(
    @Id val id: UUID,
    val name: String,
    val groups: Set<UUID>,
) {

    fun toMember() = Member(id, name, groups)
}

fun Member.toDbo() = MemberDbo(this.id, this.name, this.groups)
