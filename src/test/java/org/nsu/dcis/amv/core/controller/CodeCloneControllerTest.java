package org.nsu.dcis.amv.core.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeCloneControllerTest {

    @Autowired
    private CodeCloneController codeCloneController;

    @Ignore
    @Test
    public void successfullyMineForResults() throws Exception {
        CodeCloneMiningResult miningResults = codeCloneController.getMiningResults();
        assertTrue(miningResults != null);

    }
}
