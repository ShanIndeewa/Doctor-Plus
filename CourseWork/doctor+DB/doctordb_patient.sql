-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: doctordb
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` varchar(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('P001','Nuwan','Wijesinghe','1985-05-12','Male','0771234567','nuwan.w@gmail.com','No 12, Galle Road, Colombo'),('P002','Kumari','Rajapaksha','1990-03-28','Female','0772345678','kumari.r@gmail.com','No 45, Main Street, Kandy'),('P003','Asela','Perera','1988-07-15','Male','0773456789','asela.p@gmail.com','No 100, Temple Road, Galle'),('P004','Lakmini','Jayawardena','1992-11-23','Female','0774567890','lakmini.j@gmail.com','No 23, Lake Side, Nuwara Eliya'),('P005','Samantha','Weerasinghe','1980-01-10','Male','0775678901','samantha.w@gmail.com','No 78, High Level Road, Kotte'),('P006','Dilshan','Fernando','1995-04-18','Male','0776789012','dilshan.f@gmail.com','No 54, Beach Road, Negombo'),('P007','Chathuri','Gunawardena','1993-08-07','Female','0777890123','chathuri.g@gmail.com','No 66, Park Road, Matara'),('P008','Kasun','Silva','1989-12-30','Male','0778901234','kasun.s@gmail.com','No 5, De Silva Road, Kurunegala'),('P009','Harsha','Dias','1986-02-14','Male','0779012345','harsha.d@gmail.com','No 2, Station Road, Anuradhapura'),('P010','Shanika','Ekanayake','1994-06-25','Female','0770123456','shanika.e@gmail.com','No 20, Flower Road, Jaffna'),('P011','Nadeeka','Senanayake','1983-09-19','Female','0771231234','nadeeka.s@gmail.com','No 10, College Avenue, Badulla'),('P012','Tharindu','Bandara','1991-03-05','Male','0772342345','tharindu.b@gmail.com','No 3, Hill Street, Ratnapura'),('P013','Iresha','Dissanayake','1996-10-01','Female','0773453456','iresha.d@gmail.com','No 7, Mountain Road, Kegalle'),('P014','Ruwan','Ranasinghe','1984-07-23','Male','0774564567','ruwan.r@gmail.com','No 88, Coconut Garden, Kalutara'),('P015','Pavithra','Samarasinghe','1990-02-11','Female','0775675678','pavithra.s@gmail.com','No 15, Green Lane, Gampaha'),('P016','Dilan','Ratnayake','1987-06-09','Male','0776786789','dilan.r@gmail.com','No 50, Railway Avenue, Trincomalee'),('P017','Anusha','Karunaratne','1992-08-30','Female','0777897890','anusha.k@gmail.com','No 99, King Street, Hambantota'),('P018','Suresh','Rathnayake','1981-12-15','Male','0778908901','suresh.r@gmail.com','No 25, Sea View, Batticaloa'),('P019','Dilini','Amarasinghe','1995-04-27','Female','0779019012','dilini.a@gmail.com','No 6, River Side, Puttalam'),('P020','Janaka','Herath','1988-11-18','Male','0770120123','janaka.h@gmail.com','No 44, Lake View, Mannar'),('P021','Shashika','Wickramasinghe','1993-05-13','Female','0771236789','shashika.w@gmail.com','No 11, Field Road, Vavuniya'),('P022','Madhawa','Goonetilleke','1989-09-07','Male','0772347890','madhawa.g@gmail.com','No 75, Hill View, Monaragala'),('P023','Nilmini','Liyanage','1990-06-21','Female','0773458901','nilmini.l@gmail.com','No 40, Station Avenue, Kilinochchi'),('P024','Pradeep','Munasinghe','1986-01-30','Male','0774569012','pradeep.m@gmail.com','No 85, New Road, Ampara'),('P025','Gayathri','Edirisinghe','1994-03-17','Female','0775670123','gayathri.e@gmail.com','No 13, Forest Lane, Polonnaruwa'),('P026','Shan','Indeewa','2024-08-19','Male','0789532648','shan@gmail.com','pilana rd,pinnaduwa,galle'),('P027','Devika','samaranayake','2024-08-12','Female','0245897631','qyuygefgwfh','abcnoiaiuhuqw'),('P028','Sekara','ranathunga','2024-08-27','Male','4567891302','gweybfwev','tkutyukkeryh'),('P029','Sekara','ranathunga','2024-08-27','Male','4567891302','gweybfwev','tkutyukkeryh'),('P030','Senarath','Benthota','2024-09-12','Male','0123546879','senarath@gmail.com','qfygyuqgfygqfyf'),('P031','ft7ir6i','r7i6i7r6','2024-09-30','Other','ir67i','rii76','tcdtkxrsts44555'),('P032','senarath','dunusinghe','2024-08-06','Male','0124578963','sene@gmail.com','gampaha'),('P033','demon','kulasooriya','2024-08-07','Male','4567890123','skksk','suuddd'),('P034','sriyani','ranasinghe','2024-09-13','Male','0123456789','sriyani@gmail.com','102,demon street,colombo.'),('P035','dsgrrag','argreh','2024-08-14','Male','456987','asgag','agarg');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-31 23:45:08
