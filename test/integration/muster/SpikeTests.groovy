package muster

import static org.junit.Assert.*
import org.junit.*
import grails.test.GrailsUnitTestCase
/**
 * Created with IntelliJ IDEA.
 * User: gvamos
 * Date: 10/6/12
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
class SpikeTests  extends GrailsUnitTestCase {

  SecretaryService secretary

  @Before                                                        // Setup logic here
  void setUp() {
    Event.list()*.delete()
    secretary = new SecretaryService()
  }

  @After
  void tearDown(){
    Event.list()*.delete()
  }

  @Test
  void testFoo() {

    assertTrue(Boolean.TRUE)

  }

  @Test
  void testNewEvent() {
    Event event1 =  secretary.createEvent("Golf", "Play Golf", new Date(), "Golf course", 4)
    Event event2
    Boolean caught = Boolean.FALSE
    try{
      event2 = secretary.createEvent("Golf", "Play Golf", new Date(), "Golf course", 4)
      fail("duplicate event not caught")

    }catch(Exception e){
      caught = Boolean.TRUE
    }
    assertTrue(caught)

  }
}
