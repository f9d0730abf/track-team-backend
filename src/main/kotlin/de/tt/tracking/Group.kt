package de.tt.tracking

import de.tt.tracking.member.Member

data class Group(
    val name: String,
    val members: Set<Member>,
)
