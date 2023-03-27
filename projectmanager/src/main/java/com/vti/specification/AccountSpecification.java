package com.vti.specification;

import com.vti.entity.Account;
import com.vti.form.AccountFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class AccountSpecification {
    //class xây dựng mệnh đề where để triển khai FilterForm

    public static Specification<Account> specification(AccountFilterForm form) {
        if (form == null) {
            return null;
        }
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.hasText(form.getSearch())) {
                    String pattern = "%" + form.getSearch() + "%";
                    Predicate hasUsernameLike= criteriaBuilder.like(root.get("username"),pattern);
                  //  Predicate hasDepartmentNameLike=criteriaBuilder.like(root.get("department").get("name"),pattern);
                    Predicate hasFistNameLike= criteriaBuilder.like(root.get("firstName"),pattern);;
                    Predicate hasLastNameLike= criteriaBuilder.like(root.get("lastName"),pattern);;
                    predicates.add(criteriaBuilder.or(hasUsernameLike,
                         //   hasDepartmentNameLike,
                            hasFistNameLike,
                            hasLastNameLike));
                }
                if (form.getMinId() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id"), form.getMinId()));
                }
                if ((form.getMaxId() != null)) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("id"), form.getMaxId()));
                }
                if ((form.getRole()!=null)){
                    predicates.add(criteriaBuilder.equal(root.get("role"), form.getRole()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };

    }


}
