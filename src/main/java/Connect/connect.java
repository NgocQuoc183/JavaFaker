package Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    // Phương thức trả về đối tượng Connection để có thể tái sử dụng trong các class khác
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/shop";
        String username = "sa";  
        String password = "111";  // Mật khẩu cơ sở dữ liệu

        Connection connection = null;
        try {
            // Tạo kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();  // In ra lỗi chi tiết nếu có
        }
        return connection;
    }
    
    // Bạn có thể giữ phương thức main này để test kết nối
    public static void main(String[] args) {
        // Kiểm tra kết nối
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Kết nối đã được thiết lập.");
        }
    }
}
