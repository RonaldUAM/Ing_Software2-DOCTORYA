-- Crear la base de datos DoctorYa
CREATE DATABASE IF NOT EXISTS DoctorYa;
USE DoctorYa;

-- Tabla: Medical Insurance
CREATE TABLE Medical_Insurance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    type ENUM('public', 'private') NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    contact_phone VARCHAR(15) NOT NULL
);

-- Tabla: Patients
CREATE TABLE Patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    identification VARCHAR(50) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('male', 'female', 'other') NOT NULL,
    address VARCHAR(255),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    insurance_id INT,
    FOREIGN KEY (insurance_id) REFERENCES Medical_Insurance(id)
);

-- Tabla: Doctors
CREATE TABLE Doctors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    identification VARCHAR(50) UNIQUE NOT NULL,
    medical_license VARCHAR(50) UNIQUE NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

-- Tabla: Schedule
CREATE TABLE Schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    hour TIME NOT NULL,
    day INT NOT NULL,
    month INT NOT NULL,
    year INT NOT NULL,
    doctor_id INT NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id)
);

-- Tabla: Appointments
CREATE TABLE Appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    reason TEXT NOT NULL,
    status ENUM('scheduled', 'canceled', 'completed') NOT NULL,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patients(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id)
);

-- Tabla: Medical Records
CREATE TABLE Medical_Records (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    symptoms TEXT NOT NULL,
    diagnosis TEXT,
    treatment TEXT,
    observations TEXT,
    appointment_id INT UNIQUE NOT NULL,
    FOREIGN KEY (appointment_id) REFERENCES Appointments(id)
);

-- Tabla: Medications
CREATE TABLE Medications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    active_ingredient VARCHAR(100) NOT NULL,
    dosage_form ENUM('tablet', 'vial', 'suspension') NOT NULL,
    dosage VARCHAR(50) NOT NULL,
    usage_instructions TEXT NOT NULL,
    treatment_duration VARCHAR(50) NOT NULL,
    status ENUM('pending', 'delivered') NOT NULL,
    medical_record_id INT NOT NULL,
    FOREIGN KEY (medical_record_id) REFERENCES Medical_Records(id)
);

-- Tabla: Tests
CREATE TABLE Tests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    insurance_coverage BOOLEAN NOT NULL,
    test_date DATE NOT NULL,
    status ENUM('pending', 'completed') NOT NULL,
    medical_record_id INT NOT NULL,
    FOREIGN KEY (medical_record_id) REFERENCES Medical_Records(id)
);

-- Tabla: Test Results
CREATE TABLE Test_Results (
    id INT PRIMARY KEY AUTO_INCREMENT,
    diagnosis TEXT NOT NULL,
    possible_treatment TEXT,
    test_id INT UNIQUE NOT NULL,
    doctor_id INT NOT NULL,
    FOREIGN KEY (test_id) REFERENCES Tests(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id)
);

-- Tabla: Referrals
CREATE TABLE Referrals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    reason_for_referral TEXT NOT NULL,
    doctor_id INT NOT NULL,
    medical_record_id INT NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id),
    FOREIGN KEY (medical_record_id) REFERENCES Medical_Records(id)
);

-- Tabla: Reports
CREATE TABLE Reports (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    report_type ENUM('appointment_report', 'test_report') NOT NULL,
    content JSON NOT NULL
);

-- Datos iniciales para Medical_Insurance
INSERT INTO Medical_Insurance (name, type, start_date, end_date, contact_phone) VALUES
('Seguro Salud Pública', 'public', '2020-01-01', NULL, '123456789'),
('Salud Privada Premium', 'private', '2021-01-01', '2025-12-31', '987654321');

-- Datos iniciales para Patients
INSERT INTO Patients (name, identification, birth_date, gender, address, email, phone, insurance_id) VALUES
('John Doe', 'CC123456', '1980-05-15', 'male', '123 Main St', 'john.doe@example.com', '555123456', 1),
('Jane Smith', 'CC654321', '1990-10-20', 'female', '456 Elm St', 'jane.smith@example.com', '555654321', 2);

-- Datos iniciales para Doctors
INSERT INTO Doctors (name, identification, medical_license, specialty, email, phone) VALUES
('Dr. Alice', 'DR001', 'ML123', 'Cardiology', 'alice@example.com', '555111111'),
('Dr. Bob', 'DR002', 'ML456', 'Pediatrics', 'bob@example.com', '555222222');

-- Datos iniciales para Appointments
INSERT INTO Appointments (date, time, reason, status, patient_id, doctor_id) VALUES
('2024-11-23', '10:00:00', 'Routine check-up', 'scheduled', 1, 1),
('2024-11-24', '11:00:00', 'Flu symptoms', 'scheduled', 2, 2);

-- Datos iniciales para Medical Records
INSERT INTO Medical_Records (date, symptoms, diagnosis, treatment, observations, appointment_id) VALUES
('2024-11-23', 'Fatigue, shortness of breath', 'Anemia', 'Iron supplements', 'Patient needs regular follow-up', 1);

-- Datos iniciales para Medications
INSERT INTO Medications (name, active_ingredient, dosage_form, dosage, usage_instructions, treatment_duration, status, medical_record_id) VALUES
('Iron Tablets', 'Iron', 'tablet', '200mg', 'Take one tablet daily after meals', '30 days', 'pending', 1);
