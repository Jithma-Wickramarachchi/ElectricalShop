package edu.icet.dao;

import edu.icet.dao.util.HibernateUtil;
import edu.icet.entity.ItemsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemsDaoImpl implements ItemsDao{


    @Override
    public boolean save(ItemsEntity entity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
