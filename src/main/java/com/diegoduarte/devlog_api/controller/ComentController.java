package com.diegoduarte.devlog_api.controller;

import com.diegoduarte.devlog_api.business.ComentService;
import com.diegoduarte.devlog_api.business.dtos.request.ComentDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.ComentDTOResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/coments")
@RequiredArgsConstructor
@Tag(name = "Coment", description = "Gerenciamento de coments")
public class ComentController {

    private final ComentService comentService;

    @PostMapping
    public ResponseEntity<ComentDTOResponse> criarComent (@RequestBody @Valid ComentDTORequest dto,
                                                          Principal principal) {

        return ResponseEntity.ok(comentService.criarComent(dto, principal.getName(), dto.getPostId()));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<ComentDTOResponse>> listarPorPost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(comentService.listarPorPost(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaById (@PathVariable("id") Long id) {
        comentService.deletaById(id);
        return ResponseEntity.ok().build();

    }
}
