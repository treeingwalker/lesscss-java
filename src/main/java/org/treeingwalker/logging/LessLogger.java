package org.treeingwalker.logging;

/**
 * <p>LessLogger interface.</p>
 *
 * @author tdurbin
 * @version $Id: $
 */
public interface LessLogger {
    /**
     * <p>isDebugEnabled.</p>
     *
     * @return a boolean.
     */
    boolean isDebugEnabled();

    /**
     * <p>isInfoEnabled.</p>
     *
     * @return a boolean.
     */
    boolean isInfoEnabled();

    /**
     * <p>debug.</p>
     *
     * @param msg a {@link java.lang.String} object.
     */
    void debug(String msg);

    /**
     * <p>debug.</p>
     *
     * @param format a {@link java.lang.String} object.
     * @param args a {@link java.lang.Object} object.
     */
    void debug(String format, Object... args);

    /**
     * <p>info.</p>
     *
     * @param msg a {@link java.lang.String} object.
     */
    void info(String msg);

    /**
     * <p>info.</p>
     *
     * @param format a {@link java.lang.String} object.
     * @param args a {@link java.lang.Object} object.
     */
    void info(String format, Object... args);

    /**
     * <p>error.</p>
     *
     * @param msg a {@link java.lang.String} object.
     * @param t a {@link java.lang.Throwable} object.
     */
    void error(String msg, Throwable t);

    /**
     * <p>error.</p>
     *
     * @param format a {@link java.lang.String} object.
     * @param args a {@link java.lang.Object} object.
     */
    void error(String format, Object... args);

}
