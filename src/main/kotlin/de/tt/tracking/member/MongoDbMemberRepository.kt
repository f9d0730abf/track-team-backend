package de.tt.tracking.member

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional
import java.util.UUID

interface MongoDbMemberRepository: MongoRepository<MemberDbo, UUID> {
    fun findByName(name: String): Optional<MemberDbo>

    fun existsByName(name: String): Boolean
}
