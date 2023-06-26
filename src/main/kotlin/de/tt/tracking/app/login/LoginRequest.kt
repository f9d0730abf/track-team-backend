package de.tt.tracking.app.login

data class LoginRequest(
    val serverPassword: String,
    val username: String,
    val groupName: String,
    val groupPassword: String,
)
