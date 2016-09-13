package lesson7.test.serializationAndrTkach;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by arpi on 11.05.2016.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObj")
public class DataObject extends NonSerializable implements Serializable {
    @XmlElement(required = true, name = "i")
    private int i = 5;
    @XmlElement(required = true, name = "s")
    private String s = "aaa";
    //@XmlElement(required = false, name = "def")
    private String[] def = {"qwe", "asd", "zxc"};
    CustomObject co = new CustomObject();
    Date date = new Date();

    private class InnerOne {
        int innerInt = 111;
        boolean innerBool = false;
        String innerString = "Inner class";
    }

    InnerOne in = new InnerOne();

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getMyData());
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        setMyData((String) in.readObject());
    }
}
