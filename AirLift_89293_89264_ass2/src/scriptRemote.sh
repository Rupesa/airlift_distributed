bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}          AirLift Problem - Script Remote - Run        ${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A executar GeneralRepos na máquina ${bold}01${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws01.ua.pt << EOF
	cd GeneralRepos/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/GeneralRepos/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${bold}->${normal} A executar DepartureAirport na máquina ${bold}02${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws02.ua.pt << EOF
	cd DepartureAirport/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/DepartureAirport/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${bold}->${normal} A executar Plane na máquina ${bold}03${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws03.ua.pt << EOF
	cd Plane/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/Plane/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${bold}->${normal} A executar DestinationAirport na máquina ${bold}04${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws04.ua.pt << EOF
	cd DestinationAirport/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/DestinationAirport/java Main.MainProgram > /dev/null 2>&1 &
EOF

# Wait for the shared regions to be launched before lanching the intervening enities
sleep 1


echo -e "\n${bold}->${normal} A executar Hostess na máquina ${bold}05${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws05.ua.pt << EOF
	cd Hostess/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/Hostess/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${bold}->${normal} A executar Pilot na máquina ${bold}06${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws06.ua.pt << EOF
	cd Pilot/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/Pilot/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${bold}->${normal} A executar Passenger na máquina ${bold}07${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws07.ua.pt << EOF
	cd Passenger/Main/
	nohup java -cp ".:./genclass.jar" /home/sd406/Passenger/java Main.MainProgram > /dev/null 2>&1 &
EOF

echo -e "\n${normal}----------------------------------------------------------\n${normal}"
wait
echo -e "\n${normal}----------------------------------------------------------"

echo -e "\n${bold}>>>>>>>>>>${normal} A execução terminou"


