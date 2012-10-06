package muster

class Invite {

   Person person
   Event event
   String orgRole
   String status

  static constraints = {
    person()
    event()
    orgRole()
    status()
  }

  String toString(){ return person.toString() + ":" + event.toString() }
}
