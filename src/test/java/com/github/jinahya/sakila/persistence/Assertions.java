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

final class Assertions {

    // -----------------------------------------------------------------------------------------------------------------
    private static class BaseEntityAssert_ extends BaseEntityAssert<BaseEntityAssert_, BaseEntity> {

        BaseEntityAssert_(final BaseEntity actual) {
            super(actual);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    static BaseEntityAssert<? extends BaseEntityAssert, BaseEntity> assertThat(final BaseEntity actual) {
        return new BaseEntityAssert_(actual);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static ActorAssert assertThat(final Actor actual) {
        return new ActorAssert(actual);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static CityAssert assertThat(final City actual) {
        return new CityAssert(actual);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static CountryAssert assertThat(final Country actual) {
        return new CountryAssert(actual);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private Assertions() {
        super();
    }
}
