package by.dach.dao;

import by.dach.models.CustomObjectForReport;
import by.dach.models.Item;
import by.dach.models.MyCustomObject;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDAO {

    public void save(Item item) {
        try {
            PreparedStatement preparedStatement =
                    DBConnect.connection.prepareStatement("INSERT INTO item (person_id, name, quantity, store_id, date) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, item.getPersonId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getQuantity());
            preparedStatement.setInt(4, item.getStoreId());
            preparedStatement.setString(5,item.getDate());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Item> show(int personId) {
        List<Item> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM item WHERE person_id = ?";
            PreparedStatement preparedStatement = DBConnect.connection.prepareStatement(sql);
            preparedStatement.setInt(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setPersonId(resultSet.getInt("person_id"));
                item.setName(resultSet.getString("name"));
                item.setQuantity(resultSet.getInt("quantity"));
                item.setStoreId(resultSet.getInt("store_id"));
                item.setDate(resultSet.getString("date"));
                list.add(item);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<MyCustomObject> showAll() {
        List<MyCustomObject> list = new ArrayList<>();
        try {
            String sql = "select person.id, person.name, person.email, item.name, item.quantity, item.date from person inner join item on item.person_id = person.id";
            PreparedStatement preparedStatement = DBConnect.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MyCustomObject myCustomObject = new MyCustomObject();
                myCustomObject.setPersonId(resultSet.getInt(1));
                myCustomObject.setName(resultSet.getString(2));
                myCustomObject.setEmail(resultSet.getString(3));
                myCustomObject.setItemName(resultSet.getString(4));
                myCustomObject.setItemQuantity(resultSet.getInt(5));
                myCustomObject.setDate(resultSet.getString(6));
                list.add(myCustomObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<CustomObjectForReport> getReport (int id){
        List<CustomObjectForReport> list = new ArrayList<>();
        try {
            String sql = "select person.id, person.name, item.name, item.quantity, item.date from item inner join person on item.person_id = person.id where store_id = ?";
                PreparedStatement preparedStatement = DBConnect.connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    CustomObjectForReport customObjectForReport = new CustomObjectForReport();
                    customObjectForReport.setPersonId(resultSet.getInt(1));
                    customObjectForReport.setPersonName(resultSet.getString(2));
                    customObjectForReport.setItemName(resultSet.getString(3));
                    customObjectForReport.setQuantity(resultSet.getInt(4));
                    customObjectForReport.setDate(resultSet.getString(5));
                    list.add(customObjectForReport);
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
