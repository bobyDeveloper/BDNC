package BDNCPractica01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductoDAO implements IDAOGeneral<ProductoPojo, Long>{

    @Override
    public ProductoPojo buscarById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        ProductoPojo producto = session.get(ProductoPojo.class, id);
        transaction.commit();
        return producto;
    }

    @Override
    public List<ProductoPojo> buscarAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<ProductoPojo> productos = session.createQuery("FROM producto", ProductoPojo.class).list();
        transaction.commit();
        return productos;
    }

    @Override
    public boolean guardar(ProductoPojo producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(producto);
        transaction.commit();
        return true;
    }

    @Override
    public boolean modificar(ProductoPojo producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
       ProductoPojo existingProducto = session.get(ProductoPojo.class, producto.getId());
        if (existingProducto != null) {
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecioVenta(producto.getPrecioVenta());
            existingProducto.setPrecioCompra(producto.getPrecioCompra());
            session.update(existingProducto);
            transaction.commit();
            return true;
        } else {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean eliminar(ProductoPojo producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(producto);
        transaction.commit();
        return true;
    }
    
    public List<ProductoPojo> cargarTodosLosProductos() {
        try {
            return buscarAll();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }
}
