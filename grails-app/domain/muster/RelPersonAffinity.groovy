package muster

class RelPersonAffinity {

   Person person
   AffinityGroup affinityGroup
   String status

    static constraints = {
      person()
      affinityGroup()
      status()
    }
  String toString(){ return person.toString() + affinityGroup.toString() }
}
