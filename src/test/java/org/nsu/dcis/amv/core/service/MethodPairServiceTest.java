package org.nsu.dcis.amv.core.service;

import com.github.javaparser.ast.MethodRepresentation;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.FileScanResult;
import org.nsu.dcis.amv.core.instrumentation.AmvConfigurationInstrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/13/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MethodPairServiceTest {

    private Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    private AmvConfigurationInstrumentation amvConfigurationInstrumentation;

    @Autowired
    private MethodRepresentationService methodRepresentationService;

    @Autowired
    private FileScanningService fileScanningService;

    @Autowired
//    private MethodPairService methodPairService;

//    private List<MethodRepresentation> methodRepresentations;

    @Ignore
    @Test
    public void getAnExactMethodPair() throws Exception {
        FileScanResult fileScanResult = new FileScanResult(new ArrayList<String>());
        List<MethodRepresentation> methodRepresentations =
                methodRepresentationService.getMethodRepresentations(fileScanResult);
//        List<Pair> pairs = methodPairService.getPairs(methodRepresentations);
//        assertTrue(pairs != null);
    }

    @Ignore
    @Test
    public void getAllMethodPairs() throws Exception {
        List<MethodRepresentation> methodRepresentations =
        methodRepresentationService.getMethodRepresentations(fileScanningService.scan(
                amvConfigurationInstrumentation.getRootDir(),
                amvConfigurationInstrumentation.getExcludedDirectoryList(), amvConfigurationInstrumentation.getFileExtensions()));

//        List<MethodPair> pairs = methodPairService.getPairs(methodRepresentations);
//        assertTrue(pairs != null);
    }
}

