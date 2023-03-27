package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.entity.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto extends RepresentationModel<AccountDto> {
    private int id;
    private String fullName;
    private String username;
    private String role;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private String departmentName;

}
