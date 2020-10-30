package com.sumit.shingari.custom.generator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

//  private String prefix;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

		String query = String.format("select %s from %s",
				session.getEntityPersister(obj.getClass().getName(), obj).getIdentifierPropertyName(),
				obj.getClass().getSimpleName());

		Stream<Long> ids = session.createQuery(query).stream();

		Long max = ids.mapToLong(o -> o).max().orElse(0L);

		return (max + 10);
	}
}
