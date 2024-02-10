package org.example.repositories.interfaces;

import org.example.models.Table;

import java.util.List;

public interface ITableRepository {
 boolean createTable(Table table);
 Table getTable(short id);
 List<Table> getAllTables();

}
