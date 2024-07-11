if [[ -e ~/.bashrc ]];then 
echo "HELLO=$HOSTNAME" >> ~/.bashrc
echo "LOCAL=$(whoami)" >> ~/.bashrc
gnome-terminal &
fi
