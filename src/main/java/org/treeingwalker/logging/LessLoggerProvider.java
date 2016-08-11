package org.treeingwalker.logging;

interface LessLoggerProvider {
    /**
     * <p>getLogger.</p>
     *
     * @param clazz a {@link java.lang.Class} object.
     * @return a {@link org.treeingwalker.logging.LessLogger} object.
     */
    LessLogger getLogger(Class<?> clazz);
}
