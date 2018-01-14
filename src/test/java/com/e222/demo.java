package com.e222;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.e222.entities.Article;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //-------------------------HQL操作----------------------------

        //1.书写HQL语句
        /*
        查询：from 查询对象的完整类名(没有重复直接类名)
        条件： from 类名 where 对象属性 = ?
        */
        String hql = " from Article where num = ?";
        //2.根据HQL语句获取查询对象
        Query query = session.createQuery(hql);
        //设置参数
        query.setParameter(0,1);
        //3.根据查询对象获取查询结果
        List<Article> list = query.list();//获取多个对象

        System.out.println("list = " + list.toString());
//query.uniqueResult();//获取唯一对象
        //------------------------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
