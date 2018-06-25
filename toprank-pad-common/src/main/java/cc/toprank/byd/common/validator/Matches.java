package cc.toprank.byd.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation type description
 *
 */
@Documented
@Constraint(validatedBy = { MatchesValidator.class })
@Target( {
    ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Matches {
    String message()                          default "{constraint.default.matches.message}";
    Class<?>[] groups()                       default {};
    Class<? extends Payload>[] payload()      default {};
    String field()                            default "";
    String verifyField()                      default "";
    Class<? extends MatchesValidator> value() default MatchesValidator.class;
}



