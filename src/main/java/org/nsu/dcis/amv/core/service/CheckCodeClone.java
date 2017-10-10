package org.nsu.dcis.amv.core.service;

import com.github.javaparser.ast.MethodRepresentation;
import org.nsu.dcis.amv.core.domain.CodeCloneMiningResult;

/**
 * Created by John Jorgensen on 3/16/2017.
 */
public interface CheckCodeClone {
    CodeCloneMiningResult getCodeCloneMiningResult(MethodRepresentation compareFrom, MethodRepresentation compareTo);
}
