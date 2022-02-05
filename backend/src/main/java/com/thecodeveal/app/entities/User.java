package com.thecodeveal.app.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "AUTH_USER_DETAILS")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "USER_KEY")
    private String password;

    @Column(name = "CREATED_ON")
    private Date createdAt;

    @Column(name = "UPDATED_ON")
    private Date updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled")
    private boolean enabled = true;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "AUTH_USER_AUTHORITY", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Authority> authorities;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_cards", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Card> cards;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return this.enabled;
    }


}
