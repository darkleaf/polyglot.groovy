# polyglot.groovy

Spice you code with Groovy!

Integrates Groovy into Clojure tooling.
Works like regular `deftype`.

- Write fast imperative code for special cases
- Reload your groovy code dynamically with REPL
- Dynamically define an Exception classes hierarcy
- Dynamically implement abstract classes faster then `proxy`
- Compile groovy code with the regualr `compile`

## Installation

```sh
clj -T:build prep-lib
```

## Why Groovy?

First. Groovy was designed as embeddable language. So its compiler has good enough compiler API to integrate it with Clojure.

Second. Groovy compiler can link with dynamically loaderd classes. So you can implement an interface of a Clojure protocol in Groovy.
It is possible to dynamically compile and load Java or Kotlin code but it will be linked only with AOT compiled classes.

Third. It is much easier to write Groovy code without an IDE than Java code.

## Groovy flavors

Actually there are to flavors of [the Groovy language](https://groovy-lang.org/).
One is a regular dynamic Groovy. It call methods indirectly and employs both runtime and compile-time
[metaprogramming](https://docs.groovy-lang.org/latest/html/documentation/core-metaprogramming.html#_compile_time_metaprogramming)
Second is a staticaly compiled and type checked Groovy. It uses only compile-time metaprogramming.

In case of Clojure we usually don't need of slow indirect method invocation,
so instead of regular Groovy this library compiles `.groovy` files statically.

If you have to use dynamic features like `methodMissing` or can't specify types you should use `.dgroovy` file extension
or annotate a class or a method with `@CompileDynamic`.

`.groovy`, `.gvy`, `.gy`, `.sgroovy`,  `.sg` and `.java` are compiled with `@CompileStatic`.

`.dgroovy` and `.dg` are compiled dynamically as a regular Groovy does.

Also you can use `@CompileDynamic` and `@CompileStatic` annotations to tune single class or method.

See [config](resources/darkleaf/polyglot/groovy/config.groovy).

## Java compatibility

In most cases Static Groovy is a superset of Java, so you can even use `.java` file extension!
With dynamically class (re)loading!

It is usefull when you need to load generated Java files.

## Use cases

### Imperative algorithms

Use `g/defobject` just like `def` or `defn`.

```clojure
;; src/my/project/core.clj
(ns my.project.core
  (:require
   [darkleaf.polyglot.groovy.core :as g]))

(g/defobject imperative-algorithm)

(comment
  (imperative-algorithm 42))
```

```groovy
// src/my/project/core/imperative_algorithm.groovy
package my.project.core

class imperative_algorithm extends AFunction {
  def invoke(x) {
    // ...
  }
}
```

## Java interop

gen-class
proxy
exceptions


## API

## Compilation

When a clojure ns compiles it also compile all defined groovy classes just like `deftype`.
It integrates with `*compile-files*`. No configuration is required.

```clojure
(compile 'my.project.core)
```

## Other


```
var('clojure.core', 'prn')(42)
```

println and flushing

## Inspiration

+ [rpl/proxy-plus](https://github.com/redplanetlabs/proxy-plus/tree/master)
+ [rpl/defexception](https://github.com/redplanetlabs/defexception/tree/master)
