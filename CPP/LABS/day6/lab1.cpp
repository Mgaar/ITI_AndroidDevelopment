#include <iostream>

enum class HTTP_ERR{
    Bad_Request =400,
    Not_Found =404,
    Server_Error=500,
    Gateway_Timeout=504
    // Add more HTTP error codes as needed

}; 
void print (HTTP_ERR err)
    {
        switch (err){
            case(HTTP_ERR::Bad_Request):std::cout<<"Bad_Request";break;
            case(HTTP_ERR::Not_Found):std::cout<<"Not_Found";break;
            case(HTTP_ERR::Server_Error):std::cout<<"Server_Error";break;
            case(HTTP_ERR::Gateway_Timeout):std::cout<<"Gateway_Timeout";break;
            // Add more cases as needed
            default: std::cout<<"Invalid HTTP Error Code"; break;

        }
    }



int main(){
    int x;
    std::cin>>x;
    HTTP_ERR err = static_cast<HTTP_ERR>(x);
    print(err);
    // Add error handling for invalid input

    return 0;
}

