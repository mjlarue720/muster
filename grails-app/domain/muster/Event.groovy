package muster

class Event {

  public static final String STATE_PLANNING = "STATE_PLANNING"
  public static final String STATE_OPEN = "STATE_OPEN"
  public static final String STATE_COMITTED = "STATE_COMITTED"
  public static final String STATE_ACTIVE = "STATE_ACTIVE"
  public static final String STATE_PASSED = "STATE_PASSED"

   String name
   String description
   Date eventDate
   String location
   String state
   String status
   Integer quorum
//   Integer numberCommitted


    static constraints = {
      name()
      description()
      location()
      state()
      status()
      quorum()
//      numberComitted()
    }

    String toString(){ return name + ":" + eventDate.toString() }
}
