package muster

class AppControl {

  public static final String REST_FORMAT = "format"
  public static final String CSV = "csv"
  public static final String HTML = "html"
  public static final String TTL = "ttl"

  String name
  String status
  Date dateCreated
  Date lastUpdated
  Date lastStarted

  private static AppControl singleton

  Map<String,Counter>counters = new HashMap<String,Counter>()
  static hasMany = [counters: Counter]

  AppControl(){}

  static constraints = {
    name(unique:true)
    status()
    lastStarted(nullable:true)
    lastStarted()
  }

  /**
   * Only used for test resets
   */
  static void unInit(){ singleton = null }

  static Boolean firstBoot(){

    if (singleton==null){
      singleton = AppControl.findByName("singleton")
      if (singleton == null){
        singleton = new AppControl(name:"singleton")
        if (singleton == null){
          throw new RuntimeException("AppControl firstboot could not create new singleton")
        }
        singleton.lastStarted = new Date()
        singleton.status = "OK"
        if (!singleton.save(flush:true)) {
          singleton.errors.allErrors.each {
            println it
          }
          throw new RuntimeException("AppControl firstboot could not validate new singleton")
        }
        return true
      }
      return false
    }
  }


  static AppControl getSingleton(){return singleton}



  public Counter guaranteeCounter(String name){

    Counter counter = counters.get(name)
    if (counter == null){
      counter = Counter.findByName(name)
      counters.put(name,counter)
      if (counter == null){
        counter = new Counter([name:name,value:0])
        counters.put(name,counter)
      }
    }
    return counter
  }

  /**
   * Make sure counter does NOT exist (for test use only)
   * @param name
   */
  public void guaranteeNoCounter(String name){
    Counter counter = counters.get(name)
    if (counter == null){
      counter = Counter.findByName(name)
      counters.put(name,counter)
    }
    counter?.delete()
    counters.remove(name)
  }

  synchronized Long counterNext(String name){ return (guaranteeCounter(name)).next() }

  public String gensym(String name){ return "${name}:${counterNext(name)}"}

}
