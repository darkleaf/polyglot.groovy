package darkleaf.clj_groovy;

import clojure.java.api.Clojure;

import clojure.lang.*;

public class ClojureDSL {
    public static class Namespace {
        static IFn resolve = Clojure.var("clojure.core", "requiring-resolve");
        static IFn keyword = Clojure.var("clojure.core", "keyword");
        static IFn symbol  = Clojure.var("clojure.core", "symbol");

        String nsName;

        Namespace(String nsName) {
            this.nsName = nsName;
        }

        public Var var(String name) {
            return (Var) resolve.invoke(sym(name));
        }

        public Keyword key(String name) {
            return (Keyword) keyword.invoke(nsName, name);
        }

        public Symbol sym(String name) {
            return (Symbol) symbol.invoke(nsName, name);
        }
    }

    public static Namespace ns(String name) {
        return new Namespace(name);
    }

    public static Object read(String s) {
        return Clojure.read(s);
    }
}
