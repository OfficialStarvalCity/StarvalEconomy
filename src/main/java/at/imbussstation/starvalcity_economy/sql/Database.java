package at.imbussstation.starvalcity_economy.sql;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class Database {

    private String host, port, datenbank,user,password;
    private Connection con;
    private Statement statement;
    private DatabaseMetaData databaseMetaData;
    private AutoReconnector autoReconnector;

    public Database(String host, String port, String datenbank, String user, String password) {
        this.host = host;
        this.port = port;
        this.datenbank = datenbank;
        this.user = user;
        this.password = password;
        this.autoReconnector = new AutoReconnector(this);
    }

    public void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ datenbank +"?autoReconnect=true", user, password);
                System.out.println("[MySQL] Verbindung zu "+datenbank+" aufgebaut!");

                statement = con.createStatement();
                databaseMetaData = con.getMetaData();
                autoReconnector.run();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        if(autoReconnector != null) {
            autoReconnector.stop();
        }
        if (isConnected()) {
            try {
                con.close();
                System.out.println("[MySQL] Verbindung zu "+datenbank+" getrennt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return (con != null);
    }

    public void update(String qry) {
        if (isConnected()) {
            try {con.createStatement().execute(qry);
            } catch (SQLException var2) {var2.printStackTrace();}
        }
    }

    public void createTable(final String tableName, final String... args) {
        if(!isConnected()) {
            return;
        }

        String arg = "";
        for(final String argument : args) {
            arg += arg.equals("") ? argument : ", " + argument;
        }

        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS " + tableName + " (" + arg + ")").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class AutoReconnector {
        public final Timer timer = new Timer();
        public final Database database;

        public AutoReconnector(final Database database) {
            this.database = database;
        }

        public void run() {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        database.getStatement().execute("USE " + database.getDatenbank());
                    } catch (SQLException exception) {
                        System.out.println("Error on handle reconnector: " + exception);
                    }
                }
            }, 0, 1000 * 60 * 10);
        }

        public void stop() {
            timer.cancel();
        }
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatenbank() {
        return datenbank;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return con;
    }

    public Connection getCon() {return con;}

    public Statement getStatement() {return statement;}

    public DatabaseMetaData getDatabaseMetaData() {return databaseMetaData;}

    public AutoReconnector getAutoReconnector() {return autoReconnector;}
}

