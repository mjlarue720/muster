import java.util.logging.Logger
import muster.AppControl

class BootStrap {


  //private static Logger log = (Logger)Logger.getInstance(alpha.AppControl)

  def init = { servletContext ->

    if(AppControl.firstBoot()){
      //log.info("Alpha bootrap: new start ${new Date()}")
      println("Alpha bootrap: new start ${new Date()}")
      AppControl appControl = AppControl.getSingleton()
      appControl.guaranteeCounter("starts")
    }
    //log.info("Alpha bootrap: startup complete ${new Date()}")
    AppControl appControl = AppControl.getSingleton()
    Long startCount = appControl.counterNext("starts")
    println("Alpha bootrap: startup ${startCount} complete ${new Date()}")
  }



  def destroy = {
  }
}
