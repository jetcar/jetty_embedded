import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.spi.resource.Singleton;
import com.thetransactioncompany.cors.CORSFilter;
import jersey.repackaged.com.google.common.collect.Maps;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.mortbay.servlet.GzipFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeFunction.bind;

public class JobQueueServer {

    public static void main(String[] args) {

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        Server server = new Server(8888);

        ServletHolder jerseyServlet = handler.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.sangupta.keepwalking");


        FilterHolder holder = new FilterHolder(GzipFilter.class);
        holder.setInitParameter("deflateCompressionLevel", "9");
        holder.setInitParameter("minGzipSize", "0");
        holder.setInitParameter("mimeTypes", "application/json,text/html,text/xml,text/plain,application/javascript,application/json");

        handler.addFilter(holder, "/*", EnumSet.of(DispatcherType.REQUEST));

        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        handler.addFilter(CORSFilter.class, "/*", EnumSet.allOf(DispatcherType.class));


        server.setHandler(handler);



        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }
    }

}