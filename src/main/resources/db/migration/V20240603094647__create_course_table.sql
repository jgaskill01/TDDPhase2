CREATE TABLE course(
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title TEXT NOT NULL ,
    description TEXT,
    number TEXT NOT NULL
)