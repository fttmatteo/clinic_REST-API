package app.domain.model;

import app.domain.model.emuns.Role;

public class Employee extends Person {
    private Role role;
    private Employee username;
    private Employee password;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Employee getUsername() {
        return username;
    }
    public void setUsername(Employee username) {
        this.username = username;
    }
    public Employee getPassword() {
        return password;
    }
    public void setPassword(Employee password) {
        this.password = password;
    }
}
