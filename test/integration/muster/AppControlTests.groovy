package muster

import static org.junit.Assert.*
import org.junit.*

class AppControlTests {

  AppControl appControl

  @Before
  void setUp() {
    AppControl.unInit()
    Boolean status = AppControl.firstBoot()

    appControl = AppControl.getSingleton()
    appControl.guaranteeNoCounter("foo")

  }

  @After
  void tearDown() {
    AppControl.unInit()
  }

  @Test
  void testCounters() {
    Integer foo1 = appControl.counterNext("foo")
    Integer foo2 = appControl.counterNext("foo")
    assertTrue(foo1.equals(1))
    assertTrue(foo2.equals(2))
  }
}
