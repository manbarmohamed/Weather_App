CREATE DATABASE Weather_App;
USE Weather_App;

create table City(
		cityId int primary key,
        cityName varchar(255),
        currentTemperature int
        );
       
create table CityHistory(
		historicalDataId int primary key,
        temperature int,
        eventDate date,
        cityId int,
        foreign key  (cityId) references City(cityId)
        );
        
         INSERT INTO City VALUES (1,"casablanca",32);
        INSERT INTO CityHistory VALUES (1,32,'2024-11-11',1);
        select * from City;
        select * from CityHistory;
        
        
         alter table City 
        add currentHumidity int;
        alter table City 
        add currentWindSpeed int;
        
        UPDATE `weather_app`.`City` SET `currentHumidity` = '20', `currentWindSpeed` = '75' WHERE (`cityId` = '1');

        

	