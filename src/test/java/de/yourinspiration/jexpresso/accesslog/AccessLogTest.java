package de.yourinspiration.jexpresso.accesslog;

import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import de.yourinspiration.jexpresso.Next;
import de.yourinspiration.jexpresso.Request;
import de.yourinspiration.jexpresso.Response;

/**
 * Test case for {@link AccessLog}.
 * 
 * @author Marcel Härle
 *
 */
public class AccessLogTest {

    private AccessLog accessLog;

    private final AccessLogFormat format = AccessLogFormat.DEVELOPER;

    @Mock
    private OutputStream out;
    @Mock
    private Request request;
    @Mock
    private Response response;
    @Mock
    private Next next;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accessLog = new AccessLog(format, out);
    }

    @Test
    public void testHandle() {
        accessLog.handle(request, response, next);
        Mockito.verify(response).addListener(Matchers.any(AccessLogResponseListener.class));
        Mockito.verify(next).next();
    }

}
