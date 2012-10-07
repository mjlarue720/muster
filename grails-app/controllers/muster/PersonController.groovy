package muster

class PersonController {
    static scaffold = true
    
    def login = {
            
        Map<String>parameters = params
        String userName, password
        String pairsString = parameters['id']
        pairsString.split("&").each {
          String pair = it
          String[] avPair = pair.split("=")
          String key = avPair[0]
          String value = avPair[1]
          if(key=="userName") {
            userName = value
          }
          else if(key=="pwd") {
              password = value
          }
            
        }
        
        println userName
        println password
        
        boolean isLoginValid = true
        
        render(contentType: "text/xml") {
            loginInfo{               
                isLoginSuccessful(isLoginValid)          
                uName(userName)               
            }
        }
    
    }
    
    
    
}
