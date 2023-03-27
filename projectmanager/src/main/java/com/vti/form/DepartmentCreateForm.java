package com.vti.form;

import com.vti.validation.AccountUsernameNotExists;
import com.vti.validation.DepartmentNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class DepartmentCreateForm {
    @DepartmentNameNotExists
    @NotBlank(message = "{DepartmentForm.name.NotBlank}")
    @Length(max = 50, message = "{DepartmentForm.name.Length}")
    private String name;
    @NotNull(message = "Department total not null")
    @PositiveOrZero(message = "Total must be >=0")
    private Integer totalMembers;
    @NotNull(message = "Department type can not be null")
    @Pattern(regexp = "DEVELOPER|TESTER|SCRUM_MASTER|PROJECT_MANAGER", message = "type format")
    private String type;

    private List<@Valid Account> accounts;

    @Getter
    @Setter

    public static class Account {
        @NotBlank(message = "account username can not null")
        @Length(max = 50, message = "account username has max 50 characters")

        @AccountUsernameNotExists
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String role;
    }
}
