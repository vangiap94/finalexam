package com.vti.specification;

import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification {
    public static Specification<Department> specification(DepartmentFilterForm form) {
        if (form == null) {
            return null;
        }
        return new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(form.getSearch())) {
                    predicates.add(
                            criteriaBuilder.or(
                            criteriaBuilder.like(root.get("name"), "%" + form.getSearch() + "%"),
                            criteriaBuilder.equal((root.get("type")), form.getType())
                    ));
                }
                if (form.getCreatedAt() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("createdAt").as(LocalDateTime.class), form.getCreatedAt()));

                }
                if (form.getMinCreatedAt() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class), form.getMinCreatedAt()));

                }
                if (form.getMaxCreateAt() != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class), form.getMaxCreateAt()));
                }
                if (form.getMinCreatedYear()!=null){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function("YEAR", Integer.class,
                            root.get("createdAt")), form.getMinCreatedYear()));

                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };

    }
}
