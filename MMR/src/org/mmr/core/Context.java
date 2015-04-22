/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mmr.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Use to share state and configuration among components.
 *
 * @author root
 */
public class Context {

    private File chosenDirectory;
    private List<MIMEEnum> allowedMIMEs = new ArrayList<>();
    private Object indexData;

    public File getChosenDirectory() {
        return chosenDirectory;
    }

    public void setChosenDirectory(File chosenDirectory) {
        this.chosenDirectory = chosenDirectory;
    }

    public List<MIMEEnum> getAllowedMIMEs() {
        return allowedMIMEs;
    }

    public void setAllowedMIMEs(List<MIMEEnum> mimes) {
        this.allowedMIMEs = mimes;
    }

    public Object getIndexData() {
        return indexData;
    }

    public void setIndexData(Object indexData) {
        this.indexData = indexData;
    }
}
