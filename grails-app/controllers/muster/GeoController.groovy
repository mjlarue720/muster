package muster

class GeoController {

    def index() { }
    
    def geoView = {
        
        String address = "12744 San Fernando Road, Sylmar, CA"
        String coord = Util.geoCode(address)
        return [coord: coord]
    }
}
