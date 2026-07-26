package com.diegoduarte.devlog_api.controller;

import com.diegoduarte.devlog_api.business.PostService;
import com.diegoduarte.devlog_api.business.dtos.request.PostDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.PostDTOResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Tag(name = "Post", description = "Gerenciamento de posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDTOResponse> criar(@RequestBody @Valid PostDTORequest dto,
                                                 Principal principal) {

        return ResponseEntity.ok(postService.criar(dto, principal.getName()));
    }

    @GetMapping
    public ResponseEntity<List<PostDTOResponse>> listarPosts() {
        return ResponseEntity.ok(postService.listarPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTOResponse> findById (@PathVariable("id") Long id) {
       return ResponseEntity.ok(postService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTOResponse> atualizarPorId (@PathVariable("id") Long id,
                                           @RequestBody PostDTORequest dto) {
        return ResponseEntity.ok(postService.atualizarPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaById (@PathVariable("id") Long id) {
        postService.deletaById(id);
        return ResponseEntity.ok().build();
    }

}
