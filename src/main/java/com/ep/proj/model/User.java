package com.ep.proj.model;

import java.time.LocalDate;

public class User extends BaseEntity{
    private String password;
    private String email;
    private Role role;
    private Position position;
    private boolean enabled;
    private LocalDate busyUntil;

    public User(Integer id, String name, String password, String email, Role role, Position position, boolean enabled, LocalDate busyUntil) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.role = role;
        this.position = position;
        this.enabled = enabled;
        this.busyUntil = busyUntil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getBusyUntil() {
        return busyUntil;
    }

    public void setBusyUntil(LocalDate busyUntil) {
        this.busyUntil = busyUntil;
    }
}