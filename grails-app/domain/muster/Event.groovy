package muster

class Event {

   String name
   String description
   Date eventDate
   String location
   String state
   Integer quorum
//   Integer numberCommitted


    static constraints = {
      name()
      description()
      location()
      state()
      quorum()
//      numberComitted()
    }

    String toString(){ return name + ":" + eventDate.toString() }
}
