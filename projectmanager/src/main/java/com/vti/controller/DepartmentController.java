package com.vti.controller;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import com.vti.specification.DepartmentSpecification;
import com.vti.validation.DepartmentIdExists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IDepartmentService service;

    @GetMapping
    public Page<DepartmentDto> findAll(
            @SortDefault(value = "totalMembers", direction = Sort.Direction.DESC) Pageable pageable, DepartmentFilterForm form) {
        Page<Department> page = service.findAll(pageable, form);
        return page.map(department -> {
                    DepartmentDto dto = mapper.map(department, DepartmentDto.class);
                    dto.add(linkTo(
                            methodOn(DepartmentController.class).findById(department.getId())
                    ).withSelfRel());
                    if (dto.getAccounts() != null) {
                        for (DepartmentDto.AccountDto accountDto : dto.getAccounts()
                        ) {
                            accountDto.add(linkTo(methodOn(AccountController.class).findById(accountDto.getId())).withSelfRel());

                        }
                    }
                    return dto;
                }
        );
    }


    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") @DepartmentIdExists int id) {
        Department department = service.findById(id);
        DepartmentDto dto = mapper.map(department, DepartmentDto.class);
        dto.add(linkTo(
                methodOn(DepartmentController.class).findById(id)
        ).withSelfRel());
        return dto;

    }

    @PostMapping
    public void create(@RequestBody @Valid DepartmentCreateForm form) {
        service.create(form);
    }

    @PutMapping
    public void update(@RequestBody @Valid DepartmentUpdateForm form) {
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    // vì là xoá theo một mảng lên phải truyền theo requestbody
    @DeleteMapping
    public void deleteAllById(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
}
