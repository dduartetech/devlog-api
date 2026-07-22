package com.diegoduarte.devlog_api.business;

import com.diegoduarte.devlog_api.business.dtos.request.PostDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.PostDTOResponse;
import com.diegoduarte.devlog_api.business.mapper.PostMapper;
import com.diegoduarte.devlog_api.infrastructure.entities.PostEntity;
import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import com.diegoduarte.devlog_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.devlog_api.infrastructure.repositories.PostRepository;
import com.diegoduarte.devlog_api.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public PostDTOResponse criar(PostDTORequest dto, String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        PostEntity post = postMapper.toEntity(dto);
        post.setUser(user);
        post.setDataCriacao(LocalDateTime.now());

        return postMapper.toDTO(postRepository.save(post));
    }

    public List<PostDTOResponse> listarPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDTO)
                .toList();
    }

    public PostDTOResponse findById (Long id) {
        PostEntity entity = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post não encontrado"));

        return postMapper.toDTO(entity);
    }

    public PostDTOResponse atualizarPorId (Long id, PostDTORequest dto) {
        PostEntity entity = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post não encontrado."));

        entity.setTitulo(dto.getTitulo());
        entity.setConteudo(dto.getConteudo());

        return postMapper.toDTO(postRepository.save(entity));
    }

    public void deletaById (Long id) {
        PostEntity entity = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post não encontrado."));

        postRepository.deleteById(id);
    }
}
