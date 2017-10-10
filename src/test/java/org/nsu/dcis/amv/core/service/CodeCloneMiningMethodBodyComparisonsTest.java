package org.nsu.dcis.amv.core.service;

import com.github.javaparser.ast.MethodRepresentation;
import com.github.javaparser.extend.CompilationUnitWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.javaparser.extend.CompilationUnitWrapper.getCompilationUnit;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/19/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeCloneMiningMethodBodyComparisonsTest {

    private static final String CLASS_WITH_METHODS_WITH_VARIED_BODIES = "C:/WS/amvCore/src/test/java/org/nsu/dcis/amv/core/support/MethodsWithVariedBodies.java";

    @Autowired
    private CodeCloneMiningService codeCloneMiningService;

    private CompilationUnitWrapper compilationUnitWrapper;

    @Before
    public void setUp() throws Exception {
        compilationUnitWrapper = new CompilationUnitWrapper(CLASS_WITH_METHODS_WITH_VARIED_BODIES);
    }

    @Test // Check for Around Advice Candidate
    public void twoMethodsWithTheSameBodies_IsClone() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        MethodRepresentation fourthMethodSameAsFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "fourthMethodSameAsFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(firstMethod, fourthMethodSameAsFirstMethod);
        assertTrue("Method clone", codeCloneMiningResult.isClone());
        assertTrue("Empty Code Clone Mining Result",codeCloneMiningResult.getType() == CodeCloneMiningResult.Type.CLONE);
    }

    @Test
    public void twoMethodBodiesWhereFirstTwoLinesAreTheSame_IsBeforeAdviceCandidate() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        MethodRepresentation fifthMethodWithBeforeAdviceComparedToFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "fifthMethodWithBeforeAdviceComparedToFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(firstMethod, fifthMethodWithBeforeAdviceComparedToFirstMethod);
        assertTrue("Before Advice Candidate", codeCloneMiningResult.isBeforeAdviceCandidate());
        assertTrue("No After Advice Candidate", !codeCloneMiningResult.isAfterAdviceCandidate());
        assertTrue("No Around Advice Candidate", !codeCloneMiningResult.isAroundAdviceCandidate());
        assertTrue("Is Before Advice Candidate",codeCloneMiningResult.getType() == CodeCloneMiningResult.Type.BEFORE_ADVICE_CANDIDATE);
    }

    @Test // Check for After Advice Candidate
    public void twoMethodBodiesWhereLastTwoLinesAreTheSame_IsAfterAdviceCandidate() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        MethodRepresentation sixthMethodWithAfterAdviceComparedToFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "sixthMethodWithAfterAdviceComparedToFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(firstMethod, sixthMethodWithAfterAdviceComparedToFirstMethod);
        assertTrue("After Advice Candidate", codeCloneMiningResult.isAfterAdviceCandidate());
    }

    @Test
    public void twoEmptyBodyMethodsShouldGive_NoAdviceCandidate() throws Exception {
        MethodRepresentation eithEmptyBodyMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "eithEmptyBodyMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        MethodRepresentation ninthEmptyBodyMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "ninthEmptyBodyMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(eithEmptyBodyMethod, ninthEmptyBodyMethod);
        assertTrue("No Clone for empty body methods", !codeCloneMiningResult.isClone());
        assertTrue("No Before Advice Candidate for empty body methods", !codeCloneMiningResult.isBeforeAdviceCandidate());
        assertTrue("No After Advice Candidate for empty body methods", !codeCloneMiningResult.isAfterAdviceCandidate());
    }

    @Test
    public void twoMethodBodiesWhereFirstAndLastLinesAreTheSame_IsAroundAdviceCandidate() throws Exception {
        MethodRepresentation firstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "firstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        MethodRepresentation seventhMethodWithAfterAdviceComparedToFirstMethod = compilationUnitWrapper.getMethodRepresentationFor(
                "seventhMethodWithAfterAdviceComparedToFirstMethod", getCompilationUnit(CLASS_WITH_METHODS_WITH_VARIED_BODIES));
        CodeCloneMiningResult codeCloneMiningResult = codeCloneMiningService.compareMethodBodies(firstMethod, seventhMethodWithAfterAdviceComparedToFirstMethod);
        assertTrue("No Clone for empty body methods", !codeCloneMiningResult.isClone());
        assertTrue("No Before Advice Candidate for methods with same first and last line", !codeCloneMiningResult.isBeforeAdviceCandidate());
        assertTrue("No After Advice Candidate for methods with  same first and last line", !codeCloneMiningResult.isAfterAdviceCandidate());
        assertTrue("Around Advice Candidate since first and last line in methods are the same", codeCloneMiningResult.isAroundAdviceCandidate());
    }
}
