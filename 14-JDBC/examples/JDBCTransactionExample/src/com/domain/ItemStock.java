package com.domain;

import java.sql.SQLException;

public interface ItemStock extends AutoCloseable {
    public String getItemList() throws SQLException;
}
