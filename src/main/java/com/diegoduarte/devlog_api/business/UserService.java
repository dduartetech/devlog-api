package com.diegoduarte.devlog_api.business;

import com.diegoduarte.devlog_api.business.dtos.request.UserDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.UserDTOResponse;
import com.diegoduarte.devlog_api.business.mapper.UserMapper;
import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import com.diegoduarte.devlog_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.devlog_api.infrastructure.repositories.UserRepository;
import com.diegoduarte.devlog_api.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserDTOResponse cadastraUser (UserDTORequest dto) {
        dto.setSenha(passwordEncoder.encode(dto.getSenha()));
        UserEntity user = userMapper.toEntity(dto);
        user.setAtivo(true);
        return userMapper.toDTO(userRepository.save(user));
    }

    public String login(String email, String senha) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        if (!passwordEncoder.matches(senha, user.getSenha())) {
            throw new RuntimeException("Senha inválida.");
        }

        return jwtUtil.generateToken(email);
    }

    public List<UserDTOResponse> listarUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public UserDTOResponse buscarPorId (Long id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User não encontrado."));

        return userMapper.toDTO(entity);
    }

    public UserDTOResponse atualizarPorId(Long id, UserDTORequest dto) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User não encontrado."));

        if (dto.getNome() != null) entity.setNome(dto.getNome());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getSenha() != null) entity.setSenha(passwordEncoder.encode(dto.getSenha()));

        return userMapper.toDTO(userRepository.save(entity));
    }

    public void deleteById (Long id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User não encontrado."));

        entity.setAtivo(false);

        userRepository.save(entity);
    }
}
