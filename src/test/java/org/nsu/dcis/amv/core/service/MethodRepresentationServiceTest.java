package org.nsu.dcis.amv.core.service;

import com.github.javaparser.ast.MethodRepresentation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.FileScanResult;
import org.nsu.dcis.amv.core.instrumentation.AmvConfigurationInstrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;

/**
 * Created by John Jorgensen on 3/12/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MethodRepresentationServiceTest {

    private int TOTAL_NUMBER_OF_METHODS_IN_SOFTWARE = 2741;

    @Autowired
    AmvConfigurationInstrumentation amvConfigurationInstrumentation;

    @Autowired
    MethodRepresentationService methodRepresentationService;

    @Autowired
    FileScanningService fileScanningService;

    private FileScanResult fileScanResult;
    private Logger log = Logger.getLogger(getClass().getName());

    @Before
    public void setUp() throws Exception {
        fileScanResult = fileScanningService.scan(amvConfigurationInstrumentation.getRootDir(),
                amvConfigurationInstrumentation.getExcludedDirectoryList(), amvConfigurationInstrumentation.getFileExtensions());
    }

    @Test
    public void getMethodRepresentations() throws Exception {
        List<MethodRepresentation> methodRepresentations = methodRepresentationService.getMethodRepresentations(fileScanResult);
        assertTrue("Method representations is not null", methodRepresentations != null);
        assertEquals("Number of methods is equal to all methods in software", TOTAL_NUMBER_OF_METHODS_IN_SOFTWARE, methodRepresentations.size());
        log.info("Total number of methods: " + methodRepresentations.size());

//        for (MethodRepresentation methodRepresentation : methodRepresentations) {
//            log.info(methodRepresentation.getFilePath());
//            log.info(methodRepresentation.getMethodName());
//            log.info(methodRepresentation.getStringifiedWithoutComments());
//            log.info(methodRepresentation.getMethodTokens());
//        }
    }
}

