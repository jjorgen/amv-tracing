package org.nsu.dcis.amv.core.controller;
import org.apache.log4j.Logger;
import org.aspectj.lang.Signature;
//import org.aspectj.lang.Signature;

/**
 * Created by John Jorgensen on 4/11/2017.
 */
public aspect Trace {

    private Logger log = Logger.getLogger(getClass().getName());

    pointcut traceMethods() : (execution(* *(..))&& !cflow(within(Trace)));

    before(): traceMethods(){
        Signature sig = thisJoinPointStaticPart.getSignature();
        String line =""+ thisJoinPointStaticPart.getSourceLocation().getLine();
        String sourceName = thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName();
                log.info(
                "Call from "
                        +  sourceName
                        +" line " +
                        line
                        +" to " +sig.getDeclaringTypeName() + "." + sig.getName()
        );
    }
}
