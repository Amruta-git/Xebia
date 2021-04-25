# Xebia


Please use below commands to Run the application

--To save Participants
 curl -d '{"name":"Participant 1","email":"test@gmail.in"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/tabletennis/participants

-- To get all Participants
 curl -H 'Content-Type: application/json' -X GET http://localhost:8080/tabletennis/getAllParticipants
