package de.tt.tracking.app.login.join

import de.tt.tracking.app.login.LoginRequest
import de.tt.tracking.app.login.SuccessfulLogin
import de.tt.tracking.group.GroupWithNameDoesNotExist
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
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

    @ExceptionHandler
    fun wrongGroupPasswordExceptionHandler(exception: WrongGroupPasswordException) =
        ResponseEntity("Group password is invalid", HttpStatus.UNAUTHORIZED)

    @ExceptionHandler
    fun groupWithNameDoesNotExist(exception: GroupWithNameDoesNotExist) =
        ResponseEntity("Group '${exception.name}' does not exist", BAD_REQUEST)
}
