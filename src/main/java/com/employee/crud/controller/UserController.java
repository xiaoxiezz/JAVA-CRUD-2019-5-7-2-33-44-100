package com.employee.crud.controller;

import com.employee.crud.service.UserService;
import com.employee.crud.entity.User;
import com.employee.crud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees")
//ToDo:在上一行代码("")中填写合适的RestfulApi
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity updateUserById(@PathVariable int userId, @RequestBody User user) throws BusinessException {
        userService.updateUserById(userId, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/user/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity deleteUserById(@PathVariable int userId) throws BusinessException {
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
