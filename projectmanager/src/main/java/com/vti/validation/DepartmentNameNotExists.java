package com.vti.validation;

import java.lang.annotation.Annotation;


@java.lang.annotation.Documented
@javax.validation.Constraint(validatedBy = DepartmentNameNotExistsValidator.class)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Repeatable(DepartmentNameNotExists.List.class)
public @interface DepartmentNameNotExists {
    java.lang.String message() default "DepartmentNameNotExists already";
    java.lang.Class<?>[] groups() default {};
    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
    @java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @java.lang.annotation.Documented
    static @interface List {
      DepartmentNameNotExists[] value();
    }
}