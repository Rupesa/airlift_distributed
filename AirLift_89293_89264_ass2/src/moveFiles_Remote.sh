bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}AirLift Problem - Script - Move files${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A mover GeneralRepos para a máquina ${bold}01${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState GeneralRepos sd406@l040101-ws01.ua.pt:/home/sd406
ssh sd406@l040101-ws01.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit
	
echo -e "\n${bold}->${normal} A mover DepartureAirport para a máquina ${bold}02${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs DepartureAirport sd406@l040101-ws02.ua.pt:/home/sd406
ssh sd406@l040101-ws02.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit

echo -e "\n${bold}->${normal} A mover Plane para a máquina ${bold}03${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs Plane sd406@l040101-ws03.ua.pt:/home/sd406
ssh sd406@l040101-ws03.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit
	
echo -e "\n${bold}->${normal} A mover DestinationAirport para a máquina ${bold}04${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs DestinationAirport sd406@l040101-ws04.ua.pt:/home/sd406
ssh sd406@l040101-ws04.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit
	
echo -e "\n${bold}->${normal} A mover Hostess para a máquina ${bold}05${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs Hostess sd406@l040101-ws05.ua.pt:/home/sd406
ssh sd406@l040101-ws05.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit

echo -e "\n${bold}->${normal} A mover Pilot para a máquina ${bold}03${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs Pilot sd406@l040101-ws06.ua.pt:/home/sd406
ssh sd406@l040101-ws06.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit
	
echo -e "\n${bold}->${normal} A mover Passenger para a máquina ${bold}07${normal}"
scp -r --include *.class Communication commInfra SimulationParameters EntitiesState Stubs Passenger sd406@l040101-ws07.ua.pt:/home/sd406
ssh sd406@l040101-ws07.ua.pt
cd /home/sd406
rm */*.java
rm */*/*.java
exit
