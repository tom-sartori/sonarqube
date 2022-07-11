# sonarqube container

## Build and start
```shell
docker-compose up --build --force-recreate -d
```

## Login
`admin/admin` for sonarqube and jenkins.  
N.B. : At the beginning, sonarqube ask for a new password. Don't forget to put back `admin/admin` after. 

## Hosts
- [Sonarqube](http://sonarqube.localdomain:9000)  
- [Jenkins](http://localhost:8080)

## Jenkins 
Add jobs contained `jenkins/jobs` in the jenkins server. Don't forget to set up parameters. 
