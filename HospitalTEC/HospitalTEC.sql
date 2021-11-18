CREATE DATABASE HospitalTEC
USE HospitalTEC

CREATE TABLE [tipoUsuario] (
  [tipoUsuario] INT,
  [detalle] VARCHAR,
  PRIMARY KEY ([tipoUsuario])
);

CREATE TABLE [Usuario] (
  [idUsuario] VARCHAR,
  [Nombre] VARCHAR,
  [Apellido1] VARCHAR,
  [Apellido2] VARCHAR,
  [Contrasena] VARCHAR,
  [TipoUsuario] INT,
  PRIMARY KEY ([idUsuario]),
  CONSTRAINT [FK_Usuario.TipoUsuario]
    FOREIGN KEY ([TipoUsuario])
      REFERENCES [tipoUsuario]([tipoUsuario]),
);

CREATE TABLE [CatalogoDiagnosticos] (
  [IdDiagnostico] VARCHAR,
  [NombreDiagnostico] VARCHAR,
  PRIMARY KEY ([IdDiagnostico])
);

CREATE TABLE [CatalogoTratamientos] (
  [IdTratamiento] VARCHAR,
  [Nombre] VARCHAR,
  PRIMARY KEY ([IdTratamiento])
);

CREATE TABLE [Tratamiento_Diagnostico] (
  [IdDiagnostico] VARCHAR,
  [IdTratamiento] VARCHAR,
  CONSTRAINT [FK_Tratamiento_Diagnostico.IdDiagnostico]
    FOREIGN KEY ([IdDiagnostico])
      REFERENCES [CatalogoDiagnosticos]([IdDiagnostico]),
  CONSTRAINT [FK_Tratamiento_Diagnostico.IdTratamiento]
    FOREIGN KEY ([IdTratamiento])
      REFERENCES [CatalogoTratamientos]([IdTratamiento])
);

CREATE TABLE [Bitacora] (
  [IdBitácora] VARCHAR,
  [Fecha] DATE,
  [Hora] DATE,
  [Usuario] VARCHAR,
  PRIMARY KEY ([IdBitácora])
);

CREATE TABLE [Cita] (
  [IdCita] VARCHAR,
  [fecha] Date,
  [hora] Time,
  [tipo] VARCHAR,
  [estado] VARCHAR,
  [especialidad] VARCHAR,
  PRIMARY KEY ([IdCita])
);

CREATE TABLE [Bitacora_Cita] (
  [IdCita] VARCHAR,
  [IdBitacora] VARCHAR,
  CONSTRAINT [FK_Bitacora_Cita.IdBitacora]
    FOREIGN KEY ([IdBitacora])
      REFERENCES [Bitacora]([IdBitácora]),
  CONSTRAINT [FK_Bitacora_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita])
);

CREATE TABLE [Paciente] (
  [idPaciente] VARCHAR,
  [nacionalidad] VARCHAR,
  [tipoSangre] VARCHAR,
  [fechaNacimiento] Date,
  [provincia] VARCHAR,
  [canton] VARCHAR,
  [distrito] VARCHAR,
  PRIMARY KEY ([idPaciente]),
  CONSTRAINT [FK_Paciente.idUsuario]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Usuario]([idUsuario]),
);

CREATE TABLE [Paciente_Cita] (
  [idPaciente] VARCHAR,
  [IdCita] VARCHAR,
  PRIMARY KEY ([idPaciente]),
  CONSTRAINT [FK_Paciente_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita]),
  CONSTRAINT [FK_Paciente_Cita.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente])
);

CREATE TABLE [TipoCentro] (
  [Codigo] int,
  [TipoCentro] Varchar,
  PRIMARY KEY ([Codigo])
);

CREATE TABLE [CentroAtencion] (
  [Codigo] int,
  [nombreCentro] Varchar,
  [ubicacion] Varchar,
  [capacidad] int,
  PRIMARY KEY ([Codigo]),
  CONSTRAINT [FK_CentroAtencion.Codigo]
    FOREIGN KEY ([Codigo])
      REFERENCES [TipoCentro]([Codigo])
);

CREATE TABLE [Centro_paciente] (
  [idPaciente] VARCHAR,
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
  [IDFuncionario] VARCHAR,
  [TipoFuncionario] VARCHAR,
  [fechaIngreso] Date,
  PRIMARY KEY ([IDFuncionario]),
  CONSTRAINT [FK_Funcionario.idUsuario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Usuario]([idUsuario]),
);

CREATE TABLE [Enfermero] (
  [IDFuncionario] VARCHAR,
  [aCargo] BIT,
  [experiencia] BIT,
  [IDEnfermero] INT,
  PRIMARY KEY ([IDEnfermero]),
  CONSTRAINT [FK_Enfermero.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario])
);

CREATE TABLE [Doctor] (
  [codigoMedico] VARCHAR,
  [especialidad] VARCHAR,
  [IDFuncionario] VARCHAR,
  PRIMARY KEY ([codigoMedico]),
  CONSTRAINT [FK_Doctor.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario])
);

CREATE TABLE [Centro_Funcionario] (
  [IDFuncionario] VARCHAR,
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
  [IDFuncionario] VARCHAR,
  [IdCita] VARCHAR,
  PRIMARY KEY ([IDFuncionario], [IdCita]),
  CONSTRAINT [FK_Funcionario_Cita.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario]),
  CONSTRAINT [FK_Funcionario_Cita.IdCita]
    FOREIGN KEY ([IdCita])
      REFERENCES [Cita]([IdCita])
);

CREATE TABLE [Internado] (
  [IdInternado] VARCHAR,
  [fechaInicio] DATE,
  [fechaFin] DATE,
  [codigoAreaTrabajo] VARCHAR,
  PRIMARY KEY ([IdInternado])
);

CREATE TABLE [RegistroSeguimiento] (
  [idRegistro] VARCHAR,
  [fecha] DATE,
  [observacion] VARCHAR,
  PRIMARY KEY ([idRegistro])
);

CREATE TABLE [Internado_Centro] (
  [Codigo] int,
  [IdInternado] VARCHAR,
  PRIMARY KEY ([Codigo], [IdInternado]),
  CONSTRAINT [FK_Internado_Centro.Codigo]
    FOREIGN KEY ([Codigo])
      REFERENCES [CentroAtencion]([Codigo]),
  CONSTRAINT [FK_Internado_Centro.IdInternado]
    FOREIGN KEY ([IdInternado])
      REFERENCES [Internado]([IdInternado])
);

CREATE TABLE [Cita_Diagnostico] (
  [IdCita] VARCHAR,
  [IdDiagnostico] VARCHAR,
  [IdTratamiento] VARCHAR,
  [Dosis] VARCHAR,
  [Tipo] VARCHAR,
  [Nivel] VARCHAR,
  [Observaciones] VARCHAR,
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

CREATE TABLE [Cita_Internado] (
  [Idcita] Varchar,
  [IdInternado] Varchar,
  CONSTRAINT [FK_Cita_Internado.Idcita]
    FOREIGN KEY ([Idcita])
      REFERENCES [Cita]([IdCita]),
  CONSTRAINT [FK_Cita_Internado.IdInternado]
    FOREIGN KEY ([IdInternado])
      REFERENCES [Internado]([IdInternado])
);

CREATE TABLE [AreaTrabajo] (
  [codigo] int,
  [NombreArea] Varchar,
  PRIMARY KEY ([codigo])
);

CREATE TABLE [AreaTrabajo_Funcionario] (
  [codigo] int,
  [IDFuncionario] Varchar,
  PRIMARY KEY ([codigo], [IDFuncionario]),
  CONSTRAINT [FK_AreaTrabajo_Funcionario.IDFuncionario]
    FOREIGN KEY ([IDFuncionario])
      REFERENCES [Funcionario]([IDFuncionario]),
  CONSTRAINT [FK_AreaTrabajo_Funcionario.codigo]
    FOREIGN KEY ([codigo])
      REFERENCES [AreaTrabajo]([codigo])
);

CREATE TABLE [Internado_Doctor] (
  [IdInternado] VARCHAR,
  [codigoMedico] VARCHAR,
  PRIMARY KEY ([IdInternado], [codigoMedico]),
  CONSTRAINT [FK_Internado_Doctor.codigoMedico]
    FOREIGN KEY ([codigoMedico])
      REFERENCES [Doctor]([codigoMedico]),
  CONSTRAINT [FK_Internado_Doctor.IdInternado]
    FOREIGN KEY ([IdInternado])
      REFERENCES [Internado]([IdInternado])
);

CREATE TABLE [Telefono_Paciente] (
  [idPaciente] VARCHAR,
  [telefono] INT,
  PRIMARY KEY ([idPaciente], [telefono]),
  CONSTRAINT [FK_Telefono_Paciente.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente])
);

CREATE TABLE [Vacuna] (
  [idVacuna] VARCHAR,
  [fechaAplicacion] Date,
  [nombre] Varchar,
  [farmaceutica] VARCHAR,
  [lote] int,
  PRIMARY KEY ([idVacuna])
);

CREATE TABLE [Internado_Registro] (
  [IdInternado] VARCHAR,
  [idRegistro] VARCHAR,
  PRIMARY KEY ([IdInternado], [idRegistro]),
  CONSTRAINT [FK_Internado_Registro.IdInternado]
    FOREIGN KEY ([IdInternado])
      REFERENCES [Internado]([IdInternado]),
  CONSTRAINT [FK_Internado_Registro.idRegistro]
    FOREIGN KEY ([idRegistro])
      REFERENCES [RegistroSeguimiento]([idRegistro])
);

CREATE TABLE [Paciente_Vacuna] (
  [idPaciente] VARCHAR,
  [idVacuna] VARCHAR,
  PRIMARY KEY ([idPaciente]),
  CONSTRAINT [FK_Paciente_Vacuna.idPaciente]
    FOREIGN KEY ([idPaciente])
      REFERENCES [Paciente]([idPaciente]),
  CONSTRAINT [FK_Paciente_Vacuna.idVacuna]
    FOREIGN KEY ([idVacuna])
      REFERENCES [Vacuna]([idVacuna])
);