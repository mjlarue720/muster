package muster


class SecretaryService {

  def Boolean checkPerson(String name, String password){
    return (null != Person.findByNameAndPassword(name,password))
  }


  def Event createEvent(String name, String description, Date eventDate, String location, Integer quorum){

    Event event = Event.findByNameAndEventDate(name,eventDate)
    if (event != null){
      throw new KeyException("Duplicate key " + name + ":" + eventDate.toString())
    }

    event = new Event()
    event.name = name
    event.description = description
    event.eventDate = eventDate
    event.location = location
    event.quorum = quorum
    event.state = "initial"
    event.status = "nominal"
//    [
//      name:name, description:description, eventDate:eventDate,
//      location:location, quorum:quorum,state:"inital", event.status:"nominal"])

    if (event.validate()) {
      event.save(true)
    }
    else {
      event.errors.allErrors.each {
        println it
      }
      KeyException("Validation error " + name + ":" + eventDate.toString())
    }
    return event
  }


  def void inviteGroup(Event event, AffinityGroup affinityGroup) {
    // Make sure a person has an invitation to the event

  }

  def void invitePerson(Event event, Person person) {
    // Make sure person is invited to meeting

  }

  def List<Event> eventsForPerson(String name){
    Person person = Person.findByName(name)
    if (person == null){
      return new ArrayList<Event>()
    } else {
      return Invite.findAllByPerson(person)
    }
  }

  def List<Event> eventsForPerson(String name, String orgRole){
    Person person = Person.findByName(name)
    if (person == null){
      return new ArrayList<Event>()
    } else {
      return Invite.findAllByPersonAndOrgRole(person)
    }
  }



}
