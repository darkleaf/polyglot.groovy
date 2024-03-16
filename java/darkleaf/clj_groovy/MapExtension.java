package darkleaf.clj_groovy;

import java.util.Map;
import clojure.lang.IFn;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;

import static clojure.java.api.Clojure.read;

@SuppressWarnings("unchecked")
public class MapExtension {
    static final Object onInterface = read(":on-interface");

    /*
     * Протокол - это одноименный Var.
     * Он содержит мапу с ключем :on-interface.
     * А там лежит объект интерфейса с типом Class.
     * FYI: Var и clj Map это IFn.
     */
    public static <T> T asType(Map spec, IFn protocol) {
        Class klass = (Class) protocol.invoke(onInterface);
        return (T) DefaultGroovyMethods.asType(spec, klass);
    }
}
