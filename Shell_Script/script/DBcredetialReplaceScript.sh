#!/bin/bash
#############This function takes the file name and value and search the value each line to get the exact key
getExactKey(){
Old_KEY=$1
file_base_new=$2
FINAL_KEY=
#if [ -f "$file_base_new" ]
#then
# . $file_base_new
#fi
  #while IFS='' read -r line || [[ -n "$line" ]]; do
#while read -r line ; do
  while IFS='' read -r line || [[ -n "$line" ]]; do
if [[ $line != \#* && $line == *$Old_KEY ]] ;then 
FINAL_KEY="$(cut -d'=' -f1 <<<"$line")"
#echo " Line---$line----Key---$FINAL_KEY"
#echo "$FINAL_KEY"
#echo $FINAL_KEY
break
#sh ./do_work.sh $line
fi 
 done < $file_base_new
  #echo "${VALUE}"
  #echo "$line"
  echo $FINAL_KEY
  
	
}

########This function basically execute the logic of how to change the value 
CallReplaceFunction(){
FILE=$1
FILE_BASE_FILE=$2
prop_key_URL=$3
prop_key_username=$4
prop_key_password=$5
#if [ -f "$FILE" ]
#then
# . $FILE
#fi 
#echo "::::test_prop_key_URL > $prop_key_URL::test_prop_key_username>$prop_key_username::test_prop_key_password>$prop_key_password::test_Old_dbIP>$Old_dbIP::test_Old_dbUser>$Old_dbUser::test_Old_DBPasword>$Old_DBPasword::test_New_dbIP>$New_dbIP::New_dbUser>$New_dbUser::test_New_DBPasword>$New_DBPasword::test_FILE>$FILE"
echo "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
 #prop_value=`cat ${FILE} | grep -P '^(?!#)${prop_key_URL}' | cut -d'=' -f2-`
 prop_value=`cat ${FILE} | grep -P '^(?!#)'${prop_key_URL}'' | cut -d'=' -f2-` 
#echo "URL>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" ${prop_value}
 if [ $prop_value == $Old_dbIP ] 
 then 
  #echo "Mandatory ::DB URL value >> Matched" 
	prop_value=`cat ${FILE} | grep -P '^(?!#)'${prop_key_username}'' | cut -d'=' -f2-`   
	#echo "USERNAME>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" ${prop_value}
	 if [ $prop_value == $Old_dbUser ] 
 		then 
  		 # echo "Mandatory ::DB User value >> Matched " 
		  prop_value=`cat ${FILE} | grep -P '^(?!#)'${prop_key_password}''  | cut -d'=' -f2-`
		  #echo "PASSWORD>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" ${prop_value}
		     if [[ "$prop_value" == "$Old_DBPasword" ]] 	
	    		 then 
			#echo "Mandatory ::DB Password value >> Matched" 
			FILE_COUNT=0
					if [ $New_dbIP != $Old_dbIP ]  
					then   
						FILE_COUNT=$((FILE_COUNT+1))  
					fi
					if [ $New_dbUser != $Old_dbUser ] 
					then  
						FILE_COUNT=$((FILE_COUNT+1))  
					fi
					if [ $New_DBPasword != $Old_DBPasword ]  
					then 
						FILE_COUNT=$((FILE_COUNT+1)) 
					fi
					if [ $FILE_COUNT -gt 0 ]; then 
					#echo "File cound is geather than zero ="$FILE_COUNT
						cp ${FILE}  $BK_UP_PATH 
					#else 
					#echo "File cound is zero ="$FILE_COUNT
					fi  
					if [ $New_dbIP != $Old_dbIP ] 
					then   		    	 
						sed -i 's+'"$Old_dbIP"'+'"$New_dbIP"'+g'  ${FILE} 
						echo "URL changed"
					#else
					#echo "no password changed"
	                fi

					if [ $New_dbUser != $Old_dbUser ] 
					then   		    	 	
						sed -i 's/'"$Old_dbUser"'/'"$New_dbUser"'/g' ${FILE}
						echo "User Name changed" 
					#else
					#echo "no password chnaged "
	                fi

					if [ $New_DBPasword != $Old_DBPasword ] 
					then   		    	
						sed -i 's+'"$Old_DBPasword"'+'"$New_DBPasword"'+g' ${FILE}
						echo "password changed"
					#else
						#echo "no password changed "					 
	                fi
					echo "******Updated KEY VALUE ***************** "
					grep $New_dbIP ${FILE}
					grep $New_dbUser ${FILE}
					grep $New_DBPasword ${FILE}
					echo "****************************************"	
				else 
				  echo "password $prop_value not maatched"                       
	           fi
		else
			echo "user name $prop_value not maatched" 
	  fi
	else 
		echo "URL $prop_value not maatched"
 fi
 }
#-----------Credential Change Script Start ---------------
echo "Execution start "  $(date +'%m/%d/%Y') "-" $( date +"%T")
file_base="./PasswordChangeInfo.properties"
input_file="./DirectoryList.properties"
if [ -f "$file_base" ]
then
    echo "$file_base found."
 . $file_base
if [ -f "$input_file" ]
then
    echo "$input_file found."
 . $input_file
echo "<<<<----------------------------OLD AND NEW DB INFO---------------------------------------------->>>>>"
echo "Execution server IP :: "$(hostname -I)
echo "USER::" $USER
echo "Old IP and Schema="$Old_dbIP "|New IP and Schema=" $New_dbIP
echo "Old User Name=" $Old_dbUser "|New User Name=" $New_dbUser
echo "Old Encrypted Password=" $Old_DBPasword "|New Encrypted Password=" $New_DBPasword
echo "......................................................................................................."
 while IFS='' read -r line || [[ -n "$line" ]]; do
    echo "$line"
echo "<<<<-----------------------------Individual Directory-------------------------------------------->>>>"
cd $line
echo "DB IP/user/password changing..."
######## after browse to the directoy it is iterating each properties file at the current location
for FILE_PROP in *.properties 
 do
 echo $FILE_PROP
#echo "<<<Start------Serach URL/Username/password key line by line------------------------>>>" 
prop_key_URL_key=$( getExactKey $Old_dbIP  $FILE_PROP)
prop_key_username_key=$( getExactKey $Old_dbUser  $FILE_PROP)
prop_key_password_key=$( getExactKey $Old_DBPasword  $FILE_PROP)
#echo "<<<END------Serach URL/Username/password key line by line------------------------>>>" 
#echo "::::prop_key_URL >"  $prop_key_URL"::prop_key_username>"$prop_key_username"::prop_key_password>"$prop_key_password"::Old_dbIP>"$Old_dbIP"::Old_dbUser>"$Old_dbUser"::Old_DBPasword>"$Old_DBPasword"::New_dbIP>"$New_dbIP"::New_dbUser>"$New_dbUser::"New_DBPasword>"$New_DBPasword"::FILE>"$FILE_PROP"
if [ "$prop_key_URL_key" != "" ] && [ "$prop_key_username_key" != "" ] && [ "$prop_key_password_key" != "" ]; then
   echo "Final URL_KEY-->${prop_key_URL_key}::USER_key-->${prop_key_username_key}::PASSWORD_key-->${prop_key_password_key}...."
   #echo " no key is empty so action taken......$FILE_PROP"
   CallReplaceFunction $FILE_PROP $file_base $prop_key_URL_key $prop_key_username_key $prop_key_password_key
   #CallReplaceFunction $FILE_PROP $prop_key_username_key $prop_key_password_key $Old_dbIP $Old_dbUser $Old_DBPasword $New_dbIP $New_dbUser $New_DBPasword $prop_key_URL_key
  else
 echo "Required value is not availble  URL_KEY-->${prop_key_URL_key}::USER_key-->${prop_key_username_key}::PASSWORD_key-->${prop_key_password_key}"
    
  fi
done

echo "done"
echo "last minutes updated file list:::: "
echo "file location:: " $PWD
find . -name "*.*" -mmin -0.50 -ls
#echo "<<<<\n End--------------------------DIRECTORY---------------------------------------------->>>>"


done < $input_file
else 
 echo "$input_file not found."
fi
else
    echo "$file_base not found."
fi
echo "Execution END "  "$(date +'%m/%d/%Y')" "-" "$( date +"%T")"
echo "EXIT ..."