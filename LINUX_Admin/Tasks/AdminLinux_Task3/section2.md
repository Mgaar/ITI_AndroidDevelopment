# Section2
1. `ls /usr/bin >> /tmp/commands.list`

2.`echo $(date)`

3. to count words in a file

`wc -w pathtofile`

to count number of files in directory 

`ls /usr/bin | wc -l`

4.

a.will print file2 on terminal

b.this 'll cause error and it won't delete the files in directory 

c-since /etc/passwd is not a directory ls will just print /etc/passwd and pipe that to wc -l which counts lines and print 1 to terminal since it is a single line 

5.`locate .profile`

6. `ls -li /` `ls -li /etc`  `ls -li /etc/hosts`

7. `ln -s /etc/passwd /boot`

8.   if tried `ln  /etc/passwd /boot`

will not be able to create a hardlink because there is already a soft link 

9.this is secondary prompt (PS2) This prompt appears when the shell expects more input to complete a command that spans multiple lines.

to channge it we edit the .bashrc `PS2=':'`

