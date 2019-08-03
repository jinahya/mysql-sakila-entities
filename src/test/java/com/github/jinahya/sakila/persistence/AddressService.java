package com.github.jinahya.sakila.persistence;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * A service class for {@link Address} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
class AddressService extends BaseEntityService<Address> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    AddressService() {
        super(Address.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Counts all addresses which each resides in specified city.
     * <blockquote><pre>{@code
     * SELECT COUNT(*) FROM city AS c WHERE c.city_id = ?
     * }</pre></blockquote>
     *
     * @param city the city whose addresses are counted.
     * @return the number of address reside in specified city.
     */
    @PositiveOrZero long count(@NotNull final City city) {
        // TODO: 2019-07-27 implement!!!
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Lists addresses which each resides in specified city sorted by {@link Address#ATTRIBUTE_NAME_DISTRICT district}
     * attribute and {@link Address#ATTRIBUTE_NAME_ADDRESS address} attribute in both ascending order.
     *
     * @param city        the city whose addresses are listed.
     * @param firstResult the first index of the result, numbered from {@code 0}; {@code null} for an unspecified
     *                    result.
     * @param maxResults  the maximum number of results to retrieve; {@code null} for an unspecified result.
     * @return a list of addresses.
     */
    @NotNull List<@NotNull Address> list(@NotNull final City city, @PositiveOrZero @Nullable Integer firstResult,
                                         @Positive @Nullable Integer maxResults) {
        // TODO: 2019-07-27 implement!!!
        throw new UnsupportedOperationException("not implemented yet");
    }
}
