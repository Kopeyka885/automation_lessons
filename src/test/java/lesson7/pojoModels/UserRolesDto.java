package lesson7.pojoModels;

import java.util.List;

public class UserRolesDto {
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserRolesDto(List<String> roles) {
        this.roles = roles;
    }
}
