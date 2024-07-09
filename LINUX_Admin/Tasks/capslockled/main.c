#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main ()
{
    char buf[1];
    int fd;
    fd =open("/sys/class/leds/input10::capslock/brightness",O_RDONLY);
    read(fd,buf,1);
    int fd2;
    fd2=open("var", O_WRONLY);
    write(fd2,buf,1);
    return 0;
}
