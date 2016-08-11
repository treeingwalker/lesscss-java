package org.treeingwalker;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>HttpResource class.</p>
 *
 * @author tdurbin
 * @version $Id: $
 */
public class HttpResource implements Resource {

    private URI url;

    /**
     * <p>Constructor for HttpResource.</p>
     *
     * @param url a {@link java.lang.String} object.
     * @throws java.net.URISyntaxException if any.
     */
    public HttpResource(String url) throws URISyntaxException {
        this.url = new URI( url );
    }

    private HttpResource(URI url) {
        this.url = url;
    }

    /**
     * <p>exists.</p>
     *
     * @return a boolean.
     */
    public boolean exists() {
        try {
            URL u = url.toURL();
            URLConnection connection = u.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * <p>lastModified.</p>
     *
     * @return a long.
     */
    public long lastModified() {
        try {
            URL u = url.toURL();
            URLConnection connection = u.openConnection();
            return connection.getLastModified();
        } catch( IOException e ) {
            return 0;
        }
    }

    /**
     * <p>getInputStream.</p>
     *
     * @return a {@link java.io.InputStream} object.
     * @throws java.io.IOException if any.
     */
    public InputStream getInputStream() throws IOException {
        return url.toURL().openStream();
    }

    /** {@inheritDoc} */
    public Resource createRelative(String relativeResourcePath) throws IOException {
        try {
            return new HttpResource(url.resolve(new URI(relativeResourcePath)));
        } catch (URISyntaxException e) {
            throw (IOException)new IOException( "Could not resolve " + url + " against " + relativeResourcePath ).initCause(e);
        }
    }

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return url.toASCIIString();
    }
}
