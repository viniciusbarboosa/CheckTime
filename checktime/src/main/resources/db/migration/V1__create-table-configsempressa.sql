CREATE TABLE config_empresa(
    id TEXT PRIMARY KEY NOT NULL UNIQUE,
    nome_empresa TEXT NOT NULL,
    hora_padrao_entrada INTEGER NOT NULL,
    hora_padrao_saida INTEGER NOT NULL,
    hora_padrao_intervalo INTEGER NOT NULL
);