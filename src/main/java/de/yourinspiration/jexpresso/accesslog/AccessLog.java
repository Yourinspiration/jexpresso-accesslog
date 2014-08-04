package de.yourinspiration.jexpresso.accesslog;

import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

import de.yourinspiration.jexpresso.MiddlewareHandler;
import de.yourinspiration.jexpresso.Next;
import de.yourinspiration.jexpresso.Request;
import de.yourinspiration.jexpresso.Response;

/**
 * A middleware for JExpresso to print the access log.
 * 
 * @author Marcel Härle
 *
 */
public class AccessLog implements MiddlewareHandler {

    private final AccessLogFormat format;
    private final WritableByteChannel channel;

    /**
     * Constructs a new access log middelware using the provided log format and
     * output stream.
     * 
     * @param format
     *            the access log format
     * @param out
     *            the output stream
     */
    public AccessLog(final AccessLogFormat format, final OutputStream out) {
        this.format = format;
        this.channel = Channels.newChannel(out);
    }

    @Override
    public void handle(final Request request, final Response response, final Next next) {
        response.addListener(new AccessLogResponseListener(format, channel));
        next.next();
    }

}
