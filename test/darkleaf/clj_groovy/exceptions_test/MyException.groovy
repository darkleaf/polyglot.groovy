package darkleaf.clj_groovy.exceptions_test

import clojure.lang.ExceptionInfo
import groovy.transform.InheritConstructors

@InheritConstructors
class MyException extends ExceptionInfo {}
