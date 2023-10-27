package com.studiosheepdog.dognapper.user.application.service;

import com.studiosheepdog.dognapper.global.exception.DuplicateException;
import com.studiosheepdog.dognapper.user.application.dto.request.UserSignUpDto;
import com.studiosheepdog.dognapper.user.domain.aggregate.entity.User;
import com.studiosheepdog.dognapper.user.domain.aggregate.enums.Role;
import com.studiosheepdog.dognapper.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) throws Exception {

        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new DuplicateException("이미 존재하는 이메일입니다.");
        }

        if (userRepository.findByNickname(userSignUpDto.getNickname()).isPresent()) {
            throw new DuplicateException("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .nickname(userSignUpDto.getNickname())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }
}


