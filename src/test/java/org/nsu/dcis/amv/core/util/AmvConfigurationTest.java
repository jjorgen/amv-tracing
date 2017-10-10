package org.nsu.dcis.amv.core.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AmvConfigurationTest {

    @Autowired
    AmvConfiguration amvConfiguration;

    @Test
    public void getAmvConfiguration() throws Exception {
        String miningRootDirectory = amvConfiguration.getJhotdrawSourceRoot();
        assertTrue(miningRootDirectory != null && !"".equals(miningRootDirectory));

    }
}
