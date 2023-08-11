package de.tt.tracking.group

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface JpaGroupRepository: JpaRepository<GroupDbo, UUID> {
    fun findByName(name: String): Optional<GroupDbo>

    fun existsByName(name: String): Boolean
}
