package org.nsu.dcis.amv.core.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.domain.MiningResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AmvControllerTest {

    @Autowired
    AmvController amvController;

//    @Ignore
    @Test
    public void getMiningResultsSuccessfully() throws Exception {
        MiningResults miningResults = amvController.getMiningResults();
        assertTrue(miningResults != null);
    }
}
