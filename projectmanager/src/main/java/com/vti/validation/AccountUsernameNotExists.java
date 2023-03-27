
package com.vti.validation;


@java.lang.annotation.Documented
@javax.validation.Constraint(validatedBy = AccountUsernameNotExistsValidate.class)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Repeatable(AccountUsernameNotExists.List.class)
public @interface AccountUsernameNotExists {
    String message() default "AccountUsername đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends javax.validation.Payload>[] payload() default {};
    @java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @java.lang.annotation.Documented
    static @interface List {
        AccountUsernameNotExists[] value();
    }
}