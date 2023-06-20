package de.tt.tracking.group

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional
import java.util.UUID

interface MongoDbGroupRepository: MongoRepository<GroupDbo, UUID> {
    fun findByName(name: String): Optional<GroupDbo>

    fun existsByName(name: String): Boolean
}
