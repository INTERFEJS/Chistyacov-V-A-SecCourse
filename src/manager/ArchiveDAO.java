package manager;

import domain.Archive;
import repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArchiveDAO {
    private static final String SELECT_ALL_ARCHIVES = "SELECT * FROM archive.public.archive";
    private static final String INSERT_ARCHIVES = "INSERT INTO archive.public.archive (title, date_of_create, data) VALUES (?, ?, ?)";
    private static final String UPDATE_ARCHIVES = "UPDATE archive.public.archive SET title = ?, date_of_create = ?, data = ? WHERE id = ?";
    private static final String DELETE_ARCHIVES = "DELETE FROM archive.public.archive WHERE id = ?";

    public List<Archive> getAllArchives() {
        List<Archive> archives = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ARCHIVES);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Archive archive = new Archive();
                archive.setId(resultSet.getInt("id"));
                archive.setTitle(resultSet.getString("title"));
                archive.setDateOfCreate(resultSet.getString("date_of_create"));
                archive.setData(resultSet.getString("data"));

                archives.add(archive);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return archives;
    }

    public void addArchives(Archive archive) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ARCHIVES)) {

            statement.setString(1, archive.getTitle());
            statement.setString(2, archive.getDateOfCreate());
            statement.setString(3, archive.getData());


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateArchives(Archive archive) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ARCHIVES)) {

            statement.setString(1, archive.getTitle());
            statement.setString(2, archive.getDateOfCreate());
            statement.setString(3, archive.getData());
            statement.setInt(4, archive.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteArchives(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ARCHIVES)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Другие методы для обновления, удаления и редактирования программ
}