package com.example.pstuedu.controller;

import com.example.pstuedu.entity.Group;
import com.example.pstuedu.exception.GroupNotFoundException;
import com.example.pstuedu.exception.GroupNotUniqueException;
import com.example.pstuedu.exception.UserAlreadyHaveGroupException;
import com.example.pstuedu.exception.UserNotFoundException;
import com.example.pstuedu.service.implementation.GroupServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupServiceImplementation groupService;

    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestBody Group group){
        try {
            groupService.createGroup(group);

            String serverAnswer = String.format("Группа %s создана!", group.getName());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);
        } catch (GroupNotUniqueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGroup(@PathVariable Long id){
        try {
            return new ResponseEntity<>(groupService.findGroupById(id), HttpStatus.OK) ;
        } catch (GroupNotFoundException e) {
            return new ResponseEntity<>("Группа не найдена!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id){
        try {
            groupService.deleteGroupById(id);
            return new ResponseEntity<>("Группа успешно удалена!", HttpStatus.OK);
        } catch (GroupNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Устанавливает юзеру группу, а группе плюсует юзера
    @PostMapping("/get/{group_id}/adduser/{user_id}")
    public ResponseEntity<?> addUser(@PathVariable Long group_id, @PathVariable Long user_id){
        try {
            groupService.addUserToGroup(user_id, group_id);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        } catch (GroupNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        } catch (UserAlreadyHaveGroupException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Добавление пользователя в группу успешно!", HttpStatus.OK);
    }
}
