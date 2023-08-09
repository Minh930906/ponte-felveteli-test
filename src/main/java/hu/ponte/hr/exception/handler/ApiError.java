package hu.ponte.hr.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private String message;
    private Integer code;
    private LocalDateTime dateTime;
}
