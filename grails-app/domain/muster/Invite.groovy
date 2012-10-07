package muster

class Invite {

  static final String ORGANIZER = "organizer"
  static final String INVITEE = "invitee"

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
