import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
   
    public static void main(String[] args) {
        MyAnnotation ma = new MyAnnotation();

        Method[] methods = MyAnnotation.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test testAnnotation = method.getAnnotation(Test.class);

                int a = testAnnotation.a();
                int b = testAnnotation.b();

                try {
                    int res = (int) method.invoke(ma, a, b);
                    System.out.println(res);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        TextContainer tc = new TextContainer("Booooooo!");
        Class<?> c = FileName.class;
        SaveTo st = c.getAnnotation(SaveTo.class);
        String fileName = st.fileName();
        tc.saveTextToFile(fileName);
    }
}