
--- Tablas de AArea de Auditoria
-- Table: Aud_Login
CREATE TABLE Aud_Login (
    Login_Id UUID  NOT NULL ,
    id_user UUID  NULL,
    Description varchar(50)  NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_Date date  NULL,
    tx_User varchar(50)  NULL,
    tx_Host varchar(50)  NULL,
    CONSTRAINT Aud_Login_pk PRIMARY KEY (Login_Id) 
);

-- Table: Aud_Person
CREATE TABLE Aud_Person (
    Id_person_Aud UUID  NOT NULL,
    People_name varchar(30)  NULL,
    Surname varchar(50)  NULL,
    Carnet varchar(50)  NULL,
    Phone varchar(50)  NULL,
    Address varchar(50)  NOT NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_Date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Person_pk PRIMARY KEY (Id_person_Aud)
);

-- Table: Aud_Pr_Brand
CREATE TABLE Aud_Pr_Brand (
    id_brand UUID  NOT NULL,
    brand varchar(50)  NULL,
    Description varchar(500)  NULL,
    code_image varchar(250)  NULL,
    status varchar(50)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Pr_Brand_pk PRIMARY KEY (id_brand)
);

-- Table: Aud_Pr_Discount
CREATE TABLE Aud_Pr_Discount (
    id_discount UUID  NOT NULL,
    discount decimal(6,8)  NULL,
    status varchar(30)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Pr_Discount_pk PRIMARY KEY (id_discount)
);

-- Table: Aud_Pr_Product
CREATE TABLE Aud_Pr_Product (
    id_product UUID  NOT NULL,
    kind_of_product_id_product_type UUID  NOT NULL,
    name_product varchar(30)  NULL,
    price decimal(5,7)  NULL,
    stock varchar(50)  NULL,
    description varchar(500)  NOT NULL,
    code_image varchar(50)  NULL,
    status varchar(50)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Pr_Product_pk PRIMARY KEY (id_product)
);

-- Table: Aud_Pr_Promotion
CREATE TABLE Aud_Pr_Promotion (
    id_promotion UUID  NOT NULL,
    Name_Promotion varchar(30)  NULL,
    Start_Date date  NULL,
    End_Date date  NULL,
    status boolean  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Pr_Promotion_pk PRIMARY KEY (id_promotion)
);

-- Table: Aud_Pr_kind_of_product
CREATE TABLE Aud_Pr_kind_of_product (
    id_product_type UUID  NOT NULL,
    kind_of_product varchar(30)  NULL,
    status varchar(30)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Pr_kind_of_product_pk PRIMARY KEY (id_product_type)
);

-- Table: Aud_Record_of_Entries
CREATE TABLE Aud_Record_of_Entries (
    id_Record_of_Entries uuid  NOT NULL,
    id_user UUID  NULL,
    Entry_date timestamp  NULL,
    Departure_date timestamp  NULL,
    status varchar(50)  NULL,
    version varchar(50)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Record_of_Entries_pk PRIMARY KEY (id_Record_of_Entries)
);

-- Table: Aud_Roles
CREATE TABLE Aud_Roles (
    id_roles_Aud UUID  NOT NULL,
    Roles varchar(50)  NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_Date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Aud_Roles_pk PRIMARY KEY (id_roles_Aud)
);

-- Table: Aud_User
CREATE TABLE Aud_User (
    id_user_Aud UUID  NOT NULL,
    login_user int  NULL,
    password_user int  NULL,
    Email varchar(50)  NOT NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_Date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    Aud_Person_Id_person_Aud UUID  NOT NULL,
    CONSTRAINT Aud_User_pk PRIMARY KEY (id_user_Aud)
);
--Tablas de Area de Producto
-- Table: Pr_Brand
CREATE TABLE Pr_Brand (
    id_brand UUID  NOT NULL,
    brand varchar(50)  NULL,
    Description varchar(500)  NULL,
    code_image varchar(250)  NULL,
    status varchar(50)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Pr_Brand_pk PRIMARY KEY (id_brand)
);

-- Table: Pr_Brand_has_Products
CREATE TABLE Pr_Brand_has_Products (
    Brand_id_brand UUID  NOT NULL,
    Product_id_product UUID  NOT NULL,
    CONSTRAINT Pr_Brand_has_Products_pk PRIMARY KEY (Brand_id_brand)
);

-- Table: Pr_Discount
CREATE TABLE Pr_Discount (
    id_discount UUID  NOT NULL,
    discount decimal(6,8)  NULL,
    status varchar(30)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Pr_Discount_pk PRIMARY KEY (id_discount)
);

-- Table: Pr_Product
CREATE TABLE Pr_Product (
    id_product UUID  NOT NULL,
    kind_of_product_id_product_type UUID  NOT NULL,
    name_product varchar(30)  NULL,
    price decimal(5,7)  NULL,
    stock varchar(50)  NULL,
    description varchar(500)  NOT NULL,
    code_image varchar(50)  NULL,
    status varchar(50)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Pr_Product_pk PRIMARY KEY (id_product)
);
--Tablas de Area de Promociones
-- Table: Pr_Promo_has_discount_has_producttion
CREATE TABLE Pr_Promo_has_discount_has_producttion (
    Product_id_product UUID  NOT NULL,
    Pr_Promotion_id_promotion UUID  NOT NULL,
    Pr_Discount_id_discount UUID  NOT NULL,
    Promotion_price decimal(5,7)  NULL,
    CONSTRAINT Pr_Promo_has_discount_has_producttion_pk PRIMARY KEY (Product_id_product)
);

-- Table: Pr_Promotion
CREATE TABLE Pr_Promotion (
    id_promotion UUID  NOT NULL,
    Name_Promotion varchar(30)  NULL,
    Start_Date date  NULL,
    End_Date date  NULL,
    status boolean  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Pr_Promotion_pk PRIMARY KEY (id_promotion)
);

-- Table: Pr_kind_of_product
CREATE TABLE Pr_kind_of_product (
    id_product_type UUID  NOT NULL,
    kind_of_product varchar(30)  NULL,
    status varchar(30)  NULL,
    version varchar(30)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Pr_kind_of_product_pk PRIMARY KEY (id_product_type)
);
--- Tablas de Area de Usuarios
-- Table: Use_Roles
CREATE TABLE Use_Roles (
    id_roles UUID  NOT NULL,
    Roles varchar(50)  NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_Date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NULL,
    CONSTRAINT Use_Roles_pk PRIMARY KEY (id_roles)
);

-- Table: Use_credit_card
CREATE TABLE Use_credit_card (
    idcredit_card UUID  NOT NULL,
    user_id_user UUID  NOT NULL,
    card_code int  NULL,
    expires date  NULL,
    card_title varchar(50)  NULL,
    card_issuer varchar(50)  NULL,
    CVV int  NULL,
    CONSTRAINT Use_credit_card_pk PRIMARY KEY (idcredit_card)
);

-- Table: Use_groups
CREATE TABLE Use_groups (
    Roles_id_roles UUID  NOT NULL,
    user_id_user UUID  NOT NULL,
    CONSTRAINT Use_groups_pk PRIMARY KEY (user_id_user)
);

-- Table: Use_person
CREATE TABLE Use_person (
    Id_person UUID  NOT NULL,
    people_name varchar(30)  NULL,
    Surnames varchar(30)  NULL,
    carnet varchar(30)  NULL,
    phone varchar(50)  NULL,
    address varchar(50)  NULL,
    CONSTRAINT Use_person_pk PRIMARY KEY (Id_person)
);

-- Table: Use_user
CREATE TABLE Use_user (
    id_user UUID  NOT NULL,
    person_Id_person UUID  NOT NULL,
    login_user varchar(50)  NULL,
    password_user varchar(50)  NULL,
    email varchar(50)  NULL,
    CONSTRAINT Use_user_pk PRIMARY KEY (id_user)
);
--- Tablas de Area de ventas
-- Table: Ve_Sale
CREATE TABLE Ve_Sale (
    id_Sale UUID  NOT NULL,
    Use_user_id_user UUID  NOT NULL,
    Product_id_product UUID  NOT NULL,
    Sale_price decimal(5,7)  NULL,
    amount_Sale int  NULL,
    Status varchar(50)  NULL,
    Version varchar(50)  NULL,
    tx_date date  NULL,
    tx_user varchar(50)  NULL,
    tx_host varchar(50)  NOT NULL,
    CONSTRAINT Ve_Sale_pk PRIMARY KEY (id_Sale)
);

-- Table: Ve_bill
CREATE TABLE Ve_bill (
    Ve_Sale_id_Sale UUID  NOT NULL,
    Description varchar(500)  NULL,
    CONSTRAINT Ve_bill_pk PRIMARY KEY (Ve_Sale_id_Sale)
);

-- foreign keys
-- Reference: Aud_User_Aud_Person (table: Aud_User)
ALTER TABLE Aud_User ADD CONSTRAINT Aud_User_Aud_Person
    FOREIGN KEY (Aud_Person_Id_person_Aud)
    REFERENCES Aud_Person (Id_person_Aud)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Brand_has_Products_Product (table: Pr_Brand_has_Products)
ALTER TABLE Pr_Brand_has_Products ADD CONSTRAINT Brand_has_Products_Product
    FOREIGN KEY (Product_id_product)
    REFERENCES Pr_Product (id_product)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Pr_Promo_has_discount_has_producttion_Pr_Discount (table: Pr_Promo_has_discount_has_producttion)
ALTER TABLE Pr_Promo_has_discount_has_producttion ADD CONSTRAINT Pr_Promo_has_discount_has_producttion_Pr_Discount
    FOREIGN KEY (Pr_Discount_id_discount)
    REFERENCES Pr_Discount (id_discount)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Pr_Promo_has_discount_has_producttion_Pr_Promotion (table: Pr_Promo_has_discount_has_producttion)
ALTER TABLE Pr_Promo_has_discount_has_producttion ADD CONSTRAINT Pr_Promo_has_discount_has_producttion_Pr_Promotion
    FOREIGN KEY (Pr_Promotion_id_promotion)
    REFERENCES Pr_Promotion (id_promotion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Pr_Promo_has_discount_has_producttion_Product (table: Pr_Promo_has_discount_has_producttion)
ALTER TABLE Pr_Promo_has_discount_has_producttion ADD CONSTRAINT Pr_Promo_has_discount_has_producttion_Product
    FOREIGN KEY (Product_id_product)
    REFERENCES Pr_Product (id_product)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Products_kind_of_product (table: Pr_Product)
ALTER TABLE Pr_Product ADD CONSTRAINT Products_kind_of_product
    FOREIGN KEY (kind_of_product_id_product_type)
    REFERENCES Pr_kind_of_product (id_product_type)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Sale_Product (table: Ve_Sale)
ALTER TABLE Ve_Sale ADD CONSTRAINT Sale_Product
    FOREIGN KEY (Product_id_product)
    REFERENCES Pr_Product (id_product)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Sale_Use_user (table: Ve_Sale)
ALTER TABLE Ve_Sale ADD CONSTRAINT Sale_Use_user
    FOREIGN KEY (Use_user_id_user)
    REFERENCES Use_user (id_user)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Table_46_Brand (table: Pr_Brand_has_Products)
ALTER TABLE Pr_Brand_has_Products ADD CONSTRAINT Table_46_Brand
    FOREIGN KEY (Brand_id_brand)
    REFERENCES Pr_Brand (id_brand)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Ve_bill_Ve_Sale (table: Ve_bill)
ALTER TABLE Ve_bill ADD CONSTRAINT Ve_bill_Ve_Sale
    FOREIGN KEY (Ve_Sale_id_Sale)
    REFERENCES Ve_Sale (id_Sale)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: credit_card_user (table: Use_credit_card)
ALTER TABLE Use_credit_card ADD CONSTRAINT credit_card_user
    FOREIGN KEY (user_id_user)
    REFERENCES Use_user (id_user)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groups_Roles (table: Use_groups)
ALTER TABLE Use_groups ADD CONSTRAINT groups_Roles
    FOREIGN KEY (Roles_id_roles)
    REFERENCES Use_Roles (id_roles)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groups_user (table: Use_groups)
ALTER TABLE Use_groups ADD CONSTRAINT groups_user
    FOREIGN KEY (user_id_user)
    REFERENCES Use_user (id_user)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_person (table: Use_user)
ALTER TABLE Use_user ADD CONSTRAINT user_person
    FOREIGN KEY (person_Id_person)
    REFERENCES Use_person (Id_person)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;