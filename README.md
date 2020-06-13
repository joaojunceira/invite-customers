# Invite Customers

The solution was built using Kotlin and JDK 11.

## How to run:

Install the JDK and Gradle
1. [Install JDK 11](https://adoptopenjdk.net)
2. [Install Gradle 6](https://gradle.org/install/)
3. Build the application `./gradlew build`
4. Running Tests `./gradlew test`
5. Executing Application `java -jar invite-customers-1.0-SNAPSHOT.jar <Origin File> <Output File> <Latitude> <Longitude> <Range>`

## Architecture of Solution

Solution is Command Line App structured into a Model-View-Controller Architecture.

|-----------------------|

| Model-View-Controller |

|-----------------------|

|       Services        |

|-----------------------|
