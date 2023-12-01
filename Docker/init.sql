
--- Tablas de  Auditoria
-- Table: Pr_Category_Audit
CREATE TABLE Pr_Category_Audit (
    id_audit SERIAL PRIMARY KEY,
    table_name VARCHAR(255) NOT NULL,
    operation VARCHAR(10) NOT NULL,
    id_category UUID,
    category VARCHAR(50),
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50),
    audit_timestamp TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
-- Table: Pr_Discount_Audit
CREATE TABLE Pr_Discount_Audit (
    id_audit SERIAL PRIMARY KEY,
    id_discount UUID,
    discount NUMERIC(3, 2),
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50),
    action_type VARCHAR(10),
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Table: Pr_Brand_Audit
CREATE TABLE Pr_Brand_Audit (
    id_audit SERIAL PRIMARY KEY,
    id_brand UUID,
    brand_name VARCHAR(50),
    description VARCHAR(500),
    code_image VARCHAR(500),
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50),
    action_type VARCHAR(10),
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
--- Tablas de  Base de datos
-- Table: Pr_Category 
CREATE TABLE Pr_Category (
    id_category UUID DEFAULT uuid_generate_v4() NOT NULL,
    category VARCHAR(50) UNIQUE,
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50),
    PRIMARY KEY (id_category)
);
-- Table: Pr_Discount
CREATE TABLE Pr_Discount (
    id_discount UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    discount NUMERIC(3, 2),
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50)
);
-- Table: Pr_Brand
CREATE TABLE Pr_Brand (
    id_brand UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    brand_name VARCHAR(50) UNIQUE,
    description VARCHAR(500),
    code_image VARCHAR(500),
    status INTEGER,
    version VARCHAR(50),
    tx_date DATE,
    tx_user VARCHAR(50),
    tx_host VARCHAR(50)
);
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
-- Table: Aud_Login
--- Indice de las Tablas 
-- Índice para la tabla Pr_Category
CREATE INDEX idx_category ON Pr_Category(category);
-- Índice para la tabla Pr_Discount
CREATE INDEX idx_discount ON Pr_Discount(discount);
-- Índice para la tabla Pr_brand
CREATE INDEX idx_brand_name ON Pr_Brand (brand_name);
--- Trigger de Base de datos
-- Trigger para auditar la tabla Pr_Category
CREATE OR REPLACE FUNCTION audit_pr_category()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO Pr_Category_Audit (table_name, operation, id_category, category, status, version, tx_date, tx_user, tx_host)
        VALUES ('Pr_Category', 'INSERT', NEW.id_category, NEW.category, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host);
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO Pr_Category_Audit (table_name, operation, id_category, category, status, version, tx_date, tx_user, tx_host)
        VALUES ('Pr_Category', 'UPDATE', NEW.id_category, NEW.category, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_trigger
AFTER INSERT OR UPDATE ON Pr_Category
FOR EACH ROW EXECUTE FUNCTION audit_pr_category();
-- Trigger para auditar la tabla Pr_Discount
CREATE OR REPLACE FUNCTION audit_pr_discount()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO Pr_Discount_Audit (table_name, operation, id_discount, discount, status, version, tx_date, tx_user, tx_host)
        VALUES ('Pr_Discount', 'INSERT', NEW.id_discount, NEW.discount, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host);
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO Pr_Discount_Audit (table_name, operation, id_discount, discount, status, version, tx_date, tx_user, tx_host)
        VALUES ('Pr_Discount', 'UPDATE', NEW.id_discount, NEW.discount, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_trigger_discount
AFTER INSERT OR UPDATE ON Pr_Discount
FOR EACH ROW EXECUTE FUNCTION audit_pr_discount();
-- Trigger para auditar la tabla pr_brand_audit_trigger
CREATE OR REPLACE FUNCTION pr_brand_audit_trigger()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO Pr_Brand_Audit (id_brand, brand_name, description, code_image, status, version, tx_date, tx_user, tx_host, action_type)
        VALUES (NEW.id_brand, NEW.brand_name, NEW.description, NEW.code_image, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host, 'INSERT');
        RETURN NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO Pr_Brand_Audit (id_brand, brand_name, description, code_image, status, version, tx_date, tx_user, tx_host, action_type)
        VALUES (NEW.id_brand, NEW.brand_name, NEW.description, NEW.code_image, NEW.status, NEW.version, NEW.tx_date, NEW.tx_user, NEW.tx_host, 'UPDATE');
        RETURN NEW;
    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO Pr_Brand_Audit (id_brand, brand_name, description, code_image, status, version, tx_date, tx_user, tx_host, action_type)
        VALUES (OLD.id_brand, OLD.brand_name, OLD.description, OLD.code_image, OLD.status, OLD.version, OLD.tx_date, OLD.tx_user, OLD.tx_host, 'DELETE');
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

-- Asociar el trigger a la tabla Pr_Brand
CREATE TRIGGER pr_brand_audit
AFTER INSERT OR UPDATE OR DELETE
ON Pr_Brand
FOR EACH ROW
EXECUTE FUNCTION pr_brand_audit_trigger();