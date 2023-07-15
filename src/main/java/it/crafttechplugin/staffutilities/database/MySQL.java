package it.crafttechplugin.staffutilities.database;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class MySQL {

    private BasicDataSource connectionPool;

    public MySQL(BasicDataSource connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    public void createTables() {
        // BANS
        update("CREATE TABLE IF NOT EXISTS bans (" +
                "`#` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "player_uuid VARCHAR(255), " +
                "end BIGINT, " +
                "reason VARCHAR(255))");

        //PLAYER_INFOS
        update("CREATE TABLE IF NOT EXISTS player_infos (" +
                "`#` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "player_uuid VARCHAR(255), " +
                "player_name VARCHAR(255))");

        //MUTES
        update("CREATE TABLE IF NOT EXISTS mutes (" +
                "`#` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "player_uuid VARCHAR(255), " +
                "end BIGINT)");
    }

    public void update(String qry) {
        try(Connection c = getConnection();
            PreparedStatement s = c.prepareStatement(qry)) {
            s.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Object query(String qry, Function<ResultSet, Object> consumer) {
        try(Connection c = getConnection();
            PreparedStatement s = c.prepareStatement(qry)) {
            ResultSet rs = s.executeQuery();
            return consumer.apply(rs);
        } catch(SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void query(String qry, Consumer<ResultSet> consumer) {
        try(Connection c = getConnection();
            PreparedStatement s = c.prepareStatement(qry)) {
            ResultSet rs = s.executeQuery();
            consumer.accept(rs);
        } catch(SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}