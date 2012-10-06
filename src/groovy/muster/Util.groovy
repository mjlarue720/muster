package alpha

import groovy.json.JsonSlurper
/**
 * Created with IntelliJ IDEA.
 * User: gvamos
 * Date: 9/8/12
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
class Util {

  /**
   * Execute a shell command and return the output
   * @param command shell command
   * @return command stdout output
   */
  public static String execute(String command){
    Process proc = command.execute()
    proc.waitFor()
    return proc.getText()
  }

  /**
   * Execute a shell pipe command on input data and return the output
   * @param command shell command
   * @param data input data
   * @return command stdout output
   */
  public static String executePipe(String command, String data){
    Process proc = command.execute()
    PrintWriter writer = new PrintWriter(new BufferedOutputStream(proc.out))
    writer.println(data)
    writer.close()
    proc.waitFor()
    return proc.getText()
  }
  
  public static String geoCode(String address) {
      
    String googleMapApiBase = "http://maps.googleapis.com/maps/api/geocode/json?address="    
    String googleMapApiSensorComponent = "&sensor=false"
    String path = googleMapApiBase + address.replace(" ", "+") + googleMapApiSensorComponent
    URL url = new URL(path)
    JsonSlurper jsonSlurper = new JsonSlurper()
    def result = jsonSlurper.parseText(url.getText())
    print result.results.geometry.location
    return result.results.geometry.location    
        
  }
    
  
}
