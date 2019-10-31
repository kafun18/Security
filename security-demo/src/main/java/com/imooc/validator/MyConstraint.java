/**
 * 
 */
package com.imooc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author zhailiang
 *
 */
//注解可以标注在方法或者字段上面等等
@Target({ElementType.METHOD, ElementType.FIELD})
//运行时的注解
@Retention(RetentionPolicy.RUNTIME)
//注解时运行的类
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
	
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
