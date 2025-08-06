INSERT INTO tb_atendente(uuid, nome, email, senha, nivel_de_acesso) VALUES ('3dcd2fe4-f721-4644-bfd1-77a9e8e8e095','Paulo Ribeiro', 'paulo@gmail.com', '$2a$10$Ek0v1T0sqHCz.x1LPzTaLOJ0MxYcb.EVFXtoHZHTSusTpL3xqgYsS', 0);

INSERT INTO tb_medico (uuid, crm, nome, especialidade, email, telefone, logradouro, numero, complemento, cidade, uf, cep) VALUES ('893074e9-6b30-4d34-8a55-c6de306d6f75','1234-SP', 'Dr. André Souza', 0, 'andre@medico.com', '11999990001', 'Rua A', 123, 'Apto 1', 'São Paulo', 'SP', '01000-000');
INSERT INTO tb_medico (uuid, crm, nome, especialidade, email, telefone, logradouro, numero, complemento, cidade, uf, cep) VALUES ('b867fde8-d0a8-4f1c-95d3-d025e2feab1f','4321-SP', 'Dra. Bianca Lima', 2, 'bianca@medico.com', '11999990002', 'Av. Central', 456, NULL, 'Campinas', 'SP', '13000-000');

INSERT INTO tb_paciente (uuid, cpf, nome, email, telefone, logradouro, numero, complemento, cidade, uf, cep) VALUES ('d6f24413-0f21-4e19-966a-f540f15ff27e', '123.456.789-00', 'Marcos Oliveira', 'marcos@paciente.com', '11988880001', 'Rua A', 123, 'Apto 1', 'São Paulo', 'SP', '01000-000');
INSERT INTO tb_paciente (uuid, cpf, nome, email, telefone, logradouro, numero, complemento, cidade, uf, cep) VALUES ('5fabf1bf-2804-4d85-9f0b-9fe00ec607a1', '987.654.321-00', 'Fernanda Costa', 'fernanda@paciente.com', '11988880002', 'Av. Central', 456, NULL, 'Campinas', 'SP', '13000-000');

INSERT INTO tb_consulta (uuid, crm_medico, cpf_paciente, dataehora, status) VALUES ('176acd71-663b-46ef-b8b9-352a18392ed4', '1234-SP', '123.456.789-00', '2025-08-10T09:00:00', 0);
INSERT INTO tb_consulta (uuid, crm_medico, cpf_paciente, dataehora, status) VALUES ('6bdd07f2-cbb4-4ad3-af94-7f53ee028518', '4321-SP', '987.654.321-00', '2025-08-11T14:30:00', 2);
