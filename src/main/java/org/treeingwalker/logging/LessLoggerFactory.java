package org.treeingwalker.logging;

/**
 * <p>LessLoggerFactory class.</p>
 *
 * @author tdurbin
 * @version $Id: $
 */
public class LessLoggerFactory {
    private static final LessLoggerFactory instance = new LessLoggerFactory();
    private LessLoggerProvider loggerProvider;

    private LessLoggerFactory() {
        try {
            Class.forName("org.slf4j.Logger");
            loggerProvider = new SLF4JLessLoggerProvider();
        } catch(ClassNotFoundException ex) {
            loggerProvider = new JULILessLoggerProvider();
        }
    }

    /**
     * <p>getLogger.</p>
     *
     * @param clazz a {@link java.lang.Class} object.
     * @return a {@link org.treeingwalker.logging.LessLogger} object.
     */
    public static LessLogger getLogger(Class<?> clazz) {
        return instance.loggerProvider.getLogger(clazz);
    }
}
