package org.kshrd.rest_api2.model.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String address;
}
