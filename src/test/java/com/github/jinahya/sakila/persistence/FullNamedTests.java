package com.github.jinahya.sakila.persistence;

/*-
 * #%L
 * sakila-entities
 * %%
 * Copyright (C) 2019 Jinahya, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static com.github.jinahya.sakila.persistence.PersistenceProducer.applyEntityManager;

final class FullNamedTests {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a randomly selected {@link FullNamedEntity#COLUMN_NAME_FIRST_NAME first_name} column from the table of
     * specified name.
     *
     * @param entityManager an entity manager to use with {@link EntityManager#createNamedQuery(String)}.
     * @param tableName     the name of the table.
     * @return a randomly selected {@link FullNamedEntity#COLUMN_NAME_FIRST_NAME first_name} column.
     * @see #randomFirstName(String)
     */
    static String randomFirstName(final EntityManager entityManager, final String tableName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT " + FullNamedEntity.COLUMN_NAME_FIRST_NAME + " FROM " + tableName + " ORDER BY RAND() LIMIT 1");
        return (String) query.getSingleResult();
    }

    /**
     * Returns a randomly selected {@link FullNamedEntity#COLUMN_NAME_FIRST_NAME first_name} column from the table of
     * specified name.
     *
     * @param tableName the name of the table.
     * @return a randomly selected {@link FullNamedEntity#COLUMN_NAME_FIRST_NAME first_name} column.
     * @see #randomFirstName(EntityManager, String)
     */
    static String randomFirstName(final String tableName) {
        return applyEntityManager(v -> randomFirstName(v, tableName));
    }

    static long countByFirstName(final EntityManager entityManager, final String tableName, final String firstName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT COUNT(1) FROM " + tableName +
                " WHERE " + FullNamedEntity.COLUMN_NAME_FIRST_NAME + " = ?1");
        query.setParameter(1, firstName);
        return (long) query.getSingleResult();
    }

    static long countByFirstName(final String tableName, final String firstName) {
        return applyEntityManager(v -> countByFirstName(v, tableName, firstName));
    }

    // -----------------------------------------------------------------------------------------------------------------
    static String randomLastName(final EntityManager entityManager, final String tableName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT " + FullNamedEntity.COLUMN_NAME_LAST_NAME + " FROM " + tableName + " ORDER BY RAND() LIMIT 1");
        return (String) query.getSingleResult();
    }

    static String randomLastName(final String tableName) {
        return applyEntityManager(v -> randomLastName(v, tableName));
    }

    static long countByLastName(final EntityManager entityManager, final String tableName, final String lastName) {
        final Query query = entityManager.createNativeQuery(
                "SELECT COUNT(1) FROM " + tableName +
                " WHERE " + FullNamedEntity.COLUMN_NAME_LAST_NAME + " = ?1");
        query.setParameter(1, lastName);
        return (long) query.getSingleResult();
    }

    static long countByLastName(final String tableName, final String lastName) {
        return applyEntityManager(v -> countByLastName(v, tableName, lastName));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    private FullNamedTests() {
        super();
    }
}
