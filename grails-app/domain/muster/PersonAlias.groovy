package muster

class PersonAlias {

  String name
  String aliasType
  Person person

    static constraints = {
      name()
      person()
      aliasType()
    }

    String toString(){ return person.getName() + ":" + name }
}
