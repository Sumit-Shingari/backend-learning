package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtilForMySql implements HibernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());

		} catch (Exception ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Session openSession() {
		return sessionFactory.openSession();
	}
}