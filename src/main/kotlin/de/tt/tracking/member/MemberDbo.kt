package de.tt.tracking.member

import de.tt.tracking.PositionDbo
import de.tt.tracking.toDbo
import jakarta.persistence.CascadeType
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity
data class MemberDbo(
    @Id val id: UUID,
    val name: String,
    @OneToOne(cascade = [CascadeType.ALL])
    val position: PositionDbo,
    @ElementCollection
    val groups: Set<UUID>,
) {
    fun toMember() = Member(id, name, position.toPosition(), groups)
}

fun Member.toDbo() = MemberDbo(this.id, this.name, this.position.toDbo(), this.groups)
