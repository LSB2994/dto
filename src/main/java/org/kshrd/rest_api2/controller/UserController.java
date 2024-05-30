package org.kshrd.rest_api2.controller;

import org.kshrd.rest_api2.model.dto.UserDTO;
import org.kshrd.rest_api2.model.request.UserRequest;
import org.kshrd.rest_api2.model.response.BaseApiResponse;
import org.kshrd.rest_api2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("test")
    public String getMessage(){
        return "welcome to hrd and kshga";
    }
    @GetMapping("/loading")
    public String loading(){
        LOG.warn("This is a warn log");
        LOG.debug("This is a debug log");
        LOG.info("This is a info log");
        LOG.error("This is a error log");
        return "added some log output to console...";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserId(@PathVariable("id") Integer userId){
        BaseApiResponse<UserDTO> response = BaseApiResponse.<UserDTO>builder()
                .message("get user by id success")
                .payload(userService.getUserById(userId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllUser(){
        BaseApiResponse<List<UserDTO>> response = BaseApiResponse.<List<UserDTO>>builder()
                .message("get all user success")
                .payload(userService.getAllUser())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> postUser(@RequestBody UserRequest userRequest){
        Integer userId = userService.addUser(userRequest);
        BaseApiResponse<UserDTO> response = null;
        if (userId!=null){
            response = BaseApiResponse.<UserDTO>builder()
                    .message("Add new user success")
                    .payload(userService.getUserById(userId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else {
            response = BaseApiResponse.<UserDTO>builder()
                    .message("Add new user success")
                    .payload(userService.getUserById(userId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }
}
