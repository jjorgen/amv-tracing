package CH.ifa.draw.test.samples.pert;

import junit.framework.TestCase;
// JUnitDoclet begin import
import CH.ifa.draw.samples.pert.PertDependency;
// JUnitDoclet end import

/*
* Generated by JUnitDoclet, a tool provided by
* ObjectFab GmbH under LGPL.
* Please see www.junitdoclet.org, www.gnu.org
* and www.objectfab.de for informations about
* the tool, the licence and the authors.
*/


// JUnitDoclet begin javadoc_class
/**
* TestCase PertDependencyTest is generated by
* JUnitDoclet to hold the tests for PertDependency.
* @see CH.ifa.draw.samples.pert.PertDependency
*/
// JUnitDoclet end javadoc_class
public class PertDependencyTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.samples.pert.PertDependency pertdependency = null;
  // JUnitDoclet end class
  
  /**
  * Constructor PertDependencyTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public PertDependencyTest(String name) {
    // JUnitDoclet begin method PertDependencyTest
    super(name);
    // JUnitDoclet end method PertDependencyTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.samples.pert.PertDependency createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return new CH.ifa.draw.samples.pert.PertDependency();
    // JUnitDoclet end method testcase.createInstance
  }
  
  /**
  * Method setUp is overwriting the framework method to
  * prepare an instance of this TestCase for a single test.
  * It's called from the JUnit framework only.
  */
  protected void setUp() throws Exception {
    // JUnitDoclet begin method testcase.setUp
    super.setUp();
    pertdependency = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    pertdependency = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method handleConnect()
  /**
  * Method testHandleConnect is testing handleConnect
  * @see CH.ifa.draw.samples.pert.PertDependency#handleConnect(CH.ifa.draw.framework.Figure, CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method handleConnect()
  public void testHandleConnect() throws Exception {
    // JUnitDoclet begin method handleConnect
    // JUnitDoclet end method handleConnect
  }
  
  // JUnitDoclet begin javadoc_method handleDisconnect()
  /**
  * Method testHandleDisconnect is testing handleDisconnect
  * @see CH.ifa.draw.samples.pert.PertDependency#handleDisconnect(CH.ifa.draw.framework.Figure, CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method handleDisconnect()
  public void testHandleDisconnect() throws Exception {
    // JUnitDoclet begin method handleDisconnect
    // JUnitDoclet end method handleDisconnect
  }
  
  // JUnitDoclet begin javadoc_method canConnect()
  /**
  * Method testCanConnect is testing canConnect
  * @see CH.ifa.draw.samples.pert.PertDependency#canConnect(CH.ifa.draw.framework.Figure, CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method canConnect()
  public void testCanConnect() throws Exception {
    // JUnitDoclet begin method canConnect
    // JUnitDoclet end method canConnect
  }
  
  // JUnitDoclet begin javadoc_method handles()
  /**
  * Method testHandles is testing handles
  * @see CH.ifa.draw.samples.pert.PertDependency#handles()
  */
  // JUnitDoclet end javadoc_method handles()
  public void testHandles() throws Exception {
    // JUnitDoclet begin method handles
    // JUnitDoclet end method handles
  }
  
  
  
  // JUnitDoclet begin javadoc_method testVault
  /**
  * JUnitDoclet moves marker to this method, if there is not match
  * for them in the regenerated code and if the marker is not empty.
  * This way, no test gets lost when regenerating after renaming.
  * <b>Method testVault is supposed to be empty.</b>
  */
  // JUnitDoclet end javadoc_method testVault
  public void testVault() throws Exception {
    // JUnitDoclet begin method testcase.testVault
    // JUnitDoclet end method testcase.testVault
  }
  
  /**
  * Method to execute the TestCase from command line
  * using JUnit's textui.TestRunner .
  */
  public static void main(String[] args) {
    // JUnitDoclet begin method testcase.main
    junit.textui.TestRunner.run(PertDependencyTest.class);
    // JUnitDoclet end method testcase.main
  }
}