package annotations;

/**
 * Created by arpi on 02.06.2016.
 */
@Service(name = "simple")
public class SimpleService {
    @Init
    public void initService() {
        System.out.println("Initialising SimpleService");
    }

    public void notInit(){
        System.out.println("xaxaxaxax");
    }
}
