
package moulinette ;

import com.rac021.jax.api.manager.IResource ;
import com.rac021.jax.api.qualifiers.SqlQuery ;
import com.rac021.jax.api.qualifiers.ResourceRegistry ;

/**
 *
 * @author R.Yahiaoui
 */

@ResourceRegistry("resourcePivot")

public class Resource implements IResource {

    @SqlQuery("show_person")
    private final  String PLANES = " SELECT                                 " +
                                   " jeu_id, code_jeu , description , titre " +
                                   " FROM jeu "                          ;
}
