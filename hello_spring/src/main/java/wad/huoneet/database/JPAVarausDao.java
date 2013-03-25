/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.huoneet.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.huoneet.domain.Varaus;



@Repository
public class JPAVarausDao implements VarausDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Varaus instance) {
        entityManager.merge(instance);
    }

    @Override
    public Varaus read(int id) {
        return entityManager.find(Varaus.class, id);
    }

    @Override
    public void delete(Varaus instance) {
        entityManager.remove(instance);
    }

    @Override
    public Varaus update(Varaus instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<Varaus> list() {
        Query q = entityManager.createQuery("SELECT e FROM Varaus e");
        return q.getResultList();
    }
}
