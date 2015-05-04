package org.mmr.core;

import java.io.IOException;
import static java.nio.file.FileVisitOption.FOLLOW_LINKS;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

/**
 * Used to process a context.
 */
public final class Engine {

	private Engine() {
	}

	/**
	 * Process a given context and create an index.
	 *
	 * @param context - contains information about chosen directory and allowed
	 * content types.
	 */
	public static final void createIndex(final Context context) {
		final Optional<Path> chosenDirectory = context.getChosenDirectory();

		if (chosenDirectory.isPresent()) {
			final Set<EContentType> allowedContentTypes = context.getAllowedContentTypes();

			if (!allowedContentTypes.isEmpty()) {
				try (final IndexWriter indexWriter = createIndexWriter()) {
					Files.walkFileTree(
							chosenDirectory.get(),
							EnumSet.of(FOLLOW_LINKS),
							Integer.MAX_VALUE,
							new EngineDirectoryVisitor(allowedContentTypes, indexWriter)
					);
				} catch (final IOException exception) {
					Logger.getGlobal().log(Level.SEVERE, "Unexpected exception occurred while walking through a file tree.", exception);
				}
			}
		} else {
			throw new RuntimeException("Directory is not available in context!");
		}
	}

	private static IndexWriter createIndexWriter() throws IOException {
		final Directory directory = new RAMDirectory();

		final Analyzer analyzer = new StandardAnalyzer();
		final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		indexWriterConfig.setOpenMode(OpenMode.CREATE);

		return new IndexWriter(directory, indexWriterConfig);
	}

	/**
	 * Attempts to find all indexed documents (in the given context) containing
	 * a specific query.
	 *
	 * @param query - the query text
	 * @param ctx - a corresponding context where we search for results
	 * @return - the results from this query against the given context
	 */
	public static List<Object> processQuery(String query, Context ctx) {

		if (query == null || query.isEmpty()) {
			throw new RuntimeException("Missing query!");
		}
		Object indexData = null;// ctx.getIndexData();
		if (indexData == null) {
			throw new RuntimeException("Missing indexing data!");
		}
		List<Object> result = null;
		///...magic!

		return result;
	}
}
