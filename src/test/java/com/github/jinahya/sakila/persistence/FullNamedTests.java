package com.github.jinahya.sakila.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static com.github.jinahya.sakila.persistence.PersistenceProducer.applyEntityManager;

final class FullNamedTests {

    // -----------------------------------------------------------------------------------------------------------------
    static String randomFirstName(final EntityManager entityManager, final String tableName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT " + FullNamedEntity.COLUMN_NAME_FIRST_NAME + " FROM " + tableName + " ORDER BY RAND() LIMTI 1",
                String.class);
        return (String) query.getSingleResult();
    }

    static String randomFirstName(final String tableName) {
        return applyEntityManager(v -> randomFirstName(v, tableName));
    }

    static long countByFirstName(final EntityManager entityManager, final String tableName, final String firstName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT COUNT(1) FROM " + tableName +
                " WHERE " + FullNamedEntity.COLUMN_NAME_FIRST_NAME + " = : firstName",
                String.class);
        query.setParameter("firstName", firstName);
        return (long) query.getSingleResult();
    }

    static long countByFirstName(final String tableName, final String firstName) {
        return applyEntityManager(v -> countByFirstName(v, tableName, firstName));
    }

    // -----------------------------------------------------------------------------------------------------------------
    static String randomLastName(final EntityManager entityManager, final String tableName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT " + FullNamedEntity.COLUMN_NAME_LAST_NAME + " FROM " + tableName + " ORDER BY RAND() LIMTI 1",
                String.class);
        return (String) query.getSingleResult();
    }

    static String randomLastName(final String tableName) {
        return applyEntityManager(v -> randomLastName(v, tableName));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private FullNamedTests() {
        super();
    }
}