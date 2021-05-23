bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}AirLift Problem - Script - Run (Remote) ${normal}"
echo "----------------------------------------------------------"

echo -e "\n${bold}->${normal} A executar GeneralRepos na máquina ${bold}01${normal}"
sshpass -f password.txt ssh sd406@l040101-ws01.ua.pt 'java -cp ".:./genclass.jar" GeneralRepos/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar DepartureAirport na máquina ${bold}02${normal}"
sshpass -f password.txt ssh sd406@l040101-ws02.ua.pt 'java -cp ".:./genclass.jar" DepartureAirport/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar Plane na máquina ${bold}03${normal}"
sshpass -f password.txt ssh sd406@l040101-ws03.ua.pt 'java -cp ".:./genclass.jar" Plane/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar DestinationAirport na máquina ${bold}04${normal}"
sshpass -f password.txt ssh sd406@l040101-ws04.ua.pt 'java -cp ".:./genclass.jar" DestinationAirport/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar Hostess na máquina ${bold}05${normal}"
sshpass -f password.txt ssh sd406@l040101-ws05.ua.pt 'java -cp ".:./genclass.jar" Hostess/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar Pilot na máquina ${bold}06${normal}"
sshpass -f password.txt ssh sd406@l040101-ws06.ua.pt 'java -cp ".:./genclass.jar" Pilot/Main/MainProgram &'&

echo -e "\n${bold}->${normal} A executar Passenger na máquina ${bold}07${normal}"
sshpass -f password.txt ssh sd406@l040101-ws07.ua.pt 'java -cp ".:./genclass.jar" Passenger/Main/MainProgram &'&

echo -e "\n${normal}----------------------------------------------------------\n${normal}"
wait
echo -e "\n${normal}----------------------------------------------------------"

echo -e "\n${bold}>>>>>>>>>>${normal} A execução terminou"
