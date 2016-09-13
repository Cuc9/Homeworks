package annotations;

import java.lang.annotation.*;

/**
 * Created by arpi on 02.06.2016.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init {
    boolean suppressException() default false;
}
