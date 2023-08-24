package de.tt.tracking.app.login.join

import de.tt.tracking.app.login.LoginRequest
import de.tt.tracking.app.login.SuccessfulLogin
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ControllerAdvice
@RequestMapping("/login/join")
class LoginJoinGroupController(private val useCase: LoginJoinGroupUseCase) {

    @PostMapping
    fun loginCreateGroup(@RequestBody request: LoginRequest): SuccessfulLogin {
        return useCase.joinGroup(
            request.serverPassword,
            request.username,
            request.groupName,
            request.groupPassword,
        )
    }
}
