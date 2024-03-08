package darkleaf.clj_groovy.benchmark.collection

import clojure.lang.Var

// .getRawRoot() - это полу-приватное api, но так сама clojure компилирует.
// .with(deref) если берем функцию из clojure.core, то можно сразу сделать deref,
// и убрать один уровень косвенности

// но это наносекунды и я просто показываю, что можно дожать скорость до clojure
// проще использовать `new AFunction() {...}`


// gr_2$fn - чтобы с другими классами потенциально не запуталось, пакет у них общий


@CompileStatic
class gr_2$fn extends AFunction {
  static Var map = (Var) var('clojure.core', 'map')//.with(deref)
  static Var inc = (Var) var('clojure.core', 'inc')//.with(deref)
  static Var str = (Var) var('clojure.core', 'str')//.with(deref)

  def invoke(data) {
    IFn _map   = (IFn) map.getRawRoot()
    IFn _inc   = (IFn) inc.getRawRoot()
    IFn _str   = (IFn) str.getRawRoot()

    def x = data
    x = _map.invoke _inc, x
    x = _map.invoke _str, x
    x
  }
}

new gr_2$fn()

/* decompiled
public final class collection$clj extends AFunction {
    public static final Var const__0 = (Var)RT.var("clojure.core", "map");
    public static final Var const__1 = (Var)RT.var("clojure.core", "str");
    public static final Var const__2 = (Var)RT.var("clojure.core", "inc");

    public collection$clj() {
    }

    public static Object invokeStatic(Object data) {
        IFn var10000 = (IFn)const__0.getRawRoot();
        Object var10001 = const__1.getRawRoot();
        IFn var10002 = (IFn)const__0.getRawRoot();
        Object var10003 = const__2.getRawRoot();
        Object var10004 = data;
        data = null;
        return var10000.invoke(var10001, var10002.invoke(var10003, var10004));
    }

    public Object invoke(Object var1) {
        Object var10000 = var1;
        var1 = null;
        return invokeStatic(var10000);
    }
}
*/
