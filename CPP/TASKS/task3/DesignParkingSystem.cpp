class ParkingSystem {
    private :
    int big ;
    int meduim;
    int small;
public:
    ParkingSystem(int bigx=0, int mediumx=0, int smallx=0) :big{bigx},meduim{mediumx},small{smallx}{
        
    }
    
    bool addCar(int carType) {
        switch (carType){
            case 1:
            big--;
            if (this->big>=0)
            return true;
            else 
            return false;
            break;
             case 2:
             meduim--;
            if (this->meduim>=0)
            return true;
            else 
            return false;
            break;
            case 3:
            small--;
            if (this->small>=0)
            return true;
            else 
            return false;
            break;
            default :return false;

        }
    }
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */
