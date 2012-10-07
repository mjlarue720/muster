package muster

class Invite {

  static final String ORGANIZER = "organizer"
  static final String GUEST = "guest"

  static final String STATUS_OPEN = "status_open"
  static final String STATUS_ACCEPTED = "status_accepted"
  static final String STATUS_REJECTED = "status_open"
  static final String STATUS_ACKNOWLEDGED = "status_acknowledged"

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
