package ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.ApiResponse;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.ErrorStatus;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.CommentNotFoundException;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.GeneralException;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//public class GlobalExceptionHandler {

//  @ExceptionHandler(CommentNotFoundException.class)
//  public ResponseEntity<ApiResponse<String>> handleCommentNotFoundException(CommentNotFoundException ex) {
//    // CommentNotFoundException 처리
//    return ResponseEntity.status(404)
//        .body(ApiResponse.onFailure("NOT_FOUND", ex.getMessage(), null));
//  }
//
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception ex) {
//    // 일반 예외 처리
//    return ResponseEntity.status(500)
//        .body(ApiResponse.onFailure("INTERNAL_SERVER_ERROR", "An unexpected error occurred", null));
//  }
//}
