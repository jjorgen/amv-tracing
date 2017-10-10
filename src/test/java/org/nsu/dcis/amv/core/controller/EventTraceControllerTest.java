package org.nsu.dcis.amv.core.controller;

/**
 * Created by John on 3/7/2017.
 */

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nsu.dcis.amv.core.domain.EventTraceMiningResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventTraceControllerTest {

    @Autowired
    EventTraceController eventTraceController;

    @Ignore
    @Test
    public void successfullyMineForResults() throws Exception {
        EventTraceMiningResults eventTraceMiningResults = eventTraceController.getMiningResults();
        assertTrue(eventTraceMiningResults != null);
    }
}
