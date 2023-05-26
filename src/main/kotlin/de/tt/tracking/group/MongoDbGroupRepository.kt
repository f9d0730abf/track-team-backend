package de.tt.tracking.group

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface MongoDbGroupRepository: MongoRepository<GroupDbo, UUID>
