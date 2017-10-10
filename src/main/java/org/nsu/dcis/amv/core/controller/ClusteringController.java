package org.nsu.dcis.amv.core.controller;

import org.nsu.dcis.amv.core.domain.ClusteringMiningResults;
import org.springframework.stereotype.Controller;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@Controller
public class ClusteringController {

    public ClusteringMiningResults getMiningResults() {
        return new ClusteringMiningResults();
    }
}
