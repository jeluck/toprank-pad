
package cc.toprank.byd.common.sqlbase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type description
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableRouter {
    public String table();
    public String decollator();
    public String paramKey();
    public boolean isAuto() default false;
    public int count()      default 3;
}



