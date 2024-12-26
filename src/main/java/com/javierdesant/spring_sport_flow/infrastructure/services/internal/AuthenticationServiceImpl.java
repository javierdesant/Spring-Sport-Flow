package com.javierdesant.spring_sport_flow.infrastructure.services.internal;

import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationRequest;
import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationResponse;
import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.UserRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.AuthenticationService;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import com.javierdesant.spring_sport_flow.infrastructure.services.TokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PlayerService playerService;
    private final TokenService tokenService;
    private final PlayerMapper playerMapper;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Override
    public PlayerResponse register(PlayerRequest request) {
        PlayerEntity player = playerService.create(request);
        String jwt = tokenService.generateToken(player, buildExtraClaims(player));

        PlayerResponse response = playerMapper.toPlayerResponse(player);
        response.setJwt(jwt);

        return response;
    }

    private Map<String, Object> buildExtraClaims(UserEntity user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("authorities", user.getAuthorities());
        extraClaims.put("role", user.getRole());
        return extraClaims;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        );

        authenticationManager.authenticate(authentication);

        UserEntity user = userRepository.findByEmail(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String jwt = tokenService.generateToken(user, buildExtraClaims(user));

        return new AuthenticationResponse(jwt);
    }
}
