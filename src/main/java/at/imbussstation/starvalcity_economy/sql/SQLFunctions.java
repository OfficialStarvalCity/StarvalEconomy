package at.imbussstation.starvalcity_economy.sql;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLFunctions {
    private Database database;

    /**
     * Constructor for all SQL-Functions
     *
     * @param database Parameter for the Database you want to take the values from!
     */
    public SQLFunctions(Database database) {
        this.database = database;
    }

    /**
     * Method to return an Integer value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Integer you are searching for or '0'
     */
    public int getInt(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getInt(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * Method to return a Double value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Double you are searching for or '0'
     */
    public double getDouble(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getDouble(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Method to return a String value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the String you are searching for or 'null'
     */
    public String getString(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getString(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to return a Boolean value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Boolean you are searching for or 'false'
     */
    public boolean getBoolean(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getBoolean(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to return a Long value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Long you are searching for or 'null'
     */
    public Long getLong(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getLong(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to return a Float value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Float you are searching for or 'null'
     */
    public Float getFloat(String table, String column, String identifier, String value) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) return rs.getFloat(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<String> getResultsString(String table, String column) {
        List<String> list = new ArrayList<>();

        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT " + column + " FROM " + table).executeQuery();
            while (rs.next())
                list.add(rs.getString(column));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<Integer> getResultsInteger(String table, String column) {
        List<Integer> list = new ArrayList<>();

        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT " + column + " FROM " + table).executeQuery();
            while (rs.next())
                list.add(rs.getInt(column));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Method to return a List value from an Text Column
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the List you are searching for
     */
    public List<String> getList(String table, String column, String identifier, String value) {
        List<String> list = new LinkedList<>();
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'").executeQuery();
            if (rs.next()) {
                String s = rs.getString(column);
                if (s != null && !s.equalsIgnoreCase("[]")) {
                    String[] arrayOfString;
                    int i = (arrayOfString = s.replace("[", "").replace("]", "").split(", ")).length;

                    for (byte b = 0; b < i; ++b) {
                        String string = arrayOfString[b];
                        list.add(string.trim());
                    }
                }
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return list;
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @return Returns true if the Table contains content
     */
    public boolean nullCheck(String table) {
        try {
            ResultSet rs = database.getConnection().prepareStatement("SELECT * From " + table).executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    /**
     * Method to check if a Table exists
     * @param table
     * @return Returns true if the Table exists
     */
    public boolean tableExists(String table) {
        try {
            ResultSet rs = database.getDatabaseMetaData().getTables(null, null, table, null);
            return rs.next();
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    /**
     * Method to get the Database
     *
     * @return Database
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * Method to set the Database
     *
     * @param database Database to set
     */
    public void setDatabase(Database database) {
        this.database = database;
    }
}
