package muster

class Event {

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
