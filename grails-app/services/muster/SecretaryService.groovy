package muster


class SecretaryService {

  def Boolean checkPerson(String name, String password){
    return (null != Person.findByNameAndPassword(name,password))
  }


  def Event createEvent(Person organizer, String name, String description, Date eventDate, String location, Integer quorum){

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
    Invite organizernvite = new Invite([organizer,event:event,orgRole:Invite.ORGANIZER,status:Invite.STATUS_ACCEPTED])

    return event
  }

  def Boolean organizerInviteGroup(Person organizer, Event event, AffinityGroup affinityGroup) {
    Invite masterInvite = Invite.findByPersonAndEvent(organizer,event);
    if (masterInvite == null || !masterInvite.orgRole.equals(Invite.ORGANIZER)){
      return Boolean.FALSE
    }
    List<Person>groupMembers = RelPersonAffinity.findByAffinityGroup(affinityGroup)

    for (Person invitee: groupMembers) {
      organizerInvitePerson(organizer,event,invitee)
    }
    return Boolean.TRUE

  }

  def Boolean organizerInvitePerson (Person organizer, Event event, Person guest) {
    Invite masterInvite = Invite.findByPersonAndEvent(organizer,event)
    if (masterInvite == null || !masterInvite.orgRole.equals(Invite.ORGANIZER)){
      return Boolean.FALSE
    }
    Invite guestInvite = Invite.findByPersonAndEvent(organizer,guest);
    if (guestInvite == null){
      guestInvite = new Invite([person:guest,event:event,orgRole:Invite.GUEST,status:Invite.STATUS_OPEN])
    }
    if (guestInvite.validate()) {
      guestInvite.save(true)
    }
    else {
      guestInvite.errors.allErrors.each { println it }
      throw new MusterRuntimeException("Error:  Cannot save guest invite");                                                                                           U
    }
    return Boolean.TRUE
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

  def void respondToInvitation(Invite invite, String status){
    invite.setStatus(status)
    invite.save()
  }

  def void processResponses(Event event){
    List<Invite>invitations = Invite.findAllByEvent(event)
    Integer acceptCount = 0
    Integer rejectCount = 0
    for (Invite invitation: invitations){
      if (invitation.status.equals(Invite.STATUS_ACCEPTED)){
        acceptCount++
      }
    }
    event.quorum = acceptCount
    event.save()
  }

}
