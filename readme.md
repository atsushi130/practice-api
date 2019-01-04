<p align="center">
    <h1 align="center">practice-api</h1>
</p1>

<p align="center"><i>practice-api is practice service for practice-ios</i></p>

<p align="center">
    <a href=".license-mit"><img src="https://img.shields.io/badge/license-MIT-blue.svg"></a> 
</p>

## Bootstrap
```
❯ git clone https://github.com/atsushi130/practice-api
❯ cd practice-api
❯ docker-compose up --build
```

## Create user
```
❯ curl localhost:8080/sign_up POST\
-H "OS: iOS"\
-H "OSVersion: 12.0.0"\
-H "AppVersion: 1.0.0"\
-H "Content-Type: application/json"\
-d '{ "userId": "atsushi130", "password": "password" }'
```
response
```
{
  "sessionId": "5755BECA-1A85-4714-AF0C-4ECE06E5BE16",
  "userId": "atsushi130"
}
```

## Get Latest Items
```
❯ curl localhost:8080/latest_items GET\
-H "Cookie: sessionId=5755BECA-1A85-4714-AF0C-4ECE06E5BE16"\
-H "OS: iOS"\
-H "OSVersion: 12.0.0"\
-H "AppVersion: 1.0.0"
```
response
```
[
  {
    "id": 1,
    "name": "NOMOS",
    "subName": "NOMOS Metro wristwatch",
    "registeredUserId": "atsushi130",
    "wants": {
      "state": false,
      "count": 2
    },
    "haves": {
      "state": false,
      "count": 1
    }
  }
]
```

## Framework
- spring-boot

## Architecture
- CleanArchitecture

## License
practice-api is available under the MIT license. See the [LICENSE file](https://github.com/atsushi130/practice-api/blob/master/license).
