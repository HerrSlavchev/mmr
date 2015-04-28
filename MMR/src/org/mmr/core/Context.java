package org.mmr.core;

import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Used for state and configuration sharing among components.
 */
public final class Context {

	private Path chosenDirectory;

	private final Set<EContentType> allowedContentTypes = new HashSet<>();

	{
		// Default allowed content types are initialized.
		allowedContentTypes.add(EContentType.TXT);
		allowedContentTypes.add(EContentType.HTML);
	}

	public Optional<Path> getChosenDirectory() {
		return Optional.ofNullable(chosenDirectory);
	}

	public void setChosenDirectory(final Path directory) {
		chosenDirectory = directory;
	}

	public Set<EContentType> getAllowedContentTypes() {
		return allowedContentTypes;
	}

	public void setAllowedContentTypes(final Collection<EContentType> contentTypes) {
		allowedContentTypes.clear();
		allowedContentTypes.addAll(contentTypes);
	}

}
