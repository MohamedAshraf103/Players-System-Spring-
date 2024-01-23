package com.player.DAL.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.player.DAL.model.Player;

public class HibernateDBManager {

	private static SessionFactory dbSessionFactory = null;
	private static String dbConfigFileName = null;

	public static void buildSessionFactory() throws Exception {

		try {

			if (dbSessionFactory != null) {
				return;
			}

			if (dbConfigFileName == null) {
				throw new Exception("you must call set name first");
			}

			dbSessionFactory = new Configuration().configure(dbConfigFileName).addAnnotatedClass(Player.class)
					.buildSessionFactory();

		} catch (Exception e) {
			dbConfigFileName = null;
			dbSessionFactory = null;
			throw e;
		}
	}

	public static void setDbConfigFileName(String dbConfigFileName) {
		HibernateDBManager.dbConfigFileName = dbConfigFileName;
	}

	public static SessionFactory getDbSessionFactory() {
		return dbSessionFactory;
	}

	public static Session getSession() {
		// Create nes session if note exists or use same session
		return dbSessionFactory.getCurrentSession();
	}

	public static void beginTransaction() {
		getSession().beginTransaction();
	}

	public static void commitTransaction() {
		getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		if (getSession().getTransaction().isActive()) {
			getSession().getTransaction().rollback();
		}
	}

	public static void closeSession() {
		getSession().close();
	}
}
