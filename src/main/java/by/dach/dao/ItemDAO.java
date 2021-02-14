package by.dach.dao;

import by.dach.models.*;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDAO {

    public void save(Item item) {
        try {
            PreparedStatement preparedStatement =
                    DBConnect.connection.prepareStatement("INSERT INTO item (person_id, name, quantity, store_id, date, price) " +
                            "VALUES (?,?,?,?,?, ?)");
            preparedStatement.setInt(1, item.getPersonId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getQuantity());
            preparedStatement.setInt(4, item.getStoreId());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(item.getDate()));
            preparedStatement.setInt(6, item.getPrice());
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
                item.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                item.setPrice(resultSet.getInt("price"));
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
            String sql = "select person.id, person.name, person.email, item.name, item.quantity, item.date, item.price " +
                    "from person inner join item on item.person_id = person.id";
            PreparedStatement preparedStatement = DBConnect.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MyCustomObject myCustomObject = new MyCustomObject();
                myCustomObject.setPersonId(resultSet.getInt(1));
                myCustomObject.setName(resultSet.getString(2));
                myCustomObject.setEmail(resultSet.getString(3));
                myCustomObject.setItemName(resultSet.getString(4));
                myCustomObject.setItemQuantity(resultSet.getInt(5));
                myCustomObject.setDate(resultSet.getTimestamp(6).toLocalDateTime());
                myCustomObject.setItemPrice(resultSet.getInt(7));
                list.add(myCustomObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<CustomObjectForReport> getReport(int id) {
        List<CustomObjectForReport> list = new ArrayList<>();
        try {
            String sql = "select person.id, person.name, item.name, item.quantity, item.date " +
                    "from item inner join person on item.person_id = person.id where store_id = ?";
            PreparedStatement preparedStatement = DBConnect.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CustomObjectForReport customObjectForReport = new CustomObjectForReport();
                customObjectForReport.setPersonId(resultSet.getInt(1));
                customObjectForReport.setPersonName(resultSet.getString(2));
                customObjectForReport.setItemName(resultSet.getString(3));
                customObjectForReport.setQuantity(resultSet.getInt(4));
                customObjectForReport.setDate(resultSet.getTimestamp(5).toLocalDateTime());
                list.add(customObjectForReport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<DateReport> showDateOrders() {
        List<DateReport> list = new ArrayList<>();
        try {
            String sql = "select i.date,p.name,p.email, s.name, s.type, i.name,i.quantity,p.id " +
                    "from person p inner join item i on p.id = i.person_id inner join store s " +
                    "on i.store_id = s.id order by date;";
            Statement statement = DBConnect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DateReport dateReport = new DateReport();
                dateReport.setDate(resultSet.getTimestamp(1).toLocalDateTime());
                dateReport.setPersonName(resultSet.getString(2));
                dateReport.setPersonEmail(resultSet.getString(3));
                dateReport.setStoreName(resultSet.getString(4));
                dateReport.setStoreType(resultSet.getString(5));
                dateReport.setItemName(resultSet.getString(6));
                dateReport.setQuantity(resultSet.getInt(7));
                dateReport.setPersonId(resultSet.getInt(8));
                list.add(dateReport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<SecondReport> getSecondReport(SecondReport secondReport) {
        List<SecondReport> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        String sql1 = "select store.name, ";
        String sql2 = "";
        String sql3 = "(price) as temp from item inner join store on item.store_id = store.id";
        String sql4 = "";
        String sql5 = " group by store.name;";
        switch (secondReport.getChose()) {
            case 'c':
                sql2 = "count";
                break;
            case 's':
                sql2 = "sum";
                break;
            default:
                sql2 = null;
        }
        if (secondReport.getDays() != 0) {
            StringBuilder partOfSql = new StringBuilder(" where date between '");
            LocalDateTime localDateTime = LocalDateTime.now();
            partOfSql.append(localDateTime.minusDays(secondReport.getDays()));
            partOfSql.append("' and '");
            partOfSql.append(localDateTime.toString());
            partOfSql.append("'");
            sql4 = partOfSql.toString();
        }
        sql.append(sql1).append(sql2).append(sql3).append(sql4).append(sql5);
        try {
            Statement statement = DBConnect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
           // System.out.println(sql);
            while (resultSet.next()) {
                SecondReport secondReportDb = new SecondReport();
                secondReportDb.setStoreName(resultSet.getString("name"));
                secondReportDb.setTemp(resultSet.getInt("temp"));
                list.add(secondReportDb);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
