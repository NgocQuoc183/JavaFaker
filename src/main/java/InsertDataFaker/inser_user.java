/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsertDataFaker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connect.connect;  // Import class connect
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValues;

/**
 *
 * @author QUOC
 */
public class inser_user {
     public static void main(String[] args) {
     Faker faker = new Faker();
      Connection connection = connect.getConnection();
      
      
        if (connection != null) {
            try {
                // Câu lệnh SQL để chèn dữ liệu vào bảng users
                String sql = "INSERT INTO users (user_name, password, email, phone_number) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Số lượng người dùng giả muốn thêm
                int numberOfUsers = 10;

                // Lặp để thêm 10 người dùng giả
                for (int i = 0; i < numberOfUsers; i++) {
                    String userName = faker.name().username();  // Tạo tên đăng nhập giả
                    String userPassword = faker.internet().password();  // Tạo mật khẩu giả
                    String email = faker.internet().emailAddress();  // Tạo email giả
                    String phoneNumber = faker.phoneNumber().cellPhone();  // Tạo số điện thoại giả

                    // Đặt các giá trị vào câu lệnh SQL
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, userPassword);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, phoneNumber);

                    // Thực thi câu lệnh
                    preparedStatement.executeUpdate();
                }

                System.out.println("Chèn dữ liệu thành công!");

                // Đóng kết nối sau khi hoàn tất
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
}
}