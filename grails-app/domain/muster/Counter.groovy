package muster

class Counter {

  String name
  Long value

  Counter(){}

  static constraints = {
    name()
    value()
  }


  private Long next(){ return ++value }

  String toString(){ "${name}:${value}"}
}
