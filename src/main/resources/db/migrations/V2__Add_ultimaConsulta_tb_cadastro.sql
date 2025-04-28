--Migrations para adicionar a coluna de ultimaConsulta na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN ultima_consulta TIMESTAMP