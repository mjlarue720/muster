package muster

import org.junit.*

import static muster.Util.*

class UtilTests {

  @Before
  void setUp() {
    // Setup logic here
  }

  @After
  void tearDown() {
    // Tear down logic here
  }

  @Test
  void testSimpleCommand() {
    String cmd = "pwd"
    String result = execute(cmd)
    println("simpleCommand")
    println(result)
    assert (result != null)
  }

  @Test
  void testPipeCommand() {
    String cmd = "/usr/bin/python"
    String args = "print('hello world')\nprint('goodbye, cruel world!')"
    String result = executePipe(cmd, args)
    println("pipeCommand")
    println(result)
    assert (result.startsWith("hello"))
  }
}
