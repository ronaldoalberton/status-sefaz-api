create table status_servico_historico (
    id integer auto_increment,
    id_autorizador integer,
    id_status_autorizacao integer,
    id_status_retorno_autorizacao integer,
    id_status_inutilizacao integer,
    id_status_consulta_protocolo integer,
    id_status_status_servico integer,
    id_status_consulta_cadastro integer,
    id_status_recepecao_evento integer,
    data_status date,
    hora_status time,
    flag_status_atual integer not null default 0
);

create table autorizador (
    id_autorizador integer,
    sigla_autorizador varchar(6),
    descricao_autorizador varchar(50),
    identificacao_site varchar(15)
);

insert into autorizador(id_autorizador, sigla_autorizador, descricao_autorizador, identificacao_site)
values (1, 'AM', 'Amazonas', 'AM'),
    (2, 'BA', 'Bahia', 'BA'),
    (3, 'CE', 'Ceará', 'CE'),
    (4, 'GO', 'Goais', 'GO'),
    (5, 'MG', 'Minas Gerais', 'MG'),
    (6, 'MS', 'Mato Grosso do Sul', 'MS'),
    (7, 'MT', 'Mato Grosso', 'MT'),
    (8, 'PE', 'Pernanbuco', 'PE'),
    (9, 'PR', 'Paraná', 'PR'),
    (10, 'RS', 'Rio Grande do Sul', 'RS'),
    (11, 'SP', 'São Paulo', 'SP'),
    (12, 'SVAN', 'Servidor Virtual Ambiente Nacional', 'SVAN'),
    (13, 'SVRS', 'Servidor Virtual Rio Grande do Sul', 'SVRS'),
    (14, 'SVC-AN', 'Servidor Virtual Continência - Ambiente Nacional', 'SVC-AN'),
    (15, 'SVC-RS', 'Servidor Virtual Continência - Rio Grande do Sul', 'SVC-RS');

create table servico_sefaz (
    id_servico_sefaz integer,
    descricao_servico varchar(50)
);

insert into servico_sefaz(id_servico_sefaz, descricao_servico)
values (1, 'Autorização4'),
    (2, 'Retorno Autorização4'),
    (3, 'Inutilização4'),
    (4, 'Consulta Protocolo4'),
    (5, 'Status Serviço4'),
    (6, 'Consulta Cadastro4'),
    (7, 'Recepção Evento4');



create table status_servico (
    id_status_servico integer,
    descricao_status_servico varchar(50),
    identificacao_site varchar(50)
);

insert into status_servico(id_status_servico, descricao_status_servico, identificacao_site)
values  (1, 'Online', '<img src="imagens/bola_verde_P.png">'),
    (2, 'Alert', '<img src="imagens/bola_amarela_P.png">'),
    (3, 'Offline', '<img src="imagens/bola_vermelho_P.png">');

create view vw_totalizador_status as
select
    id_autorizador as id,
    id_autorizador,
    coalesce(sum(case when id_status_autorizacao = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_retorno_autorizacao = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_inutilizacao = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_consulta_protocolo = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_status_servico = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_consulta_cadastro = 3 then 1 else 0 end),0) +
    coalesce(sum(case when id_status_recepecao_evento = 3 then 1 else 0 end),0) as nr_total_offline
from
    status_servico_historico
group by
    id_autorizador
