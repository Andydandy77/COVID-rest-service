# COVID-rest-service

Currently this REST api is able to return all personal information records, and find a personal information record by last name and first name
When the server starts, all personal information records are cached in both a HashMap and an ArrayList.

Whenever a GET response tries to find a personal information record by name, it first looks at either cache first.

I was unable to create working junit tests in time, but using Postman, I was able to verify that this request works. 
There are two GET methods to find by name: 
```
"/person/find/map/{lname}+{fname}"
"/person/find/list/{lname}+{fname}"
```

The first one first searches the HashMap, and the second first searches the ArrayList.

Each of these methods also track the time it takes to find the record in its respective data structure (map or list).

After running ```"http://localhost:9191/person/find/list/Fellini+Abbie"``` in Postman it returns:

```
{
    "lname": "Fellini",
    "fname": "Abbie",
    "ethnicity": "Cree",
    "sex": "Male",
    "dob": "2009-03-02T13:43:58.000+00:00",
    "street": "378 Jana Pass",
    "city": "Youngstown",
    "state": "Ohio",
    "zipCode": "18211",
    "phone": "330-239-6027",
    "peopleId": 2
}
```

And in the terminal it prints:
```Time to hit ArrayList: 207778.0 nanoseconds```

After running ```"http://localhost:9191/person/find/list/Fellini+Abbie"``` in Postman it returns the same json but in the terminal prints:
```Time to hit HashMap: 61981.0 nanoseconds```

Clearly the HashMap is a more efficient way to cache recently accessed data. It would be more apparent the greater the number of records, but I know that the
worst case time complexity of the HashMap is O(1) and for the ArrayList it is O(N).




