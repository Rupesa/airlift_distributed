bold=$(tput bold)
normal=$(tput sgr0)
echo "${bold}*** Script Local ***${normal}"

###

echo -e "\n${bold}* Copiar parâmetros de simulação *${normal}"
# cp SimulationParameters/local_SimulationParameters.java BettingCenter/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Broker/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java ControlCenter/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Horses/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Logger/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Paddock/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java RacingTrack/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Spectators/src/main/java/MainPackage/SimulationParameters.java
# cp SimulationParameters/local_SimulationParameters.java Stable/src/main/java/MainPackage/SimulationParameters.java


###

echo -e "\n${bold}* Compilação do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A compilar GeneralRepos"
cd GeneralRepos/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar DepartureAirport"
cd DepartureAirport/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar Plane"
cd Plane/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar DestinationAirport"
cd DestinationAirport/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar Hostess"
cd Hostess/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar Pilot"
cd Pilot/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}->${normal} A compilar Passenger"
cd Passenger/
javac -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..


###

echo -e "\n${bold}* Execução do código em cada nó *${normal}"

echo -e "\n${bold}->${normal} A executar GeneralRepos"
# cd GeneralRepos/Main/
# java -cp $(pwd) MainProgram &
java -cp ".:./genclass.jar" GeneralRepos/Main/MainProgram
cd ../..

echo -e "\n${bold}->${normal} A executar DepartureAirport"
# cd DepartureAirport/Main/
# java -cp $(pwd) MainProgram &
java -cp ".:./genclass.jar" DepartureAirport/Main/MainProgram
cd ../..

echo -e "\n${bold}->${normal} A executar Plane"
# cd Plane/Main/
# java -cp $(pwd) MainProgram &
java -cp ".:./genclass.jar" Plane/Main/MainProgram
cd ../..

echo -e "\n${bold}->${normal} A executar DestinationAirport"
# cd DestinationAirport/Main/
# java -cp $(pwd) MainProgram &
java -cp ".:./genclass.jar" DestinationAirport/Main/MainProgram
cd ../..


# Wait for the shared regions to be launched before lanching the intervening enities

sleep 1

echo -e "\n${bold}->${normal} A executar Hostess"
cd Hostess/Main/
java -cp $(pwd) MainProgram &
cd ../..

echo -e "\n${bold}->${normal} A executar Pilot"
cd Pilot/Main/
java -cp $(pwd) MainProgram &
cd ../..

echo -e "\n${bold}->${normal} A executar Passenger"
cd Passenger/Main/
java -cp $(pwd) MainProgram &
cd ../..

wait

echo -e "\n${bold}->${normal} A execução terminou"

