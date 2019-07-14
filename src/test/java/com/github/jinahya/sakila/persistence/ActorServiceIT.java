package com.github.jinahya.sakila.persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.github.jinahya.sakila.persistence.FullNameEmbedded.comparingFirstName;
import static java.util.Collections.unmodifiableSet;
import static java.util.Optional.ofNullable;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * A class for testing {@link ActorService}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
class ActorServiceIT extends BaseEntityServiceIT<ActorService, Actor> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A set of first names.
     */
    static final Set<String> FIRST_NAMES;

    static {
        final Set<String> set = new LinkedHashSet<>();
        try {
            try (InputStream stream = ActorServiceIT.class.getResourceAsStream("actor_set_first_name.txt");
                 Scanner scanner = new Scanner(stream)) {
                while (scanner.hasNext()) {
                    set.add(scanner.next());
                }
            }
            FIRST_NAMES = unmodifiableSet(set);
        } catch (final IOException ioe) {
            ioe.printStackTrace();
            throw new InstantiationError(ioe.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A set of last names.
     */
    static final Set<String> LAST_NAMES;

    static {
        final Set<String> set = new LinkedHashSet<>();
        try {
            try (InputStream stream = ActorServiceIT.class.getResourceAsStream("actor_set_last_name.txt");
                 Scanner scanner = new Scanner(stream)) {
                while (scanner.hasNext()) {
                    set.add(scanner.next());
                }
            }
            LAST_NAMES = unmodifiableSet(set);
        } catch (final IOException ioe) {
            ioe.printStackTrace();
            throw new InstantiationError(ioe.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static Stream<Arguments> provideArgumentsWithLastName() {
        return IntStream.range(0, current().nextInt(1, 17)).mapToObj(i -> {
            final String lastName = current().nextBoolean() ? null : randomEntity(Actor.class).getLastName();
            final boolean ascendingOrder = current().nextBoolean();
            final Integer firstResult = current().nextBoolean() ? null : firstResult(Actor.class);
            final Integer maxResult = current().nextBoolean() ? null : maxResults(Actor.class);
            return Arguments.of(lastName, ascendingOrder, firstResult, maxResult);
        });
    }

    private static Stream<Arguments> provideArgumentsWithFirstName() {
        return IntStream.range(0, current().nextInt(1, 17)).mapToObj(i -> {
            final String lastName = current().nextBoolean() ? null : randomEntity(Actor.class).getLastName();
            final boolean ascendingOrder = current().nextBoolean();
            final Integer firstResult = current().nextBoolean() ? null : firstResult(Actor.class);
            final Integer maxResult = current().nextBoolean() ? null : maxResults(Actor.class);
            return Arguments.of(lastName, ascendingOrder, firstResult, maxResult);
        });
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    ActorServiceIT() {
        super(ActorService.class, Actor.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Tests {@link ActorService#streamOrderedByFirstName(String, boolean, Integer, Integer)} method.
     *
     * @param lastName       a value for {@code lastName} parameter.
     * @param ascendingOrder a value for {@code ascendingOrder} parameter.
     * @param firstResult    a value for {@code firstResult} parameter.
     * @param maxResults     a value for {@code maxResults} parameter.
     */
    @MethodSource({"provideArgumentsWithLastName"})
    @ParameterizedTest
    void testStreamOrderByFirstName(final String lastName, final boolean ascendingOrder, final Integer firstResult,
                                    final Integer maxResults) {
        log.debug("lastName: {}, ascendingOrder: {}, firstResult: {}, maxResults: {}", lastName, ascendingOrder,
                  firstResult, maxResults);
        final List<Actor> stream = serviceInstance()
                .streamOrderedByFirstName(lastName, ascendingOrder, firstResult, maxResults)
                .collect(toList());
        assertThat(stream)
                .allMatch(a -> ofNullable(lastName).map(v -> v.equals(a.getLastName())).orElse(true))
                .isSortedAccordingTo(comparingFirstName(ascendingOrder))
                .size()
                .matches(s -> ofNullable(maxResults).map(v -> s <= v).orElse(true))
        ;
    }

    /**
     * Tests {@link ActorService#streamOrderedByLastName(String, boolean, Integer, Integer)} method.
     *
     * @param firstName      a value for {@code firstName} parameter.
     * @param ascendingOrder a value for {@code ascendingOrder} parameter.
     * @param firstResult    a value for {@code firstResult} parameter.
     * @param maxResults     a value for {@code maxResults} parameter.
     */
    @MethodSource({"provideArgumentsWithFirstName"})
    @ParameterizedTest
    void testStreamOrderByLastName(final String firstName, final boolean ascendingOrder, final Integer firstResult,
                                   final Integer maxResults) {
        final List<Actor> stream = serviceInstance()
                .streamOrderedByLastName(firstName, ascendingOrder, firstResult, maxResults)
                .collect(toList());
        assertThat(stream)
                .allMatch(a -> ofNullable(firstName).map(v -> v.equals(a.getFirstName())).orElse(true))
                .isSortedAccordingTo(comparingFirstName(ascendingOrder))
                .size()
                .matches(s -> ofNullable(maxResults).map(v -> s <= v).orElse(true))
        ;
    }
}
