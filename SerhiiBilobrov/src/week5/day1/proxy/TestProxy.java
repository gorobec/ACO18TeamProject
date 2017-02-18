package week5.day1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestProxy {


    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxy,args) + "Proxy";
            }
        };

        IMyDb proxy = (IMyDb) Proxy.newProxyInstance(
                TestProxy.class.getClassLoader(),
                new Class[]{IMyDb.class},
                handler);


        System.out.println(proxy.getUserName());

    }


    static interface IMyDb {

        String getUserName();
    }


    static class MyDb implements IMyDb {

        @Override
        public String getUserName(){
            return "UserName";
        }


    }


}
