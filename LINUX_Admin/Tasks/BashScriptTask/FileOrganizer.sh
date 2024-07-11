read -p "Enter path of directory to organize :" dir



files=$(ls $dir)

mkdir $dir/Images
mkdir $dir/Documents
mkdir $dir/Others

for file in $files ; do 
if [[ $file = *.jpg || $file = *.png || $file = *.gif ]];then
mv $dir/$file $dir/Images/$file
elif [[ $file = *.txt || $file = *.doc || $file = *.pdf ]];then
mv $dir/$file $dir/Documents/$file
elif ! [[ -d $dir/$file ]];then
mv $dir/$file $dir/Others/$file
else 
:
fi

done




