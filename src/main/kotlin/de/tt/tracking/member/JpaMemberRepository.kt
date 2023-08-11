package de.tt.tracking.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface JpaMemberRepository: JpaRepository<MemberDbo, UUID> {
    fun findByName(name: String): Optional<MemberDbo>

    fun existsByName(name: String): Boolean
}
