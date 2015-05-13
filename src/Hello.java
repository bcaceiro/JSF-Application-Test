

import javax.faces.bean.ManagedBean;

/**
 * Created by jpedrom on 13/05/15.
 */

@ManagedBean
public class Hello {

    final String world = "Hello World!";

    public String getworld() {
        return world;
    }
}