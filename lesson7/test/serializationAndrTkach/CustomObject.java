package lesson7.test.serializationAndrTkach;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by arpi on 11.05.2016.
 */

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomObject implements Externalizable {
    transient boolean b;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(b);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
    }
}
