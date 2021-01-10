package net.elau.example.springdataenversoracledb.web.controller

import net.elau.example.springdataenversoracledb.web.response.ErrorResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, headers: HttpHeaders,
        status: HttpStatus, request: WebRequest
    ): ResponseEntity<Any> {
        val details: MutableList<String?> = ArrayList()
        for (error in ex.bindingResult.allErrors) {
            details.add(error.defaultMessage)
        }
        val error = ErrorResponse("Validation Failed", details)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val details: MutableList<String?> = ArrayList()
        details.add(ex.localizedMessage)
        val error = ErrorResponse("Server Error", details)
        return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
