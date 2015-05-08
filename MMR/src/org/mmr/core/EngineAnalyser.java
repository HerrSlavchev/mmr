package org.mmr.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseTokenizer;
import org.apache.lucene.analysis.en.PorterStemFilter;

final class EngineAnalyser extends Analyzer {

	EngineAnalyser() {
	}

	@Override
	protected TokenStreamComponents createComponents(final String fieldName) {
		final Tokenizer tokenizer = new LowerCaseTokenizer();
		final TokenStream tokenStream = new PorterStemFilter(tokenizer);

		return new TokenStreamComponents(tokenizer, tokenStream);
	}

}
