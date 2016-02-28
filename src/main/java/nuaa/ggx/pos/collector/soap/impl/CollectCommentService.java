package nuaa.ggx.pos.collector.soap.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import nuaa.ggx.pos.collector.soap.ICollectComment;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-02-28T22:44:59.744+08:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "CollectCommentService", 
                  wsdlLocation = "file:/Users/riversye/Documents/myprojects/nuaacempos/src/main/resources/wsdl/collectComment.wsdl",
                  targetNamespace = "http://impl.soap.collector.pos.ggx.nuaa/") 
public class CollectCommentService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.soap.collector.pos.ggx.nuaa/", "CollectCommentService");
    public final static QName CollectCommentPort = new QName("http://impl.soap.collector.pos.ggx.nuaa/", "CollectCommentPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/riversye/Documents/myprojects/nuaacempos/src/main/resources/wsdl/collectComment.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CollectCommentService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/riversye/Documents/myprojects/nuaacempos/src/main/resources/wsdl/collectComment.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CollectCommentService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CollectCommentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CollectCommentService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CollectCommentService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CollectCommentService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CollectCommentService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ICollectComment
     */
    @WebEndpoint(name = "CollectCommentPort")
    public ICollectComment getCollectCommentPort() {
        return super.getPort(CollectCommentPort, ICollectComment.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ICollectComment
     */
    @WebEndpoint(name = "CollectCommentPort")
    public ICollectComment getCollectCommentPort(WebServiceFeature... features) {
        return super.getPort(CollectCommentPort, ICollectComment.class, features);
    }

}
