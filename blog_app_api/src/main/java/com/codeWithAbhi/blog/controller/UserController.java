package com.codeWithAbhi.blog.controller;

import com.codeWithAbhi.blog.payloads.ApiResponse;
import com.codeWithAbhi.blog.repository.UserDto;
import com.codeWithAbhi.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//    Post-create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return  new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    Put- update user
    @PutMapping("/")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updatedUser);
    }

//    Delete- Delete user
    @DeleteMapping("/{userId}")
    public  ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.deleteUser(uid);
        return new ResponseEntity(new ApiResponse("User Delete Successfuly",true),HttpStatus.OK);
    }

//    Get- Get All User
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

//    Get -- Get by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));
    }




}
