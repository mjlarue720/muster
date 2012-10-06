package muster

class AffinityGroup {

  String name
  String description

  static constraints = {
    name()
    description()
  }
  String toString(){ return name }
}
