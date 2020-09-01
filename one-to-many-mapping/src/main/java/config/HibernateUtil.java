package config;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateUtil {

	public Session openSession();
}