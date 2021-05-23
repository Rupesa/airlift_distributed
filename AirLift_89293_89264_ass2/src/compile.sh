bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}AirLift Problem - Script - Compile${normal}"
echo "----------------------------------------------------------"

echo -e "\n${bold}>${normal} A compilar EntitiesState"
cd EntitiesState/
javac --release 8 -classpath ../genclass.jar ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Communication"
cd Communication/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Stubs"
cd Stubs/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar SimulationParameters"
cd SimulationParameters/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar GeneralRepos"
cd GeneralRepos/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar DepartureAirport"
cd DepartureAirport/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Plane"
cd Plane/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar DestinationAirport"
cd DestinationAirport/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Hostess"
cd Hostess/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Pilot"
cd Pilot/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

echo -e "\n${bold}>${normal} A compilar Passenger"
cd Passenger/
javac --release 8 -classpath ../genclass.jar:.. ../commInfra/*.java $(find . -name '*.java')
cd ..

