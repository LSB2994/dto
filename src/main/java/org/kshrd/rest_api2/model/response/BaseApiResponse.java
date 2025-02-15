package org.kshrd.rest_api2.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseApiResponse<T> {
    private String message;
    private T payload;
    private Timestamp timestamp;
    private HttpStatus httpStatus;
}
