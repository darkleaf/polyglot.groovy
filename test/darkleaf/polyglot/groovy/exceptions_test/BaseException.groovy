package darkleaf.polyglot.groovy.exceptions_test

import groovy.transform.InheritConstructors

@InheritConstructors
class BaseException extends ExceptionInfo {}

@InheritConstructors
class ConcreteException extends BaseException {}
