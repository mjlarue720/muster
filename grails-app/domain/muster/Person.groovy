package muster

class Person {

  String name
  String description

  static constraints = {
    name()
    description()
  }

  String toString(){ return name }
  
}
