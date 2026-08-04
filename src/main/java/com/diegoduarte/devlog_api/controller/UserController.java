package com.diegoduarte.devlog_api.controller;

import com.diegoduarte.devlog_api.business.UserService;
import com.diegoduarte.devlog_api.business.dtos.request.LoginDTORequest;
import com.diegoduarte.devlog_api.business.dtos.request.UserDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.LoginDTOResponse;
import com.diegoduarte.devlog_api.business.dtos.response.UserDTOResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "Gerenciamento de usuarios")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTOResponse> cadastraUser (@RequestBody @Valid UserDTORequest dto) {
        return ResponseEntity.ok(userService.cadastraUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTOResponse> login(@RequestBody @Valid LoginDTORequest dto) {
        String token = userService.login(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(LoginDTOResponse.builder().token(token).build());
    }

    @GetMapping
    public ResponseEntity<List<UserDTOResponse>> listarUsers() {
        return ResponseEntity.ok(userService.listarUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOResponse> buscarPorId (@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTOResponse> atualizarPorId (@PathVariable("id") Long id,
                                                           @RequestBody UserDTORequest dto) {
        return ResponseEntity.ok(userService.atualizarPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
