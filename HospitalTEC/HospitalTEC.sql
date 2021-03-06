CREATE DATABASE HospitalTEC
USE HospitalTEC

CREATE TABLE [tipoUsuario] (
  [tipoUsuario] INT IDENTITY (1,1),
  [detalle] VARCHAR(15),
  PRIMARY KEY ([tipoUsuario])
);

CREATE TABLE [Usuario] (
  [idUsuario] VARCHAR(30),
  [Nombre] VARCHAR(30),
  [Apellido1] VARCHAR(30),
  [Apellido2] VARCHAR(30),
  [Contrasena] VARCHAR(50),
  [TipoUsuario] INT,
  PRIMARY KEY ([idUsuario]),
  CONSTRAINT [FK_Usuario.TipoUsuario]
    FOREIGN KEY ([TipoUsuario])
      REFERENCES [tipoUsuario]([tipoUsuario]),
);

CREATE TABLE [CatalogoDiagnosticos] (
  [IdDiagnostico] INT IDENTITY (1,1),
  [NombreDiagnostico] VARCHAR(70),
  PRIMARY KEY ([IdDiagnostico])
);

CREATE TABLE [CatalogoTratamientos] (
  [IdTratamiento] INT IDENTITY (1,1),
  [Nombre] VARCHAR(70),
  PRIMARY KEY ([IdTratamiento])
);

CREATE TABLE [Tratamiento_Diagnostico] (
  [IdDiagnostico] INT,
  [IdTratamiento] INT,
  PRIMARY KEY ([IdDiagnostico], [IdTratamiento]),
  CONSTRAINT [FK_Tratamiento_Diagnostico.IdDiagnostico]
    FOREIGN KEY ([IdDiagnostico])
      REFERENCES [CatalogoDiagnosticos]([IdDiagnostico]),
  CONSTRAINT [FK_Tratamiento_Diagnostico.IdTratamiento]
    FOREIGN KEY ([IdTratamiento])
      REFERENCES [CatalogoTratamientos]([IdTratamiento])
);

CREATE TABLE [Bitacora] (
  [IdBitacora] INT IDENTITY (1,1),
  [Fecha] DATE,
  [Hora] TIME,
  [idUsuario] VARCHAR(30), ---Es la c?dula del usuario que cambia la cita
  [nuevoEstado] VARCHAR(50),
  PRIMARY KEY ([IdBitacora])
);

CREATE TABLE [Cita] (
  [IdCita] INT IDENTITY (1,1),
  [fecha] DATE,
  [hora] TIME,
  [observaciones] VARCHAR(100),
  [estado] VARCHAR(50),
  [especialidad] VARCHAR(50), ---Se maneja mediante la clase enum
  [correo] VARCHAR(50),
  PRIMARY KEY ([IdCita])
);

CREATE TABLE [Bitacora_Cita] (
  [IdCita] INT,
  [IdBitacora] INT,
  PRIMARY KEY ([IdCita], [IdBitacora]),
  CONSTRAINT [FK_Bitacora_Cita.IdBitacora]
    FOREIGN KEY ([IdBitacora])
      REFERENCES [Bitacora]([IdBitacora]),
  CONSTRAINT [FK_Bitacora_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita])
);

CREATE TABLE [Paciente] (
  [idPaciente] VARCHAR(30),
  [nacionalidad] VARCHAR(50),
  [tipoSangre] VARCHAR(10),
  [fechaNacimiento] DATE,
  [provincia] VARCHAR(20),
  [canton] VARCHAR(30),
  PRIMARY KEY ([idPaciente]),
  CONSTRAINT [FK_Paciente.idUsuario]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Usuario]([idUsuario]),
);

CREATE TABLE [Paciente_Cita] (
  [idPaciente] VARCHAR(30),
  [IdCita] INT,
  PRIMARY KEY ([idPaciente], [IdCita]),
  CONSTRAINT [FK_Paciente_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita]),
  CONSTRAINT [FK_Paciente_Cita.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente])
);

CREATE TABLE [TipoCentro](
  [idTipo] INT IDENTITY (1,1),
  [TipoCentro] VARCHAR(50),
  PRIMARY KEY ([idTipo])
);

CREATE TABLE [CentroAtencion](
  [Codigo] INT IDENTITY (1,1),
  [idTipo] INT,
  [nombreCentro] VARCHAR(50),
  [ubicacion] VARCHAR(100),
  [capacidad] INT,
  PRIMARY KEY ([Codigo]),
  CONSTRAINT [FK_CentroAtencion.Codigo]
    FOREIGN KEY ([idTipo])
      REFERENCES [TipoCentro]([idTipo])
);

CREATE TABLE [Centro_paciente](
  [idPaciente] VARCHAR(30),
  [Codigo] INT,
  PRIMARY KEY ([idPaciente], [Codigo]),
  CONSTRAINT [FK_Centro_Paciente.Codigo]
    FOREIGN KEY ([Codigo])
      REFERENCES [CentroAtencion]([Codigo]),
  CONSTRAINT [FK_Paciente.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente])
);

CREATE TABLE [Funcionario] (
  [IDFuncionario] VARCHAR(30),
  [fechaIngreso] DATE,
  PRIMARY KEY ([IDFuncionario]),
  CONSTRAINT [FK_Funcionario.idUsuario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Usuario]([idUsuario]),
);

CREATE TABLE [Enfermero] (
  [IDFuncionario] VARCHAR(30),
  [aCargo] BIT, ---1 para TRUE, 0 para FALSE
  [experiencia] BIT,
  PRIMARY KEY ([IDFuncionario]),
  CONSTRAINT [FK_Enfermero.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario])
);

CREATE TABLE [Doctor] (
  [codigoMedico] VARCHAR(30),
  [IDFuncionario] VARCHAR(30),
  PRIMARY KEY ([IDFuncionario]),
  CONSTRAINT [FK_Doctor.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario])
);

CREATE TABLE [Especialidades_Doctor] (
  [idFuncionario] VARCHAR(30),
  [especialidad] VARCHAR(50),
  PRIMARY KEY ([idFuncionario], [especialidad]),
  CONSTRAINT [FK_Especialidades_Doctor.idFuncionario]
    FOREIGN KEY ([idFuncionario])
      REFERENCES [Doctor]([idFuncionario])
);

CREATE TABLE [Centro_Funcionario] (
  [IDFuncionario] VARCHAR(30),
  [Codigo] INT,
  PRIMARY KEY ([IDFuncionario], [Codigo]),
  CONSTRAINT [FK_Centro_Funcionario.Codigo]
    FOREIGN KEY ([Codigo])
      REFERENCES [CentroAtencion]([Codigo]),
  CONSTRAINT [FK_Centro_Funcionario.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario])
);

CREATE TABLE [Funcionario_Cita] (
  [IDFuncionario] VARCHAR(30),
  [IdCita] INT,
  PRIMARY KEY ([IDFuncionario], [IdCita]),
  CONSTRAINT [FK_Funcionario_Cita.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario]),
  CONSTRAINT [FK_Funcionario_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita])
);

CREATE TABLE [AreaTrabajo] (
  [codigo] INT IDENTITY (1,1),
  [NombreArea] VARCHAR(50),
  PRIMARY KEY ([codigo])
);

CREATE TABLE [Internado] (
  [codInternado] INT IDENTITY (1,1),
  [IdInternado] VARCHAR(30),
  [fechaInicio] DATE,
  [fechaFin] DATE,
  [codigoAreaTrabajo] INT,
  PRIMARY KEY ([codInternado]),
  CONSTRAINT [FK_Internado.codigoAreaTrabajo]
    FOREIGN KEY ([codigoAreaTrabajo])
      REFERENCES [AreaTrabajo]([codigo])
);

CREATE TABLE [RegistroSeguimiento](
  [idRegistro] INT IDENTITY (1,1),
  [fecha] DATE,
  [observacion] VARCHAR(100),
  PRIMARY KEY ([idRegistro])
);

CREATE TABLE [Internado_Centro] (
  [codInternado] INT,
  [Codigo] INT,
  PRIMARY KEY ([Codigo], [codInternado]),
  CONSTRAINT [FK_Internado_Centro.Codigo]
    FOREIGN KEY ([Codigo])
      REFERENCES [CentroAtencion]([Codigo]),
  CONSTRAINT [FK_Internado_Centro.IdInternado]
    FOREIGN KEY ([codInternado])
      REFERENCES [Internado]([codInternado])
);

CREATE TABLE [Cita_Diagnostico] (
  [IdCita] INT,
  [IdDiagnostico] INT,
  [IdTratamiento] INT,
  [Dosis] VARCHAR(30),
  [Nivel] VARCHAR(30),
  [Observaciones] VARCHAR(100),
  PRIMARY KEY ([IdCita], [IdDiagnostico]),
  CONSTRAINT [FK_Cita_Diagnostico.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita]),
  CONSTRAINT [FK_Cita_Diagnostico.CatalogoDiagnostico]
    FOREIGN KEY ([IdDiagnostico])
      REFERENCES [CatalogoDiagnosticos]([IdDiagnostico]),
  CONSTRAINT [FK_Cita_Diagnostico.CatalogoTratamientos]
    FOREIGN KEY ([IdTratamiento])
      REFERENCES [CatalogoTratamientos]([IdTratamiento])
);

CREATE TABLE [Cita_Internado] ( ---Esta tabla se ocupa? Estoy analizandolo pero no s? si todo paciente es internado tras recibir una cita
  [Idcita] INT,
  [codInternado] INT,
  PRIMARY KEY ([Idcita], [codInternado]),
  CONSTRAINT [FK_Cita_Internado.Idcita]
    FOREIGN KEY ([Idcita])
      REFERENCES [Cita]([IdCita]),
  CONSTRAINT [FK_Cita_Internado.IdInternado]
    FOREIGN KEY ([codInternado])
      REFERENCES [Internado]([codInternado])
);

CREATE TABLE [AreaTrabajo_Funcionario] (
  [codigo] INT,
  [IDFuncionario] VARCHAR(30),
  PRIMARY KEY ([codigo], [IDFuncionario]),
  CONSTRAINT [FK_AreaTrabajo_Funcionario.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario]),
  CONSTRAINT [FK_AreaTrabajo_Funcionario.codigo]
    FOREIGN KEY ([codigo])
      REFERENCES [AreaTrabajo]([codigo])
);

CREATE TABLE [Internado_Doctor] (
  [codInternado] INT,
  [IDFuncionario] VARCHAR(30),
  PRIMARY KEY ([codInternado], [IDFuncionario]),
  CONSTRAINT [FK_Internado_Doctor.codigoMedico]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Doctor]([IDFuncionario]),
  CONSTRAINT [FK_Internado_Doctor.IdInternado]
    FOREIGN KEY ([codInternado])
      REFERENCES [Internado]([codInternado])
);

CREATE TABLE [Telefono_Paciente] (
  [idPaciente] VARCHAR(30),
  [telefono] VARCHAR(30),
  PRIMARY KEY ([idPaciente], [telefono]),
  CONSTRAINT [FK_Telefono_Paciente.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente])
);

CREATE TABLE [Vacuna] (
  [idVacuna] INT IDENTITY (1,1),
  [nombre] VARCHAR(50),
  [farmaceutica] VARCHAR(50),
  PRIMARY KEY ([idVacuna])
);

CREATE TABLE [Internado_Registro] (
  [codInternado] INT,
  [idRegistro] INT,
  PRIMARY KEY ([codInternado], [idRegistro]),
  CONSTRAINT [FK_Internado_Registro.IdInternado]
    FOREIGN KEY ([codInternado])
      REFERENCES [Internado]([codInternado]),
  CONSTRAINT [FK_Internado_Registro.idRegistro]
    FOREIGN KEY ([idRegistro])
      REFERENCES [RegistroSeguimiento]([idRegistro])
);

CREATE TABLE [Paciente_Vacuna] (
  [idPaciente] VARCHAR(30),
  [idVacuna] INT,
  [fechaAplicacion] DATE,
  [lote] VARCHAR(10),
  PRIMARY KEY ([idPaciente], [idVacuna]),
  CONSTRAINT [FK_Paciente_Vacuna.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente]),
  CONSTRAINT [FK_Paciente_Vacuna.idVacuna]
    FOREIGN KEY ([idVacuna])
      REFERENCES [Vacuna]([idVacuna])
);

-------------------INSERCIONES INICIALES
INSERT INTO tipoUsuario VALUES ('Paciente');
INSERT INTO tipoUsuario VALUES ('Secretario');
INSERT INTO tipoUsuario VALUES ('Enfermero');
INSERT INTO tipoUsuario VALUES ('Doctor');
INSERT INTO Usuario VALUES ('305110992', 'Aar?n', 'Soto', 'Cort?s', '123123', 1);
INSERT INTO Usuario VALUES ('206220885', 'Andr?s', 'Alvarado', 'Carranza', '234234', 1);
INSERT INTO Usuario VALUES ('305240656', 'Pablo', 'Chaves', 'Rivera', '123123', 2);
INSERT INTO Usuario VALUES ('502420345', 'Jennifer', 'Loaiza', 'Retana', '456456', 2);
INSERT INTO Usuario VALUES ('305300938', 'Luis', 'Leiton', 'Flores', '123123', 3);
INSERT INTO Usuario VALUES ('802340534', 'Ahsley', 'Sibaja', 'Prado', '321321', 3); 
INSERT INTO Usuario VALUES ('303240163', 'Alonso', 'Chaves', 'Mu?oz', '123123', 4);
INSERT INTO Usuario VALUES ('901230132', 'Francella', 'Jimenez', 'Noguera', '987987', 4);
INSERT INTO CatalogoDiagnosticos VALUES ('Gastroenteritis aguda');
INSERT INTO CatalogoDiagnosticos VALUES ('Diabetes Tipo I');
INSERT INTO CatalogoDiagnosticos VALUES ('Neumon?a');
INSERT INTO CatalogoDiagnosticos VALUES ('Arritmia Card?aca');
INSERT INTO CatalogoDiagnosticos VALUES ('Ahogamiento');
INSERT INTO CatalogoDiagnosticos VALUES ('Bronquitis');
INSERT INTO CatalogoDiagnosticos VALUES ('Artritis');
INSERT INTO CatalogoDiagnosticos VALUES ('Cefalea');
INSERT INTO CatalogoTratamientos VALUES ('Cirug?a gastrointestinal');
INSERT INTO CatalogoTratamientos VALUES ('Inyecci?n de Insulina');
INSERT INTO CatalogoTratamientos VALUES ('Ejercicios pulmonares');
INSERT INTO CatalogoTratamientos VALUES ('Colocaci?n de marcapasos');
INSERT INTO CatalogoTratamientos VALUES ('Cortisona nasal');
INSERT INTO CatalogoTratamientos VALUES ('Antibi?ticos');
INSERT INTO CatalogoTratamientos VALUES ('Antiflamatorios');
INSERT INTO CatalogoTratamientos VALUES ('Analg?sicos');
INSERT INTO Tratamiento_Diagnostico VALUES (1,1);
INSERT INTO Tratamiento_Diagnostico VALUES (2,2);
INSERT INTO Tratamiento_Diagnostico VALUES (3,3);
INSERT INTO Tratamiento_Diagnostico VALUES (4,4);
INSERT INTO Tratamiento_Diagnostico VALUES (5,5);
INSERT INTO Tratamiento_Diagnostico VALUES (6,6);
INSERT INTO Tratamiento_Diagnostico VALUES (7,7);
INSERT INTO Tratamiento_Diagnostico VALUES (8,8);
INSERT INTO Cita VALUES ('2021-08-21', '11:30:00', 'Presenta mareos constantes', 'Registrada', 'Medicina general', 'aaronsotco@gmail.com');
INSERT INTO Bitacora VALUES ('2021-08-21', '11:30:00', '303240163', 'Registrada');
INSERT INTO Bitacora_Cita VALUES (1,1);
INSERT INTO Cita VALUES ('2021-09-30', '10:20:00', 'Presenta dolores de rodilla', 'Registrada', 'Fisioterapeuta', 'andresandres@gmail.com');
INSERT INTO Bitacora VALUES ('2021-09-30', '10:20:00', '502420345', 'Registrada');
INSERT INTO Bitacora_Cita VALUES (2,2);
INSERT INTO Bitacora VALUES ('2021-10-01', '16:30:00', '502420345', 'Asignada');
INSERT INTO Bitacora_Cita VALUES (2,3);
INSERT INTO Paciente VALUES ('305110992', 'Costarricense', 'B-', '1998-08-21', 'Cartago', 'Central');
INSERT INTO Paciente VALUES ('206220885', 'Puertorrique?o', 'A+', '1995-08-21', 'Heredia', 'San Joaqu?n');
INSERT INTO Paciente_Cita VALUES ('305110992', 1);
INSERT INTO Paciente_Cita VALUES ('206220885', 2);
INSERT INTO TipoCentro VALUES ('Hospital');
INSERT INTO TipoCentro VALUES ('Cl?nica');
INSERT INTO TipoCentro VALUES ('Ebais');
INSERT INTO TipoCentro VALUES ('Consultorio');
INSERT INTO CentroAtencion VALUES (1, 'Hospital La Cat?lica', 'San Jose Centro', 250);
INSERT INTO CentroAtencion VALUES (1, 'Hospital La Desamparade?a', 'Desamparados', 300);
INSERT INTO CentroAtencion VALUES (2, 'Clinica Biblica', 'San Jose Centro', 300);
INSERT INTO CentroAtencion VALUES (2, 'Clinica Ayayai', 'Alajuela Centro', 170);
INSERT INTO CentroAtencion VALUES (3, 'Ebais Agua Caliente', 'Cartago Agua Caliente', 60);
INSERT INTO CentroAtencion VALUES (3, 'Ebais San Joaqu?', 'Heredia San Joaqu?', 20);
INSERT INTO CentroAtencion VALUES (4, 'Consultorio Bienestar', 'Heredia', 10);
INSERT INTO CentroAtencion VALUES (4, 'Consultorio Curamales', 'Lim?n', 30);
INSERT INTO Centro_paciente VALUES ('305110992', 2);
INSERT INTO Centro_paciente VALUES ('206220885', 4);
INSERT INTO Funcionario VALUES ('303240163', '2020-11-01');
INSERT INTO Funcionario VALUES ('305240656', '2020-12-20');
INSERT INTO Funcionario VALUES ('305300938', '2021-02-15');
INSERT INTO Funcionario VALUES ('502420345', '2005-06-13');
INSERT INTO Funcionario VALUES ('802340534', '2012-12-21');
INSERT INTO Funcionario VALUES ('901230132', '2004-01-01');
INSERT INTO Enfermero VALUES ('305300938', 1, 1);
INSERT INTO Enfermero VALUES ('802340534', 0, 1);
INSERT INTO Doctor VALUES ('001', '303240163');
INSERT INTO Doctor VALUES ('002', '901230132');
INSERT INTO Especialidades_Doctor VALUES ('303240163', 'Gastroenter?logo');
INSERT INTO Especialidades_Doctor VALUES ('303240163', 'M?dico General');
INSERT INTO Especialidades_Doctor VALUES ('901230132', 'Pediatr?a');
INSERT INTO Especialidades_Doctor VALUES ('901230132', 'Obstetricia');
INSERT INTO Centro_Funcionario VALUES ('303240163', 1);
INSERT INTO Centro_Funcionario VALUES ('305240656', 2);
INSERT INTO Centro_Funcionario VALUES ('305300938', 3);
INSERT INTO Centro_Funcionario VALUES ('502420345', 4);
INSERT INTO Centro_Funcionario VALUES ('802340534', 5);
INSERT INTO Centro_Funcionario VALUES ('901230132', 6);
INSERT INTO Funcionario_Cita VALUES ('303240163', 1);
INSERT INTO Funcionario_Cita VALUES ('901230132', 2);
INSERT INTO AreaTrabajo VALUES ('Anestesiolog?a');
INSERT INTO AreaTrabajo VALUES ('Cuidados Intensivos');
INSERT INTO AreaTrabajo VALUES ('Emergencias');
INSERT INTO AreaTrabajo VALUES ('Recepci?n');
INSERT INTO Internado VALUES ('305110992', '2021-08-21', '2021-08-23', 2);
INSERT INTO Internado VALUES ('206220885', '2021-10-22', '2021-10-30', 3);
INSERT INTO RegistroSeguimiento VALUES ('2021-08-21', 'El paciente presente dolores constantes de abdomen');
INSERT INTO RegistroSeguimiento VALUES ('2021-08-22', 'El paciente menciona haber comido pescado el d?a anterior');
INSERT INTO RegistroSeguimiento VALUES ('2021-08-23', 'El paciente presenta mejor?as notorias');
INSERT INTO RegistroSeguimiento VALUES ('2021-10-22', 'El paciente presente dolores de cabeza cr?nicos');
INSERT INTO RegistroSeguimiento VALUES ('2021-10-27', 'El paciente constantemente se desmaya');
INSERT INTO RegistroSeguimiento VALUES ('2021-10-30', 'El paciente presenta mejor?as pero se mantiene en observaci?n');
INSERT INTO Internado_Centro VALUES (1, 1);
INSERT INTO Internado_Centro VALUES (2, 5);
INSERT INTO Cita_Diagnostico VALUES (1, 1, 1, 'N/A', 'Grave', 'Se decide hospitalizar inmediatamente');
INSERT INTO Cita_Diagnostico VALUES (2, 4, 4, 'N/A', 'Leve', 'Realizar ecocardiograma');
INSERT INTO Cita_Internado VALUES (1, 1);
INSERT INTO Cita_Internado VALUES (2, 2);
INSERT INTO AreaTrabajo_Funcionario VALUES (1, '303240163');
INSERT INTO AreaTrabajo_Funcionario VALUES (2, '305300938');
INSERT INTO AreaTrabajo_Funcionario VALUES (4, '305240656');
INSERT INTO AreaTrabajo_Funcionario VALUES (3, '502420345');
INSERT INTO AreaTrabajo_Funcionario VALUES (3, '802340534');
INSERT INTO AreaTrabajo_Funcionario VALUES (2, '901230132');
INSERT INTO Internado_Doctor VALUES (1, '303240163');
INSERT INTO Internado_Doctor VALUES (2, '901230132');
INSERT INTO Telefono_Paciente VALUES ('305110992', '89652266');
INSERT INTO Telefono_Paciente VALUES ('305110992', '88886666');
INSERT INTO Telefono_Paciente VALUES ('206220885', '85868586');
INSERT INTO Telefono_Paciente VALUES ('206220885', '77775555');
INSERT INTO Vacuna VALUES ('Contra la viruela', 'H&P');
INSERT INTO Vacuna VALUES ('Contra Fiebre Amarilla', 'H&P');
INSERT INTO Vacuna VALUES ('Contra la varicela', 'Medipharma');
INSERT INTO Vacuna VALUES ('Contra el Sarampi?n', 'Medipharma');
INSERT INTO Vacuna VALUES ('COVID-19', 'Jhonson & Jhonson');
INSERT INTO Vacuna VALUES ('Contra paperas', 'Jhonson & Jhonson');
INSERT INTO Internado_Registro VALUES (1, 1);
INSERT INTO Internado_Registro VALUES (2, 2);
INSERT INTO Paciente_Vacuna VALUES ('305110992', 1, '2005-01-12', '12573');
INSERT INTO Paciente_Vacuna VALUES ('305110992', 2, '2007-02-21', '65451');
INSERT INTO Paciente_Vacuna VALUES ('305110992', 3, '2021-08-30', '48432');
INSERT INTO Paciente_Vacuna VALUES ('206220885', 4, '2009-05-13', '7856');
INSERT INTO Paciente_Vacuna VALUES ('206220885', 5, '2010-07-19', '9652');
INSERT INTO Paciente_Vacuna VALUES ('206220885', 6, '2020-10-12', '3584');

SELECT CDi.NombreDiagnostico FROM Cita C 
	JOIN Paciente_Cita PC ON C.IdCita = PC.IdCita 
	JOIN Cita_Diagnostico CD ON PC.IdCita = CD.IdCita
	JOIN CatalogoDiagnosticos CDi ON CDi.IdDiagnostico = CD.IdDiagnostico
		WHERE idPaciente = '305110992'

SELECT IdBitacora FROM Bitacora ORDER BY (IdBitacora) DESC

---CONSULTA 1 DE PACIENTE
SELECT Cita.IdCita, fecha, hora, observaciones, estado, especialidad, correo 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita 
		WHERE idPaciente = '305110992'
---FILTROS
AND fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND estado = 'Registrada' 
AND especialidad LIKE '%Medicina general%'

---CONSULTA 2 DE PACIENTE
SELECT CatalogoDiagnosticos.IdDiagnostico, CatalogoDiagnosticos.NombreDiagnostico 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita 
		INNER JOIN Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita
			INNER JOIN CatalogoDiagnosticos ON Cita_Diagnostico.IdDiagnostico = CatalogoDiagnosticos.IdDiagnostico
				WHERE idPaciente = '305110992'
---FILTROS
AND fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND Nivel = 'Grave' 
AND NombreDiagnostico LIKE '%Gastroenteritis%'

---CONSULTA 3 DE PACIENTE
SELECT CatalogoTratamientos.IdTratamiento, CatalogoTratamientos.Nombre 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita 
		INNER JOIN Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita
			INNER JOIN CatalogoTratamientos ON Cita_Diagnostico.IdTratamiento = CatalogoTratamientos.IdTratamiento
				WHERE idPaciente = '305110992'
---FILTROS
AND fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND CatalogoTratamientos.Nombre LIKE '%Cirug?a gastrointestinal%'
AND Cita_Diagnostico.Dosis = '%N/A%'

---CONSULTA 4 DE PACIENTE
SELECT fechaInicio, fechaFin, nombreCentro, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreCompleto 
	FROM Internado INNER JOIN Internado_Centro ON Internado.codInternado = Internado_Centro.codInternado
		INNER JOIN CentroAtencion ON CentroAtencion.Codigo = Internado_Centro.Codigo
			INNER JOIN Internado_Doctor ON Internado.codInternado = Internado_Doctor.codInternado
				INNER JOIN Usuario ON Internado_Doctor.IDFuncionario = Usuario.idUsuario
					WHERE IdInternado = '305110992'
---NO REQUIERE DE FILTROS.

---CONSULTA 1 DE DOCTOR
SELECT Cita.IdCita, fecha, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreCompleto, hora, observaciones, estado, especialidad, correo 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita
		INNER JOIN Usuario ON Paciente_Cita.idPaciente = Usuario.idUsuario
--- EL WHERE DEBE SER AGREGADO AL STRING EN EL MOMENTO EN QUE SE ENCUENTRE UN FILTRO ACTIVO			
WHERE fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND estado = 'Registrada'
AND especialidad LIKE '%icina%'
AND Nombre LIKE '%Aar?n%' OR Apellido1 LIKE '%Soto%' OR Apellido2 LIKE '%Cort?s%'

---CONSULTA 2 DE DOCTOR
SELECT CatalogoDiagnosticos.IdDiagnostico, CatalogoDiagnosticos.NombreDiagnostico 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita 
		INNER JOIN Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita
			INNER JOIN CatalogoDiagnosticos ON Cita_Diagnostico.IdDiagnostico = CatalogoDiagnosticos.IdDiagnostico
				WHERE idPaciente = '305110992'
---FILTROS
AND fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND Nivel = 'Grave' 
AND NombreDiagnostico LIKE '%Gastroenteritis%'

---CONSULTA 3 DE DOCTOR
SELECT CatalogoTratamientos.IdTratamiento, CatalogoTratamientos.Nombre
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita 
		INNER JOIN Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita
			INNER JOIN CatalogoTratamientos ON Cita_Diagnostico.IdTratamiento = CatalogoTratamientos.IdTratamiento
				WHERE idPaciente = '305110992'
---FILTROS
AND fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND Cita_Diagnostico.Dosis = 'N/A'
AND CatalogoTratamientos.Nombre = 'Cirug?a gastrointestinal'

---CONSULTA 4 DE DOCTOR
SELECT COUNT(Cita.IdCita) FROM Cita
---FILTROS
WHERE fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND estado = 'Registrada' 
AND especialidad LIKE '%Medicina general%'

---CONSULTA 5 DE DOCTOR
SELECT COUNT(IdDiagnostico)	FROM CatalogoDiagnosticos ---CONTEO GENERAL

SELECT COUNT(CatalogoDiagnosticos.IdDiagnostico) AS TotalDiagnosticos ---CONTEO ESPECIALIZADO CON FILTROS
	FROM CatalogoDiagnosticos INNER JOIN Cita_Diagnostico ON CatalogoDiagnosticos.IdDiagnostico = Cita_Diagnostico.IdDiagnostico
		INNER JOIN Cita ON Cita_Diagnostico.IdCita = Cita.IdCita
			INNER JOIN Paciente_Cita ON Paciente_Cita.IdCita = Cita.IdCita
				WHERE CatalogoDiagnosticos.IdDiagnostico = Cita_Diagnostico.IdDiagnostico
---FILTROS
AND Nivel = 'Grave'
AND Cita.especialidad = 'Medicina General'
AND idPaciente = '305110992'

---CONSULTA 6 DE DOCTOR
SELECT COUNT(IdTratamiento)	FROM CatalogoTratamientos ---CONTEO GENERAL

SELECT COUNT(CatalogoTratamientos.IdTratamiento) AS TotalTratamientos ---CONTEO ESPECIALIZADO CON FILTROS
	FROM CatalogoTratamientos INNER JOIN Cita_Diagnostico ON CatalogoTratamientos.IdTratamiento = Cita_Diagnostico.IdTratamiento
		INNER JOIN Cita ON Cita_Diagnostico.IdCita = Cita.IdCita
			INNER JOIN Paciente_Cita ON Paciente_Cita.IdCita = Cita.IdCita
				WHERE CatalogoTratamientos.IdTratamiento = Cita_Diagnostico.IdTratamiento
---FILTROS
AND Cita_Diagnostico.Dosis = 'Tipo'
AND Cita.especialidad = 'Medicina General'
AND idPaciente = '305110992'

---CONSULTA 7 DE PACIENTE CON CEDULA
SELECT fechaInicio, fechaFin, nombreCentro, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreDoctor 
	FROM Internado INNER JOIN Internado_Centro ON Internado.codInternado = Internado_Centro.codInternado
		INNER JOIN CentroAtencion ON CentroAtencion.Codigo = Internado_Centro.Codigo
			INNER JOIN Internado_Doctor ON Internado.codInternado = Internado_Doctor.codInternado
				INNER JOIN Usuario ON Internado_Doctor.IDFuncionario = Usuario.idUsuario
					WHERE IdInternado = '305110992'

---CONSULTA 7 DE PACIENTE CON NOMBRE
SELECT idUsuario FROM Usuario
	WHERE Nombre LIKE '%Aar?n%' AND Apellido1 LIKE '%Soto%' AND Apellido2 LIKE '%Cort?s%'

---CONSULTA 1 DE SECRETARIO
SELECT Cita.IdCita, fecha, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreCompleto, hora, observaciones, estado, especialidad, correo 
	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita
		INNER JOIN Usuario ON Paciente_Cita.idPaciente = Usuario.idUsuario
--- EL WHERE DEBE SER AGREGADO AL STRING EN EL MOMENTO EN QUE SE ENCUENTRE UN FILTRO ACTIVO			
WHERE fecha >= '2021-08-21'
AND fecha <= '2021-08-21'
AND estado = 'Registrada'
AND Nombre LIKE '%Aar?n%' OR Apellido1 LIKE '%Soto%' OR Apellido2 LIKE '%Cort?s%'

---CONSULTA 2 DE SECRETARIO HAR?A FALTA OBTENER EL NOMBRE DEL PACIENTE QUE ES INTERNADO
SELECT IdInternado, fechaInicio, fechaFin, nombreCentro, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreCompleto 
	FROM Internado INNER JOIN Internado_Centro ON Internado.codInternado = Internado_Centro.codInternado
		INNER JOIN Cita_Internado ON Internado.codInternado = Cita_Internado.codInternado
			INNER JOIN Cita ON Cita_Internado.Idcita = Cita.IdCita
				INNER JOIN CentroAtencion ON CentroAtencion.Codigo = Internado_Centro.Codigo
					INNER JOIN Internado_Doctor ON Internado.codInternado = Internado_Doctor.codInternado
						INNER JOIN Usuario ON Internado_Doctor.IDFuncionario = Usuario.idUsuario
---FILTROS
WHERE fechaInicio >= '2021-08-21' OR fechaFin >= '2021-08-21'
AND fechaInicio <= '2021-08-21' OR fechaFin <= '2021-08-21'
AND estado = 'Registrada'
AND Cita.especialidad = 'Medicina General'
