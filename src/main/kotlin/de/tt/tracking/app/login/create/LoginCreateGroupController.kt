package de.tt.tracking.app.login.create

import de.tt.tracking.app.login.LoginRequest
import de.tt.tracking.app.login.SuccessfulLogin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login/create")
class LoginCreateGroupController(private val useCase: LoginCreateGroupUseCase) {

    @PostMapping
    fun loginCreateGroup(@RequestBody request: LoginRequest): SuccessfulLogin {
        return useCase.createGroup(
            request.serverPassword,
            request.username,
            request.groupName,
            request.groupPassword,
        )
    }
}
