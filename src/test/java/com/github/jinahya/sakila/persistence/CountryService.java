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

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * A service for {@link Country}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
class CountryService extends BaseEntityService<Country> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    CountryService() {
        super(Country.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a list of countries whose {@link Country#ATTRIBUTE_NAME_COUNTRY country} attribute matches to specified
     * value sorted by {@link BaseEntity#ATTRIBUTE_NAME_ID id} attribute in ascending order.
     *
     * @param country the value of {@link Country#ATTRIBUTE_NAME_COUNTRY country} attribute to match.
     * @return a list of countries
     */
    public List<Country> listByCountry(@NotNull final String country) {
        // TODO: 2019-07-20 implement!!!
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Lists countries sorted by {@link Country#ATTRIBUTE_NAME_COUNTRY country} attribute in either ascending or
     * descending indicated by specified flag.
     *
     * @param ascendingOrder the flag for ordering direction; {@code true} for ascending order; {@code false} for
     *                       descending order.
     * @param firstResult    the position of the first result to retrieve.
     * @param maxResults     the maximum number of results to retrieve.
     * @return a list of countries.
     */
    public List<Country> listSortedByCountry(final boolean ascendingOrder,
                                             @PositiveOrZero @Nullable final Integer firstResult,
                                             @Positive @Nullable final Integer maxResults) {
        // TODO: 2019-07-20 implement!!!
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Lists countries sorted by the number of cities reside in in either ascending or desdending indicated by specified
     * flag.
     *
     * @param ascendingOrder the flag for ordering direction; {@code true} for ascending order; {@code false} for
     *                       descending order.
     * @param firstResult    the position of the first result to retrieve.
     * @param maxResults     the maximum number of results to retrieve.
     * @return a list of countries.
     */
    public List<Country> listSortedByCityCount(final boolean ascendingOrder,
                                               @PositiveOrZero @Nullable final Integer firstResult,
                                               @Positive @Nullable final Integer maxResults) {
        // TODO: 2019-07-20 implement!!!
        throw new UnsupportedOperationException("not implemented yet");
    }
}
