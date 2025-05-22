# OOP_N03_Term3_2025_K17_Group7
# 📚 Quản Lý Thư Viện - Java OOP + MySQL
# 📌 Giới thiệu:

Dự án Java OOP với tích hợp MySQL
Dự án này là một ứng dụng dựa trên ngôn ngữ lập trình Java, được phát triển theo các nguyên lý của lập trình hướng đối tượng (OOP). Ứng dụng kết nối với cơ sở dữ liệu MySQL để lưu trữ và truy xuất dữ liệu. Dự án mô phỏng một hệ thống quản lý thư viện đơn giản, cho phép thủ thư và người đọc quản lý và truy cập dữ liệu sách cũng như các giao dịch mượn/trả sách
# 👥 Thành viên
1. Dinh Long Vu
2. Nguyen Van Tu
3. Nguyen Thanh Dat

# 🧰 Công nghệ sử dụng
Java: Ngôn ngữ lập trình chính.

MySQL: Hệ quản trị cơ sở dữ liệu quan hệ để lưu trữ và quản lý dữ liệu.

JDBC (Java Database Connectivity): Được sử dụng để kết nối và tương tác với MySQL.

Eclipse/IntelliJ IDEA: Môi trường phát triển tích hợp (IDE) để xây dựng và chạy ứng dụng.

# Đối tượng cơ sở
- Thư viện
- Sách
- Users
- Students


# Nội dung 1:
Project: Xây dựng ứng dụng quản lý thư viện. Yêu cầu chính:
- Java Spring Boot
- Giao diện đơn giản
- Dữ liệu lưu vào file nhị phân
- Lưu trữ nội bộ bằng các Collection như ArrayList , Map , LinkedList,...
# Chức năng chính:
📚 Quản lý Sách
- Thêm, sửa, xóa sách
- Liệt kê danh sách sách
- Lọc sách theo thể loại, tác giả, năm xuất bản,...
  
👤 Quản lý Độc giả
- Thêm, sửa, xóa độc giả
- Liệt kê độc giả
  
🔁 Gán sách cho độc giả (Tạo phiếu mượn)
Gán Book cho Reader → Tạo mới BorrowRecord

🛠️ Chức năng mở rộng
- Tìm kiếm sách theo tên hoặc từ khóa
- Kiểm tra sách còn trong kho hay đã mượn
- Trả sách → cập nhật returnDate của BorrowRecord
- Xuất báo cáo mượn/trả theo tháng
# Nội dung 2:
- UML Class Diagram (mô tả mối quan hệ giữa các lớp):
![image](https://github.com/user-attachments/assets/77ac0b69-48ae-458c-b627-97bd6e435b1c)

# Nội dung 3:
![image](https://github.com/user-attachments/assets/1014731c-51df-4682-9957-9cca20c883a7)

