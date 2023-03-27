package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DepartmentDto extends RepresentationModel<DepartmentDto> {
    private int id;
    private String name;
    private int totalMembers;
    private String type;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private List<AccountDto> accounts;

    @Getter
    @Setter
    public static class AccountDto extends RepresentationModel<AccountDto> {
        private int id;
        private String username;
    }
}
