package org.nsu.dcis.amv.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class FileScanner {

    private static final String JAVA_FILE_EXTENSION = "JAVA";

    @Autowired
    FileUtil fileUtil;

    private Logger log = Logger.getLogger(getClass().getName());

    public List<String> scan(String rootDir, List<String> excludedDirectoryList, Set<String> includeFileExtensions) {
        validate(rootDir, excludedDirectoryList);
        List<String> fileList = new ArrayList<>();
        scanFilesInDirectories(rootDir, excludedDirectoryList, includeFileExtensions, fileList);
        return fileList;
    }

    private void validate(String rootDir, List<String> excludedDirectoryList) {
        if (StringUtils.isBlank(rootDir)) {
            throw new IllegalArgumentException("Root directory must contain a value, value was: '" + rootDir + "'");
        }
        if (excludedDirectoryList == null) {
            throw new IllegalArgumentException("Excluded directory list can no be null, value was : " + excludedDirectoryList);
        }
    }

    private void scanFilesInDirectories(String rootDir, List<String> excludedDirectoryList, Set<String> includeFileExtensions, List<String> fileList) {
        File root = new File(rootDir);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File file : list) {
            if ( file.isDirectory() && (!inExcludedDirectoryList(file.getAbsolutePath(), excludedDirectoryList))) {
                scanFilesInDirectories(file.getAbsolutePath(), excludedDirectoryList, includeFileExtensions, fileList);
                log.debug("Dir:" + file.getAbsoluteFile());
            }
            else {
                if (isSearchableFileExtension(fileUtil.getFileExtension(file), includeFileExtensions)) {
                    fileList.add(file.getAbsolutePath());
                }
            }
        }
    }

    private boolean inExcludedDirectoryList(String absolutePath, List<String> excludedDirectoryList) {
        boolean excludedDirectory = false;
        for (String dir : excludedDirectoryList) {
            if (absolutePath.toUpperCase().contains(dir)) {
                excludedDirectory = true;
                return excludedDirectory;
            }
        }
        return excludedDirectory;
    }

    private boolean isSearchableFileExtension(String fileExtension, Set<String> includeFileExtensions) {
        return includeFileExtensions.contains(fileExtension.toUpperCase());
    }
}
