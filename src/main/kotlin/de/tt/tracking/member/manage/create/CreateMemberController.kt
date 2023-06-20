package de.tt.tracking.member.manage.create

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@ControllerAdvice
@RequestMapping("/members")
class CreateMemberController(private val useCase: CreateMemberUseCase) {

    data class CreateMemberRequest(val name: String)

    @PostMapping
    fun createMember(@RequestBody request: CreateMemberRequest): UUID {
        return useCase.createMember(request.name)
    }

    @ExceptionHandler()
    fun memberAlreadyExistsExceptionHandler(exception: MemberAlreadyExists): ResponseEntity<String> =
        ResponseEntity("User '${exception.name}' already exists.", HttpStatus.BAD_REQUEST)
}
