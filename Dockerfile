FROM openjdk:8
VOLUME /temp
EXPOSE 8091
ADD ./target/ms-CreditCard-bank-0.0.1-SNAPSHOT.jar creditcard-service.jar
ENTRYPOINT ["java","-jar","/creditcard-service.jar"]