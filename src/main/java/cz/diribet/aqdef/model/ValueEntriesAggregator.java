package cz.diribet.aqdef.model;

import static java.util.Objects.requireNonNull;

import cz.diribet.aqdef.KKey;
import cz.diribet.aqdef.KKey.Level;

/**
 * Aggregates entries of value, characteristic and part.
 * This simplifies access to the values of the K-keys and passing of the entries to the other objects (crate).
 *
 * @author Vlastimil Dolejs
 *
 */
public class ValueEntriesAggregator extends CharacteristicEntriesAggregator {
	//*******************************************
	// Attributes
	//*******************************************

	private final IHasKKeyValues valueEntries;

	//*******************************************
	// Constructors
	//*******************************************

	public ValueEntriesAggregator(IHasKKeyValues partEntries, IHasKKeyValues characteristicEntries, IHasKKeyValues valueEntries) {
		super(partEntries, characteristicEntries);

		this.valueEntries = requireNonNull(valueEntries);
	}

	//*******************************************
	// Methods
	//*******************************************

	@Override
	public <T> T getValue(KKey kKey) {
		Level level = kKey.getLevel();

		switch (level) {
			case VALUE:
			case CUSTOM_VALUE:
				return valueEntries.getValue(kKey);

			default:
				return super.getValue(kKey);
		}
	}

	//*******************************************
	// Getters / setters
	//*******************************************

	public IHasKKeyValues getValueEntries() {
		return valueEntries;
	}

}
