package com.studiosheepdog.dognapper.global.oauth2;

import com.studiosheepdog.dognapper.user.domain.aggregate.enums.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

    private String email;
    private Role role;

    /**
     * Constructs a {@code DefaultOAuth2User} using the provided parameters.
     *
     * @param authorities      the authorities granted to the user
     * @param attributes       the attributes about the user
     * @param nameAttributeKey the key used to access the user's &quot;name&quot; from
     *                         {@link #getAttributes()}
     */
    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes, String nameAttributeKey,
                            String email, Role role) {
        super(authorities, attributes, nameAttributeKey);
        this.email = email;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomOAuth2User other = (CustomOAuth2User) obj;
        return Objects.equals(email, other.email) &&
                Objects.equals(role, other.role) &&
                super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role, super.hashCode());
    }
}
