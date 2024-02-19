package org.example.repositories.interfaces;

import org.example.models.Table;

import java.util.List;

public interface ITableRepository {
 boolean createTable(Table table);
 Table getTable(short id);
 List<Table> getAllTables();
 boolean reserveTable(short id);
 boolean editInfo(short id, String firstName, String secondName, short capacity, String phoneNumber);
 boolean deleteTable(short id);
}
