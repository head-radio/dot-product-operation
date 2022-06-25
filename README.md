# Spring boot dot product operation

The projects contain the dot product implementation between 2 array. This operation is used in computer graphics.

More information about the dot product can be found at
<https://en.wikipedia.org/wiki/Dot_product>

## Download
### Using The Command Line
1. Press the Clone or download button in the top right
2. Copy the URL (link)
3. Open the command line and change directory to where you wish to clone to
4. Type 'git clone' followed by URL in step 2
```bash
$ git clone https://github.com/[user-name]/[repository]
```

### Download Zip File

1. Download this GitHub repository
2. Extract the zip archive
3. Copy/ move to the desired location


## Language information
### Built for
This project is a spring boot based application, written in Java 11 and spring version 2.7.0.

### Principal Dependencies
- spring-boot-starter-web 
- spring-boot-starter-test

Quick start
-----------
`mvn spring-boot:run`

### cURL for testing
- curl -v --location --request POST 'http://localhost:8080/dot-product' --header 'Content-Type: application/json' --data-raw '{"arrayA":[1,2,3],"arrayB":[1,2,3]}'
- curl --location --request POST 'http://localhost:8080/dot-product/list' --header 'Content-Type: application/json' --data-raw '{"list":[[1,2,3],[1,2,3]]}'

## Licence
AP License
Copyright
