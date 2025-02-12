package ICT_Team2.ITS_Back_End_main.apiPayLoad;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.BaseCode;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 성공한 경우
//    public static <T> ApiResponse<T> onSuccess(T data) {
//        return new ApiResponse<>(data);

    // 실패한 경우
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(true, code, message, data);
    }
}
