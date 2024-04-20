# polyglot.groovy

Integrates Groovy into Clojure's DynamicClassLoader.
Works like regular `deftype`.

- Write fast imperative code for special cases
- Reload your groovy code dynamically with REPL
- Dynamically define an Exception classes hierarcy
- Dynamically implement abstract classes faster then `proxy`

## Inspiration

+ [rpl/proxy-plus](https://github.com/redplanetlabs/proxy-plus/tree/master)
+ [rpl/defexception](https://github.com/redplanetlabs/defexception/tree/master)

## Installation

```sh
clj -T:build prep-lib
```

## Groovy

Actually there are to flavors of [the Groovy language](https://groovy-lang.org/).
One is a regular dynamically compiled Groovy. It call methods indirectly and employs both [runtime metaprogramming](https://docs.groovy-lang.org/latest/html/documentation/core-metaprogramming.html#_runtime_metaprogramming) and [compile-time one](https://docs.groovy-lang.org/latest/html/documentation/core-metaprogramming.html#_compile_time_metaprogramming).
Second is a staticaly compiled and type checked Groovy. It uses only compile-time metaprogramming.

In case of Clojure we don't need of slow indirect method invocation,
so instead of regular Groovy this library compiles `.groovy` files statically.

If you have to use dynamic features like `methodMissing` you should use `.dgroovy` file extension
or annotate a class or a method with `@CompileDynamic`.

`.groovy`, `.gvy`, `.gy`, `.sgroovy`,  `.sg` and `.java` are compiled with `@CompileStatic`.

`.dgroovy` and `.dg` are compiled dynamically as a regular Groovy does.

Also you can use `@CompileDynamic` and `@CompileStatic` annotations to tune single class or method.

## Java

In most cases Static Groovy can compile a Java code, so you can even use `.java` file extension!
With dynamically class (re)loading!

# Use cases

## Imperative algorithms

## Java interop

gen-class
proxy
exceptions


## API


# xyz

compile java with groovy compiler. config.groovy


```
var('clojure.core', 'prn')(42)
```
