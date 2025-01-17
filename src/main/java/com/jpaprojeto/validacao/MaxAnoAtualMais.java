package com.jpaprojeto.validacao;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = MaxAnoAtualMaisValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxAnoAtualMais {

    String message() default "O valor m�ximo para esse campo � {0}";

    int value() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
