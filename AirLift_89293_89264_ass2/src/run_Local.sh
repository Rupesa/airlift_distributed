bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}AirLift Problem - Script - Run (Local)${normal}"
echo "----------------------------------------------------------"

echo -e "\n${bold}A parar todos os processos ativos ${normal}"
sudo kill -9 $(ps -ef | grep java | grep -v "netbeans" | awk '{ print $2 }')

echo -e "\n${bold}>${normal} A executar GeneralRepos"
java -cp ".:./genclass.jar" GeneralRepos/Main/MainProgram &

echo -e "\n${bold}>${normal} A executar DepartureAirport"
java -cp ".:./genclass.jar" DepartureAirport/Main/MainProgram &

echo -e "\n${bold}>${normal} A executar Plane"
java -cp ".:./genclass.jar" Plane/Main/MainProgram &

echo -e "\n${bold}>${normal} A executar DestinationAirport"
java -cp ".:./genclass.jar" DestinationAirport/Main/MainProgram &

# Wait for the shared regions to be launched before lanching the intervening enities
sleep 1

echo -e "\n${bold}>${normal} A executar Hostess"
java -cp ".:./genclass.jar" Hostess/Main/MainProgram &

echo -e "\n${bold}>${normal} A executar Pilot"
java -cp ".:./genclass.jar" Pilot/Main/MainProgram &

echo -e "\n${bold}>${normal} A executar Passenger"
java -cp ".:./genclass.jar" Passenger/Main/MainProgram &

echo -e "\n${normal}----------------------------------------------------------\n${normal}"

wait
echo -e "\n${normal}----------------------------------------------------------"

echo -e "\n${bold}>>>>>>>>>>${normal} A execução terminou"


