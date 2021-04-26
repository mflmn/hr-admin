package com.hr.web.security;

import com.hr.system.dto.ResourceDto;
import com.hr.system.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private UserDto userDto;
    private List<ResourceDto> resourceDtoList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.resourceDtoList.stream()
                .filter(resourceDto -> resourceDto.getResKey() != null)
                .map(resourceDto -> new SimpleGrantedAuthority(resourceDto.getResKey()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "0".equals(userDto.getStatus());
    }
}
