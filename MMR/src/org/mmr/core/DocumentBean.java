package org.mmr.core;

import java.util.Optional;
import org.apache.lucene.document.Document;

public final class DocumentBean {

	private final String path;

	private final String content;

	private Optional<String> title = Optional.empty();

	public DocumentBean(final String path, final String content, final String title) {
		this(path, content);
		this.title = Optional.of(title);
	}

	public DocumentBean(final String path, final String content) {
		this.path = path;
		this.content = content;
	}

	public Document asDocument() {
		final Document document = new Document();

		return document;
	}

	public String getPath() {
		return path;
	}

	public String getContent() {
		return content;
	}

	public Optional<String> getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return String.format("Document bean path: %s\ntitle: %s\ncontent: %s\n", path, title.orElse(""), content);
	}

}
