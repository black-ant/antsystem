package com.serverauthcenter.demo.entity;

import java.beans.Transient;
import java.util.HashSet;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:21
 * @Version 1.0
 **/

@Data
@Entity(name="user_summary")
public class UserSummaryEntity implements UserDetails{

    @Id
    @GeneratedValue
    private Long sn;
    private Long useid;
    private String username;
    private String userfrom;
    private String userstatus;
    @ManyToMany(targetEntity = UserRolesEntity.class, fetch = FetchType.EAGER)
    private List<UserRolesEntity> userroles;
    @Transient
    private Set<GrantedAuthority> authorities = new HashSet<>();
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : this.roles) {
            for (Authority authority : role.getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(authority.getValue()));
            }
        }
        return authorities;
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
        return true;
    }
}