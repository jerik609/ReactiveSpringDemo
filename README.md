Reactive Web Application

This is in contrast to the standard "servlet" web application - those using the "DispatcherServlet", which directs the calls to the controller.

Reactive does not use tomcat, but the netty server, which is a reactive server implementation, this one will be run in background (where tomcat was run previously).

Netty is considered standard for reactive web applications.

