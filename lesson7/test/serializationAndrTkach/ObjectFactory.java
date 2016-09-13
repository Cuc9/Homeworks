package lesson7.test.serializationAndrTkach;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.crypto.Data;
import javax.xml.namespace.QName;

/**
 * Created by arpi on 26.05.2016.
 */
@XmlRegistry
public class ObjectFactory {
    private final static QName QNAME = new QName(XMLConstants.NULL_NS_URI, "data");

    @XmlElementDecl(name = "dataObj")
    public JAXBElement<DataObject> createData (DataObject value){
        return new JAXBElement<DataObject>(QNAME,DataObject.class,null,value);
    }
}
