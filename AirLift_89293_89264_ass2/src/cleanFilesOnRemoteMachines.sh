bold=$(tput bold)
normal=$(tput sgr0)

echo "----------------------------------------------------------"
echo "${bold}      AirLift Problem - Script Remote - Clean       ${normal}"
echo "----------------------------------------------------------"

export SSHPASS='sistemas2021'

echo -e "\n${bold}->${normal} A eliminar GeneralRepos da máquina ${bold}01${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws01.ua.pt << EOF
	rm -rf GeneralRepos
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters
EOF

echo -e "\n${bold}->${normal} A eliminar DepartureAirport da máquina ${bold}02${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws02.ua.pt << EOF
	rm -rf DepartureAirport
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters
	
EOF

echo -e "\n${bold}->${normal} A eliminar Plane da máquina ${bold}03${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws03.ua.pt << EOF
	rm -rf GeneralRepos
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters
EOF

echo -e "\n${bold}->${normal} A eliminar DestinationAirport da máquina ${bold}04${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws04.ua.pt << EOF
	rm -rf DestinationAirport
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters	
EOF

echo -e "\n${bold}->${normal} A eliminar Hostess da máquina ${bold}05${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws05.ua.pt << EOF
	rm -rf Hostess
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters
EOF

echo -e "\n${bold}->${normal} A eliminar Pilot da máquina ${bold}06${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws06.ua.pt << EOF
	rm -rf Pilot
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters	
EOF

echo -e "\n${bold}->${normal} A eliminar Passenger da máquina ${bold}07${normal}"
sshpass -e ssh -o StrictHostKeyChecking=no sd406@l040101-ws07.ua.pt << EOF
	rm -rf Passenger
	rm -rf commInfra
	rm -rf Communication
	rm -rf EntitiesState
	rm -rf SimulationParameters
EOF

