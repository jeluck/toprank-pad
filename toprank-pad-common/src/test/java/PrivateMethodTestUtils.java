import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class PrivateMethodTestUtils {

    /**
     * Method description
     *
     *
     * @param methodHostInstance
     * @param methodName
     * @param arg
     *
     * @return
     */
    public static Object invoke(Object methodHostInstance, String methodName, Object arg) {
        Class<?>[] parameterTypes = { arg.getClass() };
        Object[]   args           = { arg };

        return invoke(methodHostInstance, methodName, parameterTypes, args);
    }

    /**
     * Method description
     *
     *
     * @param methodHostInstance
     * @param methodName
     * @param parameterTypes
     * @param args
     *
     * @return
     */
    public static Object invoke(Object methodHostInstance, String methodName, Class<?>[] parameterTypes,
                                Object[] args) {
        try {
            Method method = methodHostInstance.getClass().getDeclaredMethod(methodName, parameterTypes);

            method.setAccessible(true);

            try {
                return method.invoke(methodHostInstance, args);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            method.setAccessible(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}



