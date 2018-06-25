package cc.toprank.byd.common.validator;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class MatchesValidator implements ConstraintValidator<Matches, Object> {

    /** Field description */
    private String field;

    /** Field description */
    private String verifyField;

    @Override
    public void initialize(Matches matches) {
        this.field       = matches.field();
        this.verifyField = matches.verifyField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            String  fieldValue       = BeanUtils.getProperty(value, field);
            String  verifyFieldValue = BeanUtils.getProperty(value, verifyField);
            boolean valid            = (fieldValue == null) && (verifyFieldValue == null);

            if (valid) {
                return true;
            }

            boolean match = (fieldValue != null) && (fieldValue.compareTo(verifyFieldValue) > 0);

            if (!match) {
                String messageTemplate = context.getDefaultConstraintMessageTemplate();

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(messageTemplate)
                       .addNode(verifyField)
                       .addConstraintViolation();
            }

            return match;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return true;
    }
}



