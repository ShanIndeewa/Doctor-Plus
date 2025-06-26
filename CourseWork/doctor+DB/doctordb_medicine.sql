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
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `dosage` varchar(10) NOT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES ('MED001','Paracetamol','Used to treat pain and fever.','500mg'),('MED002','Ibuprofen','Non-steroidal anti-inflammatory drug (NSAID) used to reduce fever and treat pain or inflammation.','200mg'),('MED003','Aspirin','Used to reduce pain, fever, or inflammation.','300mg'),('MED004','Amoxicillin','Antibiotic used to treat various bacterial infections.','500mg'),('MED005','Ciprofloxacin','Antibiotic used to treat a variety of bacterial infections.','250mg'),('MED006','Metformin','Used to control high blood sugar in people with type 2 diabetes.','500mg'),('MED007','Atorvastatin','Used to lower cholesterol and triglyceride levels.','10mg'),('MED008','Lisinopril','Used to treat high blood pressure and heart failure.','10mg'),('MED009','Omeprazole','Proton pump inhibitor used to treat gastroesophageal reflux disease (GERD).','20mg'),('MED010','Losartan','Used to treat high blood pressure and to protect the kidneys from damage due to diabetes.','50mg'),('MED011','Amlodipine','Used to treat high blood pressure and chest pain (angina).','5mg'),('MED012','Levothyroxine','Used to treat an underactive thyroid (hypothyroidism).','50mcg'),('MED013','Clopidogrel','Used to prevent heart attacks and strokes in persons with heart disease.','75mg'),('MED014','Simvastatin','Used to lower cholesterol and triglyceride levels in the blood.','20mg'),('MED015','Azithromycin','Antibiotic used to treat various bacterial infections.','500mg'),('MED016','Hydrochlorothiazide','Used to treat high blood pressure and edema.','25mg'),('MED017','Alprazolam','Used to treat anxiety and panic disorders.','0.5mg'),('MED018','Gabapentin','Used to treat nerve pain and seizures.','300mg'),('MED019','Montelukast','Used to prevent wheezing and shortness of breath caused by asthma.','10mg'),('MED020','Tramadol','Used to help relieve moderate to moderately severe pain.','50mg'),('MED021','Warfarin','Anticoagulant used to prevent blood clots.','5mg'),('MED022','Metoprolol','Used to treat high blood pressure, chest pain, and heart failure.','50mg'),('MED023','Fluoxetine','Used to treat depression, obsessive-compulsive disorder (OCD), and anxiety disorders.','20mg'),('MED024','Prednisone','Corticosteroid used to treat various conditions such as arthritis, blood disorders, and immune system disorders.','10mg'),('MED025','Doxycyclin','Antibiotic used to treat a variety of infections.','100mg');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
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
