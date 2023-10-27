package com.studiosheepdog.dognapper.user.domain.repository;


import com.studiosheepdog.dognapper.user.domain.aggregate.entity.User;
import com.studiosheepdog.dognapper.user.domain.aggregate.enums.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByRefreshToken(String refreshToken);

    // 소셜 타입과 소셜의 식별값으로 회원 찾는 메소드
    Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
