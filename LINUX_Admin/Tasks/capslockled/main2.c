#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    char buf[1];
    int fd;
fd=open("var",O_RDONLY);
read(fd,buf,1);
buf[0]=buf[0]=='0'?'1':'0';
int fd2 =open("/sys/class/leds/input10::capslock/brightness",O_WRONLY);
write(fd2,buf,1);
    return 0;
}
