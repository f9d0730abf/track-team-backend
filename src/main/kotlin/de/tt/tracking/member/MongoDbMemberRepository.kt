package de.tt.tracking.member

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface MongoDbMemberRepository: MongoRepository<MemberDbo, UUID>
