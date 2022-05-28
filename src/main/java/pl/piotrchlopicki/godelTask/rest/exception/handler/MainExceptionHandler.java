package pl.piotrchlopicki.godelTask.rest.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.piotrchlopicki.godelTask.rest.dto.ApiErrorResponse;
import pl.piotrchlopicki.godelTask.rest.exception.BadRequestException;
import pl.piotrchlopicki.godelTask.rest.exception.BaseApiException;
import pl.piotrchlopicki.godelTask.rest.exception.NotFoundException;

@ControllerAdvice
public class MainExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<ApiErrorResponse> handleNotFoundException(BaseApiException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorMessage(ex));
    }

    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<ApiErrorResponse> handleBadRequestException(BaseApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createErrorMessage(ex));
    }

    private ApiErrorResponse createErrorMessage(BaseApiException ex) {
        return ApiErrorResponse.builder()
                .message(ex.getMessage())
                .code(ex.getCode())
                .details(ex.getDetails())
                .build();
    }
}
