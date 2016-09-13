package annotations;

/**
 * Created by arpi on 02.06.2016.
 */
@Service(name = "lazy")
public class LazyService {
    @Init
    public void lazyInit() throws Exception {
        System.out.println("Initialising LazyService");
    }
}
