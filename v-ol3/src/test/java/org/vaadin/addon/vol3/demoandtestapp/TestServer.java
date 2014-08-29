package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.server.*;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.File;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Stand-alone test server that powers the map demo. Just run the main method and the demo should be up and running
 * on port 9998
 * Created by mjhosio on 24/06/14.
 */
public class TestServer {
    private static final int PORT = 9998;

    /**
     *
     * Test server for the addon.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = startServer(PORT);
    }

    public static Server startServer(int port) throws Exception {

        Server server = new Server();

        final Connector connector = new SelectChannelConnector();

        connector.setPort(port);
        server.setConnectors(new Connector[] { connector });
        WebAppContext context = new WebAppContext();
        VaadinServlet vaadinServlet = new VaadinServlet() {
            @Override
            public void init(ServletConfig servletConfig)
                    throws ServletException {
                super.init(servletConfig);
                getService().addSessionInitListener(new SessionInitListener() {
                    @Override
                    public void sessionInit(SessionInitEvent event)
                            throws ServiceException {
                        event.getSession().setErrorHandler(new ErrorHandler() {

                            @Override
                            public void error(ErrorEvent event) {
                                Throwable t = event.getThrowable();
                                if (t instanceof SocketException) {
                                    // Most likely client browser closed socket
                                    Logger.getAnonymousLogger()
                                            .info("SocketException in CommunicationManager."
                                                    + " Most likely client (browser) closed socket.");
                                    return;
                                }

                                if (event instanceof ClientConnector.ConnectorErrorEvent) {

                                    if (event.getThrowable() instanceof ServerRpcManager.RpcInvocationException) {
                                        ServerRpcManager.RpcInvocationException ex = (ServerRpcManager.RpcInvocationException) event
                                                .getThrowable();
                                        Throwable theActualCauseThatDevelopersAreReallyInterestedOfAndWhichShouldBeDisplaydInUIAndInLogForDeveloperUX = ex
                                                .getCause().getCause()
                                                .getCause();

                                        t = theActualCauseThatDevelopersAreReallyInterestedOfAndWhichShouldBeDisplaydInUIAndInLogForDeveloperUX;
                                    }

                                    ClientConnector.ConnectorErrorEvent e = (ClientConnector.ConnectorErrorEvent) event;
                                    com.vaadin.shared.Connector connector = e
                                            .getConnector();
                                    Component c;
                                    if (connector instanceof Component) {
                                        c = (Component) connector;
                                    } else {
                                        c = ((Component) connector).getParent();
                                    }

                                    if (c instanceof AbstractComponent) {
                                        AbstractComponent component = (AbstractComponent) c;
                                        if (component != null) {
                                            // Shows the error in
                                            // AbstractComponent
                                            ErrorMessage errorMessage = AbstractErrorMessage
                                                    .getErrorMessageForException(t);
                                            component
                                                    .setComponentError(errorMessage);
                                        }
                                    }
                                }

                                // also print the error on console
                                Logger.getAnonymousLogger().log(Level.SEVERE, "", t);
                            }
                        });
                    }
                });
            }

        };

        ServletHolder servletHolder = new ServletHolder(vaadinServlet);
        servletHolder.setInitParameter("widgetset",
                "org.vaadin.addon.vol3.demoandtestapp.TestWidgetSet");
        servletHolder.setInitParameter("ui",
                "org.vaadin.addon.vol3.demoandtestapp.MapTestUI");
        File file = new File("target/testwebapp");
        if(!file.exists()){
            // we may be running this from the root module, lets try that instead
            file = new File("v-ol3/target/testwebapp");
        }
        context.setWar(file.getPath());
        context.setContextPath("/");

        context.addServlet(servletHolder, "/*");
        server.setHandler(context);
        server.start();
        return server;
    }
}
