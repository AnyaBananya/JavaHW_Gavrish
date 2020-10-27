import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Start {
    public static void start(Class c) {
        List<Method> methods = new ArrayList<>();
        Method[] declaredMethods = c.getDeclaredMethods();

        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(Test.class)) {
                methods.add(m);
            }
        }

        methods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                if (o1.getAnnotation(Test.class).priority() == o2.getAnnotation(Test.class).priority()) {
                    return 0;
                }
                if (o1.getAnnotation(Test.class).priority() < o2.getAnnotation(Test.class).priority()) {
                    return 1;
                }
                return -1;
            }
        });

        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("Методов с аннотацией BeforeSuite более чем один ");
                }
                methods.add(0, m);
            }
        }

        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("Методов с аннотацией AfterSuite более чем один");
                }
                methods.add(m);
            }
        }

        for (Method m : methods) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
