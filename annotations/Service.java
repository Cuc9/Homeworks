package annotations;

import java.lang.annotation.*;

/**
 * Created by arpi on 02.06.2016.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}
