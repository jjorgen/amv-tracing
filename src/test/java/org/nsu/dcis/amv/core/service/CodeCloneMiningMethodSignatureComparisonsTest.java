package org.nsu.dcis.amv.core.service;

import com.github.javaparser.ast.MethodRepresentation;
import com.github.javaparser.extend.CompilationUnitWrapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;
import org.nsu.dcis.amv.core.instrumentation.AmvConfigurationInstrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.github.javaparser.extend.CompilationUnitWrapper.getCompilationUnit;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/12/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeCloneMiningMethodSignatureComparisonsTest {

    private static final String CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES = "C:/WS/amvCore/src/test/java/org/nsu/dcis/amv/core/support/MethodsWithVariedSignatures.java";

    @Autowired
    AmvConfigurationInstrumentation amvConfigurationInstrumentation;

    @Autowired
    private CodeCloneMiningService codeCloneMiningService;

    private CompilationUnitWrapper compilationUnitWrapper;
    private Logger log = Logger.getLogger(getClass().getName());

    @Before
    public void setUp() throws Exception {
        compilationUnitWrapper = new CompilationUnitWrapper(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES);
    }

    @Test
    public void getMiningResults() throws Exception {
        List<CodeCloneMiningResult>  codeCloneMiningResults =
                codeCloneMiningService.getCodeCloneMiningResults(getRootDir(), getExcludedDirectoryList(), amvConfigurationInstrumentation.getFileExtensions());
        assertTrue("Code clone mining results were returned", codeCloneMiningResults != null);
        assertTrue("At least one code clone mining result was returned", codeCloneMiningResults.size() > 0);
        assertTrue("Method pair is a clone", codeCloneMiningResults.get(0).isEmpty());
    }

    @Test
    public void twoSignaturesWithSameNumberOfParametersButDifferentTypes() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));
        MethodRepresentation secondMethodWithDifferentSignature = compilationUnitWrapper.getMethodRepresentationFor(
                "secondMethodWithFlippedParameters", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));

        assertTrue("Signatures are different", !codeCloneMiningService.signaturesAreEqual(firstMethod, secondMethodWithDifferentSignature));
    }

    @Test
    public void twoSignaturesWithDifferentNumberOfParameters() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));
        MethodRepresentation thirdMethodWithMoreParameters = compilationUnitWrapper.getMethodRepresentationFor(
                "thirdMethodWithMoreParameters", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));

        assertTrue("Signatures are different", !codeCloneMiningService.signaturesAreEqual(firstMethod, thirdMethodWithMoreParameters));
    }

    @Test
    public void twoSignaturesThatAreTheSame() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));
        MethodRepresentation fourthMethodSameAsFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "fourthMethodSameAsFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));

        assertTrue("Signatures are the same", codeCloneMiningService.signaturesAreEqual(firstMethod, fourthMethodSameAsFirstMethod));
    }

    @Test
    public void twoMethodsWithTheSameBodies() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));
        MethodRepresentation fourthMethodSameAsFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "fourthMethodSameAsFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_SIGNATURES));

        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(firstMethod, fourthMethodSameAsFirstMethod);
        assertTrue("Method bodies are the same", codeCloneMiningResult.isClone());
    }

    private String getRootDir() {
        return "C:/WS/amvCore/src/test/java/org/nsu/dcis/amv/core/support";
    }

    private List<String> getExcludedDirectoryList() {
        StringTokenizer st = new StringTokenizer("samples,jdk11,jdk12", ",");
        List<String> excludedDirectoryList = new ArrayList<>();
        while (st.hasMoreElements()) {
            excludedDirectoryList.add(((String) st.nextElement()).toUpperCase());
        }
        return excludedDirectoryList;
    }
}
