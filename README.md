Based off of 
https://spring.io/quickstart


## Run locally

```
./mvnw spring-boot:run
```


## Build

```
./mvnw clean install
```

Creates demo-0.0.1-SNAPSHOT.jar

## Deploy - CI

Codepipeline is setup to automatically deploy on merge to main branch

https://us-east-2.console.aws.amazon.com/codesuite/codepipeline/pipelines/spring-boot-demo-dev/view?region=us-east-2


## Deploy - local

export AWS_PROFILE=admin-user

Install EB CLI locally:
https://github.com/aws/aws-elastic-beanstalk-cli-setup

Already created the environment:
https://exampledriven.wordpress.com/2017/01/09/spring-boot-aws-elastic-beanstalk-example/

```
./mvnw install
eb deploy
```

## URLs

| ENVIRONMENT | URL  |
| :---------: | :--: |
|    PROD     | http://spring-boot-demo-dev.us-east-2.elasticbeanstalk.com/hello |

https://us-east-2.console.aws.amazon.com/elasticbeanstalk/home?region=us-east-2#/environment/dashboard?applicationName=spring-boot-demo&environmentId=e-pqarxkymyc
