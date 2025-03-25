package be.vdab.taken;

import be.vdab.theorie.RepositoryException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcWoonplaatsRepository extends AbstractRepository {
    List<String> findMetStreepjes() {
        var metStreepjes = new ArrayList<String>();
        var sql = """
                    SELECT naam
                    FROM woonplaatsen
                    WHERE naam LIKE '%-%'
                """;
        try (var connection = super.getConnection();
             var statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            for (var result = statement.executeQuery(); result.next(); ) {
                metStreepjes.add(result.getString("naam"));
            }
            connection.commit();
            return metStreepjes;
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }
    }
}
