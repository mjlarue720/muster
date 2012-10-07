package muster

class Person {

  String name
  String description
  String password

  static constraints = {
    name()
    description()
    password()
  }

  String toString(){ return name }
  
}
