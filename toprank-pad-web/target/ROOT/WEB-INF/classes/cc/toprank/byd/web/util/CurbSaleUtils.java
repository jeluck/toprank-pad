package cc.toprank.byd.web.util;

public class CurbSaleUtils {

    public static Float diff(Float f1, Float f2) {
        if (f1 == null) {
            return  (f2 == null)? null: (0.00f - f2.floatValue());
        }
        else {
            if (f2 == null){
                return f1;
            }
            return f1 - f2;
        }
    }

    public static Float sum(Float f1, Float f2) {
        if (f1 == null) {
            return  (f2 == null)? null: f2;
        }
        else {
            if (f2 == null){
                return f1;
            }
            return Float.sum(f1, f2);
        }
    }

    public static Integer sum(Integer var1, Integer var2) {
        if (var1 == null) {
            return var2;
        } else {
            if (var2 == null){
                return var1;
            }
            return Integer.sum(var1, var2);
        }
    }

    public static Integer diff(Integer var1, Integer var2) {
        if (var1 == null) {
            return (var2 == null)? null : (0 - var2.intValue());
        } else {
            if (var2 == null){
                return var1;
            }
            return var1.intValue() - var2.intValue();
        }
    }

    public static boolean isEquals(Long var1, Long var2) {
        if (var1 == null) {
            return (var2 == null)? true : var2.equals(var1);
        } else {
            return var1.equals(var2);
        }
    }

}
