# FitnessTracker
Demonstration of Spring Boot using REST, Jpa and Spring Data Jpa.

Branch jpa - contains jpa example
Branch master and SpringDataJpa - contain Spring Data Jpa example.

 

`Request localhost:8080/goal 	POST`
<pre>
{ "minutes":30 }
</pre>

`Response`
<pre>
{
    "id": 1,
    "minutes": 30,
    "exercise": []
}
</pre>



`Request localhost:8080/goal 	POST`
<pre>
{ "minutes":40 }
</pre>

`Response`
<pre>
{
    "id": 2,
    "minutes": 40,
    "exercise": []
}
</pre>


`Request localhost:8080/goal/1/exercise		POST`
<pre>
{ 
  "activity":"Running",
  "minutes":50
}
</pre>

`Response`
<pre>
{
    "id": 1,
    "activity": "Running",
    "minutes": 50
}
</pre>


`Request localhost:8080/goal/1/exercise		POST`
<pre>
{ 
  "activity":"Swimming",
  "minutes":60
}
</pre>

`Response`
<pre>
{
    "id": 2,
    "activity": "Swimming",
    "minutes": 60
}
</pre>



`Request localhost:8080/goal/2/exercise 		POST`
<pre>
{ 
  "activity":"Cycling",
  "minutes":21
}
</pre>

`Response`
<pre>
{
    "id": 3,
    "activity": "Cycling",
    "minutes": 21
}
</pre>


`Request localhost:8080/goal 	GET`
`Response`
<pre>
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
</pre>



`Request localhost:8080/goal/report 	GET`
`Response`
<pre>
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
</pre>