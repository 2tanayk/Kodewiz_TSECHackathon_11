package com.edu4sure.myerp.sql.mdb;

public class Constants
{
    static final String ORDER_ID = "id";
    static final String CUSTOMER_ID = "customer_id";
    static final String ORDER_DATE =  "order_date";
    static final String STATUS = "status";

    static final String DB_NAME = "orders";
    static final String TB_NAME = "orders";
    static final int DB_VERSION = 1;


    static final String CREATE_TB = "CREATE TABLE `orders` (\n" +
            "  `order_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `customer_id` int(11) NOT NULL,\n" +
            "  `order_date` date NOT NULL,\n" +
            "  `status` tinyint(4) NOT NULL DEFAULT '1',\n" +
            "  `comments` varchar(2000) DEFAULT NULL,\n" +
            "  `shipped_date` date DEFAULT NULL,\n" +
            "  `shipper_id` smallint(6) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`order_id`),\n" +
            "  KEY `fk_orders_customers_idx` (`customer_id`),\n" +
            "  KEY `fk_orders_shippers_idx` (`shipper_id`),\n" +
            "  KEY `fk_orders_order_statuses_idx` (`status`),\n" +
            "  CONSTRAINT `fk_orders_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE,\n" +
            "  CONSTRAINT `fk_orders_order_statuses` FOREIGN KEY (`status`) REFERENCES `order_statuses` (`order_status_id`) ON UPDATE CASCADE,\n" +
            "  CONSTRAINT `fk_orders_shippers` FOREIGN KEY (`shipper_id`) REFERENCES `shippers` (`shipper_id`) ON UPDATE CASCADE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
    static final String DROP_TB = "DROP TABLE IF EXISTS " + TB_NAME;

}
