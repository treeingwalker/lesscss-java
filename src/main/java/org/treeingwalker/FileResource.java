package org.treeingwalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * File based implementation of {@link Resource}.
 *
 * @author Anton Pechinsky
 * @version $Id: $
 */
public class FileResource implements Resource {

    private File file;

    /**
     * <p>Constructor for FileResource.</p>
     *
     * @param file a {@link java.io.File} object.
     */
    public FileResource(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File must not be null!");
        }
        this.file = file;
    }

    /**
     * <p>exists.</p>
     *
     * @return a boolean.
     */
    public boolean exists() {
        return file.exists();
    }

    /**
     * <p>getInputStream.</p>
     *
     * @return a {@link java.io.InputStream} object.
     * @throws java.io.IOException if any.
     */
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    /**
     * <p>lastModified.</p>
     *
     * @return a long.
     */
    public long lastModified() {
        return file.lastModified();
    }

    /** {@inheritDoc} */
    public Resource createRelative(String relativePath) {
        File relativeFile = new File(file.getParentFile(), relativePath);
        return new FileResource(relativeFile);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return file.getAbsolutePath();
    }

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return file.getAbsolutePath();
    }
}
