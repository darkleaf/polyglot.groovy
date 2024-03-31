package darkleaf.polyglot.groovy;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.ClassNodeResolver;
import org.codehaus.groovy.control.ClassNodeResolver.LookupResult;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;

// use only loaded classes
// no script compilation
// no .class files usage
public class DynamicClassNodeResolver extends ClassNodeResolver {
    public LookupResult findClassNode(final String name, final CompilationUnit compilationUnit) {
        return compilationUnit == null ? null : findOnlyByClassLoading(name, compilationUnit);
    }

    private LookupResult findOnlyByClassLoading(final String name, final CompilationUnit compilationUnit) {
        GroovyClassLoader loader = compilationUnit.getClassLoader();
        Class<?> cls;
        try {
            // like parent loader
            cls = loader.loadClass(name, false, true);
        } catch (ClassNotFoundException cnfe) {
            return null;
        } catch (CompilationFailedException cfe) {
            throw new GroovyBugError("The lookup for " + name + " caused a failed compilation. There should not have been any compilation from this call.", cfe);
        }
        if (cls == null) return null;
        ClassNode cn = ClassHelper.make(cls);
        return new LookupResult(null, cn);
    }
}
