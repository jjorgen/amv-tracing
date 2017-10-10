package org.nsu.dcis.amv.core.controller;

import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;
import org.springframework.stereotype.Controller;

/**
 * Created by John Jorgensen on 3/7/2017.
 */
@Controller
public class CodeCloneController {
    public CodeCloneMiningResult getMiningResults() {
        return new CodeCloneMiningResult();
    }
}
