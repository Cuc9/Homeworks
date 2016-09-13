package lesson7.test.serializationAndrTkach;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Modifier;

/**
 * Created by arpi on 11.05.2016.
 */
public class Operations {

    static final String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) throws Exception {
        DataObject obj = new DataObject();
        obj.setMyData("qweqwefasrg aesrg aerg awef awef ");
        File file = new File("store.bin");
        File fileXML = new File("d:\\test\\store.xml");
//write
        /*FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);
        so.writeObject(obj);
        so.flush();
        so.close();*/
//read
      /*  FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);

        DataObject objNew = (DataObject) si.readObject();
        si.close();
        System.out.println(objNew.getMyData());*/
//JAXB
/*        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
        Marshaller m = jc.createMarshaller();
        Unmarshaller um = jc.createUnmarshaller();

        m.marshal(obj,fileXML);
        obj = (DataObject) um.unmarshal(fileXML);
        System.out.println(obj.getMyData());*/
//Json
     /*   Gson gson = new Gson();
        String json = gson.toJson(obj);
        System.out.println(json);
        DataObject objNew = gson.fromJson(json, DataObject.class);
        System.out.println(objNew.getMyData());

        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().excludeFieldsWithModifiers(Modifier.PUBLIC)
                .disableInnerClassSerialization().setDateFormat("dd.MMMM.yyyy : H.mm").create();
        json = gsonPretty.toJson(obj);
        System.out.println(json);*/

    }
}
