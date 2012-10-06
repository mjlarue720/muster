package muster

class PersonAlias {

  String name
  Person person

    static constraints = {
      name()
      person()
    }

    String toString(){ return person.getName() + ":" + name }
}
