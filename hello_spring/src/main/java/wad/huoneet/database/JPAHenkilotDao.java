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
import wad.huoneet.domain.Henkilo;


@Repository
public class JPAHenkilotDao implements HenkilotDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Henkilo instance) {
        entityManager.merge(instance);
    }

    @Override
    public Henkilo read(int id) {
        return entityManager.find(Henkilo.class, id);
    }

    @Override
    public void delete(Henkilo instance) {
        entityManager.remove(instance);
    }

    @Override
    public Henkilo update(Henkilo instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<Henkilo> list() {
        Query q = entityManager.createQuery("SELECT e FROM Henkilo e");
        return q.getResultList();
    }
}
