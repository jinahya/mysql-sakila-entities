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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.github.jinahya.sakila.persistence.BaseEntity.ATTRIBUTE_NAME_LAST_UPDATE;
import static com.github.jinahya.sakila.persistence.BaseEntity.COLUMN_NAME_LAST_UPDATE;

/**
 * An entity class for {@value #TABLE_NAME} table.
 */
@Entity
@IdClass(FilmActorId.class)
@Table(name = FilmActor.TABLE_NAME)
public class FilmActor implements Serializable {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "film_actor";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String COLUMN_NAME_ACTOR_ID = "actor_id";

    public static final String ATTRIBUTE_NAME_ACTOR = "actor";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String COLUMN_NAME_FILM_ID = "film_id";

    public static final String ATTRIBUTE_NAME_FILM = "film";

    // -----------------------------------------------------------------------------------------------------------------
    public static long countFilms(final Actor actor) {
        throw new UnsupportedOperationException("unsupported operation; not implemented yet");
    }

    public static List<Film> listFilms(final Actor actor) {
        throw new UnsupportedOperationException("unsupported operation; not implemented yet");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public FilmActor() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString() + "{" +
               "actor=" + actor
               + ",film=" + film
               + ",lastUpdate=" + lastUpdate
               + '}';
    }

    // TODO: 2019-07-10 Add equals/hashCode ???

    // ----------------------------------------------------------------------------------------------------------- actor
    public Actor getActor() {
        return actor;
    }

    public void setActor(final Actor actor) {
        this.actor = actor;
    }

    // ------------------------------------------------------------------------------------------------------------ film
    public Film getFilm() {
        return film;
    }

    public void setFilm(final Film film) {
        this.film = film;
    }

    // ------------------------------------------------------------------------------------------------------ lastUpdate

    /**
     * Returns the current value of {@value com.github.jinahya.sakila.persistence.BaseEntity#ATTRIBUTE_NAME_LAST_UPDATE}
     * attribute.
     *
     * @return the current value of {@value com.github.jinahya.sakila.persistence.BaseEntity#ATTRIBUTE_NAME_LAST_UPDATE}
     * attribute.
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @NotNull
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = COLUMN_NAME_ACTOR_ID, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_ACTOR)
    private Actor actor;

    @NotNull
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = COLUMN_NAME_FILM_ID, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_FILM)
    private Film film;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = COLUMN_NAME_LAST_UPDATE, nullable = false, insertable = false, updatable = false)
    @NamedAttribute(ATTRIBUTE_NAME_LAST_UPDATE)
    private Date lastUpdate;
}
