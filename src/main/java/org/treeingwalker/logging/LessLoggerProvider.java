package org.treeingwalker.logging;

interface LessLoggerProvider {
    LessLogger getLogger(Class<?> clazz);
}
