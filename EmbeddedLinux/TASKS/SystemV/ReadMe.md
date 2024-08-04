task add a deamon task to be started on run level and gets killed in another level 

to achieve that first we need to create our daemon script 

```
#!/bin/sh

while true; do
    echo "Hello from daemon!" > /tmp/hidaemon.txt
    sleep 60
done

```

and the script must be executable `chmod +x hidaemon.sh`

![Screenshot from 2024-08-05 00-33-35](https://github.com/user-attachments/assets/6d7b41de-e9f3-4dcc-9999-3a1f54ba7663)

then we need to create script on init.d that starts and kills this process 

```
#! /bin/sh
case "$1" in
      start)
           echo "Starting deamonapp........."
           start-stop-daemon -S -n deamonapp -a /bin/hideamon.sh &
           ;;
     stop)
           echo "Stopping deamonapp........."
           start-stop-daemon -K -n hidaemon.sh
           ;;
     *)
           echo "Usage: $0 {start|stop}"
           exit 1
esac
exit 0

```

also it must be excutable 

![Screenshot from 2024-08-05 00-43-32](https://github.com/user-attachments/assets/c80d631e-b8f9-46ec-94e2-98368f446ab5)

then we need to craete the run level directories and soft link to this script one to kill other to start 

![Screenshot from 2024-08-05 00-52-32](https://github.com/user-attachments/assets/73f5d3ec-6e5d-442e-830a-886d317818c3)

then we need the rc script which will parse these directories and call the script to kill or start depending on the runlevel we are on 

```
#!/bin/sh
# Check if one argument is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <runlevel>"
    exit 1
fi
# Define the folder path based on the argument
folder="rc$1.d"
# Kill scripts starting with K
for i in /etc/$folder/K??* ;do
     # Ignore dangling symlinks (if any).
     [ ! -f "$i" ] && continue
     case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set stop
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i stop
            ;;
    esac
done
# Start scripts starting with S
for i in /etc/$folder/S??* ;do
     # Ignore dangling symlinks (if any).
     [ ! -f "$i" ] && continue
     case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set start
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i start
            ;;
    esac
done
```

 also must be executable 

 last thing we need to edit inittab to execute the rc script when we change run level 

 ![Screenshot from 2024-08-05 01-04-29](https://github.com/user-attachments/assets/2e886f5a-bb8f-47da-ac4f-b6e50c5a8e7c)

so when we run init 2 starts the process and when init 3 it gets killed  

![Screenshot from 2024-08-05 01-46-09](https://github.com/user-attachments/assets/36ea974c-0c13-4f18-bee1-9abb72107de3)

 
