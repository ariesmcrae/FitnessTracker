# FitnessTracker
Demonstration of Spring Boot using REST, Jpa and Spring Data Jpa.

Branch jpa - contains jpa example
Branch master and SpringDataJpa - contain Spring Data Jpa example.

 

Request localhost:8080/goal 	POST
{ "minutes":30 }

Response
{
    "id": 1,
    "minutes": 30,
    "exercise": []
}



Request localhost:8080/goal 	POST
{ "minutes":40 }

Response
{
    "id": 2,
    "minutes": 40,
    "exercise": []
}



Request localhost:8080/goal/1/exercise		POST
{ 
  "activity":"Running",
  "minutes":50
}

Response
{
    "id": 1,
    "activity": "Running",
    "minutes": 50
}



Request localhost:8080/goal/1/exercise		POST
{ 
  "activity":"Swimming",
  "minutes":60
}

Response
{
    "id": 2,
    "activity": "Swimming",
    "minutes": 60
}




Request localhost:8080/goal/2/exercise 		POST
{ 
  "activity":"Cycling",
  "minutes":21
}

Response
{
    "id": 3,
    "activity": "Cycling",
    "minutes": 21
}



Request localhost:8080/goal 	GET
Response
[
    {
        "id": 1,
        "minutes": 30,
        "exercise": [
            {
                "id": 1,
                "activity": "Running",
                "minutes": 50
            },
            {
                "id": 2,
                "activity": "Swimming",
                "minutes": 60
            }
        ]
    },
    {
        "id": 2,
        "minutes": 40,
        "exercise": [
            {
                "id": 3,
                "activity": "Cycling",
                "minutes": 21
            }
        ]
    }
]



Request localhost:8080/goal/report 	GET
Response
[
    {
        "goalMinutes": 30,
        "exerciseMinutes": 50,
        "exerciseActivity": "Running"
    },
    {
        "goalMinutes": 30,
        "exerciseMinutes": 60,
        "exerciseActivity": "Swimming"
    },
    {
        "goalMinutes": 40,
        "exerciseMinutes": 21,
        "exerciseActivity": "Cycling"
    }
]