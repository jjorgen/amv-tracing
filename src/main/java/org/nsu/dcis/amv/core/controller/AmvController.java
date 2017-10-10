package org.nsu.dcis.amv.core.controller;

import org.nsu.dcis.amv.core.domain.ClusteringMiningResults;
import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;
import org.nsu.dcis.amv.core.domain.EventTraceMiningResults;
import org.nsu.dcis.amv.domain.MiningResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@Controller
public class AmvController
{
    @Autowired
    CodeCloneController codeCloneController;

    @Autowired
    ClusteringController clusteringController;

    @Autowired
    EventTraceController eventTraceController;

    public MiningResults getMiningResults() {

        CodeCloneMiningResult codeCloneMiningResult = codeCloneController.getMiningResults();
        ClusteringMiningResults clusteringMiningResults = clusteringController.getMiningResults();
        EventTraceMiningResults eventTraceMiningResults = eventTraceController.getMiningResults();

        MiningResults miningResults = new MiningResults(codeCloneMiningResult,
                                                        clusteringMiningResults,
                                                        eventTraceMiningResults);
        return miningResults;
    }
}
