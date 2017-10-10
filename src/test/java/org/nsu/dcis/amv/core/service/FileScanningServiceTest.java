package org.nsu.dcis.amv.core.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.FileScanResult;
import org.nsu.dcis.amv.core.instrumentation.AmvConfigurationInstrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FileScanningServiceTest {
    private Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    AmvConfigurationInstrumentation amvConfigurationInstrumentation;

    @Autowired
    FileScanningService fileScanningService;

    @Test
    public void scanForFiles() throws Exception {
        FileScanResult fileScanResult = fileScanningService.scan(amvConfigurationInstrumentation.getRootDir(),
                                                                 amvConfigurationInstrumentation.getExcludedDirectoryList(),
                                                                 amvConfigurationInstrumentation.getFileExtensions());
        assertTrue(fileScanResult != null);
        assertTrue(!fileScanResult.getFileList().isEmpty());
        assertTrue(fileScanResult.getFileList().size() > 0);
        log.info("Number of files: " + fileScanResult.getFileList().size());

//        for (String filePath : fileScanResult.getFileList()) {
//            System.out.println("file path: " + filePath);
//        }
    }
}


