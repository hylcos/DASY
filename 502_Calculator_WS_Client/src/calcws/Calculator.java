
package calcws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://calcws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://calcws/", className = "calcws.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://calcws/", className = "calcws.AddResponse")
    @Action(input = "http://calcws/Calculator/addRequest", output = "http://calcws/Calculator/addResponse")
    public int add(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
