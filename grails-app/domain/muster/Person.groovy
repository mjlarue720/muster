package muster

class Person {

  String name
  String description
  String password
  String email

  static constraints = {
    name()
    description()
    password()
    email()
  }

  String toString(){ return name }
  
}
