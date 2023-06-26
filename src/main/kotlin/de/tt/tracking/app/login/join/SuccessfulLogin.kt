package de.tt.tracking.app.login.join

import java.util.UUID

data class SuccessfulLogin(
    val groupId: UUID,
    val memberId: UUID,
)
