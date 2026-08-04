package com.diegoduarte.devlog_api.business;

import com.diegoduarte.devlog_api.business.dtos.request.ComentDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.ComentDTOResponse;
import com.diegoduarte.devlog_api.business.mapper.ComentMapper;
import com.diegoduarte.devlog_api.infrastructure.entities.ComentEntity;
import com.diegoduarte.devlog_api.infrastructure.entities.PostEntity;
import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import com.diegoduarte.devlog_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.devlog_api.infrastructure.repositories.ComentRepository;
import com.diegoduarte.devlog_api.infrastructure.repositories.PostRepository;
import com.diegoduarte.devlog_api.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentService {

    private final ComentRepository comentRepository;
    private final ComentMapper comentMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ComentDTOResponse criarComent (ComentDTORequest dto, String email, Long id) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado."));

        ComentEntity coment = comentMapper.toEntity(dto);
        coment.setUser(user);
        coment.setPost(post);
        coment.setDataCriacao(LocalDateTime.now());

        return comentMapper.toDTO(comentRepository.save(coment));
    }

    public List<ComentDTOResponse> listarPorPost(Long id) {
        return comentRepository.findByPostId(id)
                .stream()
                .map(comentMapper::toDTO)
                .toList();
    }

    public void deletaById (Long id) {
        ComentEntity entity = comentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Comentario não encontrado."));

        comentRepository.deleteById(id);
    }

}
