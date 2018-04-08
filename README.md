# Thalia Tix Theatre Web Service
Ticketing RESTful web service software for a hypothetical theatre that provides the API for presenting to a client shows, seats and price options, processing ticket orders, recording ticket donations, and compiling budget reports for the theatre staff. 

Table of contents
=================

<!--ts-->
   * [Getting Started](#getting-started)
      * [Prerequisites](#prerequisites)
      * [Installation](#installation)
      * [Deployment](#deployment)
   * [Known Bugs](#known-bugs)
   * [Acknowledgements](#acknowledgements)
   * [License](#license)
<!--te-->


## Getting Started

#### Prerequisites

* OS: Ubuntu 16.04 or after
* [JRE](#install-jre)
* [Apache Tomcat 8.5](#install-tomcat-85)
* [Ant](#install-ant)

#### Installation

##### Install JRE
```
 sudo add-apt-repository ppa:webupd8team/java

 sudo apt-get update

 sudo apt-get install oracle-java8-installer

 sudo apt-get install oracle-java8-set-default

```

##### Install Tomcat 8.5
```
 cd ~/Downloads
 wget http://apache.claz.org/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.zip

 unzip apache-tomcat-8.5.23.zip

 sudo mv apache-tomcat-8.5.23 /opt/tomcat

 cd /opt/tomcat/bin

 chmod 744 *sh

```

##### Install Ant
`sudo apt-get install ant`

## Build and deploy instructions

##### Generate .war file
`git clone https://github.com/yanimihaylov/ThaliaTix.git`

--> enter project directory "ThaliaTix/Project"

`ant build testCases junitreport war`

#### Deployment
move .war to tomcat/webapps
`sudo mv thalia.war /opt/tomcat/webapps`

start server:

```
cd apache-tomcat-8.5.23.zip/bin

chmod 744 *sh

./startup.sh
```

## Known bugs

	1)	Please request     GET http://localhost:8080/thalia/thalia    before starting the project to build the theater seating.

	2)	Request auto seats has some bugs. It does not give 3 seats starting from the second seats.
	

	Jacoco code coverage file is included. Tests run with ANT build.

## Acknowledgements
* Professor Virgil Bistriceanu for providing us with all the guidence and API descriptions in his awesome Object Oriented Programming course at Illinois Institute of Technology
* Uncle Bob (Robert C. Martin) for the amazing Clean Code philosophy

## License
Apache license 2.0
