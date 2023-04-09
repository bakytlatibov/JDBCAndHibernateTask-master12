package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.stat.SessionStatistics;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session= Util.getSessionFactory().openSession();




    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS users";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session=Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session=Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users=
                session.createQuery("FROM User ").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;

    }

    @Override
    public void cleanUsersTable() {
        Session session=Util.getSessionFactory().openSession();
       session.beginTransaction();


       session.getTransaction().commit();
       session.close();

    }
}
