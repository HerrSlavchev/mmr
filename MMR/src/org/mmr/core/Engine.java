/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mmr.core;

import java.io.File;
import java.util.List;

/**
 * Use to process contexts
 *
 * @author root
 */
public class Engine {

    /**
     * Process a given context and populate it with the resulting index data.
     * @param ctx - the context
     */
    public static void createIndexData(Context ctx) {

        //get configurations
        File directory = ctx.getChosenDirectory();
        if (directory == null) {
            throw new RuntimeException("Missing directory!");
        }
        List<MIMEEnum> mimes = ctx.getAllowedMIMEs();
        if (mimes == null || mimes.isEmpty()) {
            throw new RuntimeException("Choose atleast one file type!");
        }

        Object result = null;
        //...magic!

        //populate context with the result
        ctx.setIndexData(result);
    }

    /**
     * Attempts to find all indexed documents (in the given context) containing a specific query.
     * @param query - the query text
     * @param ctx - a corresponding context where we search for results
     * @return - the results from this query against the given context
     */
    public static List<Object> processQuery(String query, Context ctx) {
        
        if (query == null || query.isEmpty()) {
            throw new RuntimeException("Missing query!");
        }
        Object indexData = ctx.getIndexData();
        if (indexData == null) {
            throw new RuntimeException("Missing indexing data!");
        }
        List<Object> result = null;
        ///...magic!
        
        return result;
    }
}
