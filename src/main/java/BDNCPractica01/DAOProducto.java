package BDNCPractica01;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOProducto implements IDAOGeneral<Producto> {

    @Override
    public boolean guardar(Producto p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();

        Transaction tran = session.beginTransaction();
        session.save(p);

        tran.commit();
        System.out.println("Se guardo con el id:" + p.getId());
        return true;

    }

    @Override
    public boolean actualizar(Producto p) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            System.out.println("Actualizado");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Producto p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        session.delete(p);

        tran.commit();
        System.out.println("Eliminado");
        return true;
    }

    @Override
    public Producto findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Producto producto = session.get(Producto.class, id);
            session.getTransaction().commit();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        List<Producto> productos = session.createQuery("FROM Producto", Producto.class).list();
        tran.commit();
        return productos;
    }

}
