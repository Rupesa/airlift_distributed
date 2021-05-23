bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}      AirLift Problem - Script Remote - Code       ${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A mover GeneralRepos para a máquina ${bold}01${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws01.ua.pt << !
	put -r GeneralRepos/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover DepartureAirport para a máquina ${bold}02${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws02.ua.pt << !
	put -r DepartureAirport/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover Plane para a máquina ${bold}03${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws03.ua.pt << !
	put -r Plane/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover DestinationAirport para a máquina ${bold}04${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws04.ua.pt << !
	put -r DestinationAirport/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover Hostess para a máquina ${bold}05${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws05.ua.pt << !
	put -r Hostess/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover Pilot para a máquina ${bold}06${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws06.ua.pt << !
	put -r Pilot/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!

echo -e "\n${bold}->${normal} A mover Passenger para a máquina ${bold}07${normal}"
sshpass -e sftp -o StrictHostKeyChecking=no sd406@l040101-ws07.ua.pt << !
	put -r Passenger/
	put -r commInfra/
	put -r Communication/
	put -r EntitiesState/
	put -r SimulationParameters/
	bye
!
