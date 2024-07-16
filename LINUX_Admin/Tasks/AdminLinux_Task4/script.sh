#!/bin/bash
read -p "enter user name:" username
read -p "enter family name -group-" group

var1=$(ls /etc/passwd | grep $username)
var2=$(ls /etc/group | grep $group)

if [ $var1 -z ] ;then 
sudo adduser $username ;
else 
echo "$username exists $var1" ;
fi

if [ $var2 -z ] ;then 
sudo groupadd $group
else 
echo "$group exists $var2"
fi

sudo usermod -aG $group $username 
