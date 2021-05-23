bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}AirLift Problem - Script - Clean${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A eliminar GeneralRepos na máquina ${bold}01${normal}"
ssh sd406@l040101-ws01.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters GeneralRepos 
exit

echo -e "\n${bold}->${normal} A eliminar DepartureAirport na máquina ${bold}02${normal}"
ssh sd406@l040101-ws02.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs DepartureAirport 
exit
	
echo -e "\n${bold}->${normal} A eliminar Plane na máquina ${bold}03${normal}"
ssh sd406@l040101-ws03.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs Plane 
exit

echo -e "\n${bold}->${normal} A eliminar DepartureAirport na máquina ${bold}04${normal}"
ssh sd406@l040101-ws04.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs DestinationAirport 
exit

echo -e "\n${bold}->${normal} A eliminar Hostess na máquina ${bold}05${normal}"
ssh sd406@l040101-ws05.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs Hostess 
exit
	
echo -e "\n${bold}->${normal} A eliminar Pilot na máquina ${bold}06${normal}"
ssh sd406@l040101-ws06.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs Pilot 
exit

echo -e "\n${bold}->${normal} A eliminar Passenger na máquina ${bold}07${normal}"
ssh sd406@l040101-ws07.ua.pt
cd /home/sd406
rm -r Communication commInfra EntitiesState SimulationParameters Stubs Passenger 
exit
