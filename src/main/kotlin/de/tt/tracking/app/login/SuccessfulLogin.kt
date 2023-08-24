package de.tt.tracking.app.login

import java.util.UUID

data class SuccessfulLogin(
    val groupId: UUID,
    val memberId: UUID,
    val color: Int,
)
