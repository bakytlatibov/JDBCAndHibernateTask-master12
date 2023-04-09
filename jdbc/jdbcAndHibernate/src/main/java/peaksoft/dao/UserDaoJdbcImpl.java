package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        Session session= Util.getSessionFactory().openSession();
        session.beginTransaction().commit();
        session.close();

    }

    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS users";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();


    }

    public void saveUser(String name, String lastName, byte age) {
        Session session=Util.getSessionFactory().openSession();
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
    public void removeUserById(long id) {
        Session session=Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();


    }

    public List<User> getAllUsers() {
        Session session=Util.getSessionFactory().openSession();
        User user=new User();
        List<User>users=new ArrayList<>();
        users.add(user);
        session.beginTransaction();
        session.getTransaction();
        session.close();

        return users;
    }

    public void cleanUsersTable() {
        Session session=Util.getSessionFactory().openSession();
        session.beginTransaction();
        String sql="DELETE TABLE users";
        session.createSQLQuery("truncate table users").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}