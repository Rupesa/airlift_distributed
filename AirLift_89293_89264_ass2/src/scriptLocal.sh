bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}             AirLift Problem - Script Local               ${normal}"
echo "----------------------------------------------------------"

echo -e "\n${bold}>>>>> A parar todos os processos ativos ${normal}"
sudo kill -9 $(ps -ef | grep java | grep -v "netbeans" | awk '{ print $2 }')

### COMPILAR

echo -e "\n${bold}>>>>> Compilação do código em cada nó ${normal}"

echo -e "\n${bold}>${normal} A compilar EntitiesState"
cd EntitiesState/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Communication"
cd Communication/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Stubs"
cd Stubs/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar SimulationParameters"
cd SimulationParameters/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar GeneralRepos"
cd GeneralRepos/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar DepartureAirport"
cd DepartureAirport/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Plane"
cd Plane/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar DestinationAirport"
cd DestinationAirport/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Hostess"
cd Hostess/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Pilot"
cd Pilot/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Passenger"
cd Passenger/
javac -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

### EXECUTAR 

echo -e "\n${bold}>>>>> Execução do código em cada nó ${normal}"

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


