INSERT INTO User (username, role) VALUES ('data_sql_teste', '0');

INSERT INTO Salao (nome, user_id) VALUES ('Salão A', '1');
INSERT INTO Salao (nome) VALUES ('Salão B');
INSERT INTO Salao (nome) VALUES ('Salão C');


INSERT INTO Cliente (nome) VALUES ('cliente1');
INSERT INTO Cliente (nome) VALUES ('cliente2');
INSERT INTO Cliente (nome) VALUES ('cliente3');



INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário A', 1);
INSERT INTO funcionario_servicos (funcionario_id, servico) VALUES (1, "CORTE_CABELO");

INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário B', 2);
INSERT INTO funcionario_servicos (funcionario_id, servico) VALUES (2, "CORTE_CABELO");

INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário C', 2);
INSERT INTO funcionario_servicos (funcionario_id, servico) VALUES (3, "CORTE_CABELO");

INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário D', 3);
INSERT INTO funcionario_servicos (funcionario_id, servico) VALUES (4, "CORTE_CABELO");

INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário E', 3);
INSERT INTO funcionario_servicos (funcionario_id, servico)VALUES (5, "CORTE_CABELO");

INSERT INTO Funcionario (nome, salao_residente_id) VALUES ('Funcionário F', 3);
INSERT INTO funcionario_servicos (funcionario_id, servico) VALUES (6, "CORTE_CABELO");



INSERT INTO Agendamento (cliente_id, salao_id, funcionario_id, data_inicio, data_fim, servico)
VALUES (1, 1, 1, '2024-05-11 09:00:00', '2024-05-11 10:00:00', 'Corte de Cabelo');
