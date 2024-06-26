package com.example.aboutcoffee.contoller.api.aboutcoffee.handler

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import com.example.aboutcoffee.contoller.api.aboutcoffee.AboutCoffeeApiController
import com.example.aboutcoffee.dto.Error
import com.example.aboutcoffee.dto.ErrorResponse
import java.time.LocalDateTime

@ControllerAdvice(basePackageClasses = [AboutCoffeeApiController::class])
class TodoApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.bindingResult.fieldErrors.forEach { errorObject ->
            Error().apply{
                this.field = (errorObject as FieldError).field
                this.message = errorObject.defaultMessage
                this.value = errorObject.rejectedValue
            }.apply {
                errors.add(this)
            }
        }

        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message=""
            this.path = request.requestURL.toString()
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }
        return ResponseEntity.badRequest().body(errorResponse)
    }
}