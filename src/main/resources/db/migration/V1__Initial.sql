create table especialidades(
    id bigint not null auto_increment,
    descricao varchar(100) not null,
    data_criado datetime not null,
    primary key(id)
);

create table medicos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    crm varchar(6) not null,
    data_nascimento datetime not null,
    data_criado datetime not null,
    especialidade_id bigint not null,
    status int not null,
    primary key(id),
    constraint fk_medicos_especialidade_id foreign key (especialidade_id) references especialidades(id)
);
create table usuarios(
    id bigint not null auto_increment,
    user varchar(100) not null,
    senha varchar(255) not null,
    primary key(id)
);
create table pacientes (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    data_nascimento datetime not null,
    data_criado datetime not null,
    genero varchar(50), 
    primary key(id)
);
create table consultas(
    id bigint not null auto_increment,
    medico_id bigint not null,
    paciente_id bigint not null,
    especialidade_id bigint not null,
    data datetime not null,
    data_criado datetime not null,
    primary key(id),
    constraint fk_consultas_medico_id foreign key (medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key (paciente_id) references pacientes(id)
)