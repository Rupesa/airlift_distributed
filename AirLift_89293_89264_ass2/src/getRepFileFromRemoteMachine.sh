bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}      AirLift Problem - Script Remote - Get rep.txt       ${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A obter o ficheiro rep.txt da máquina ${bold}01${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws01.ua.pt << !
	get -r rep.txt
	bye
!
