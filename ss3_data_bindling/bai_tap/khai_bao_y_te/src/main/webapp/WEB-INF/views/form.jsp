
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Form Medical</title>
</head>
<body>
<h1>Tờ khai báo y tế</h1>
<h2 style="color: red">Khuyến cáo : Khai báo sai là quy phạm pháp luật việt nam</h2>
<form:form action="create" modelAttribute="medical" method="post">
    <div>
        họ tên(ghi chữ IN HOA)<form:input type="text" path="ten" value="${medical.ten}"/>
    </div>
    <div>
        năm sinh<form:input type="number" path="namSinh" value="${medical.namSinh}"/>
    </div>
    <div>
        <form:select path="gioiTinh" itemValue="${medical.gioiTinh}">
            <option value="">-chọn-</option>
            <option value="Nam">Nam</option>
            <option value="Nu">Nữ</option>
        </form:select>
    </div>
    <div>
        <form:select path="quocTich" itemValue="${medical.quocTich}">
            <option value="Việt Nam">Việt Nam</option>
            <option value="Mỹ">Lào</option>
            <option value="Anh">Trung Quốc</option>
        </form:select>
    </div>
    <div>
        Số CMND <form:input type="number" path="cmnd" value="${medical.cmnd}"/>
    </div>
    <div>
        <form:checkbox path="phuongTien" value="tàu bay"/>tàu bay
        <form:checkbox path="phuongTien" value="tàu thuyền"/>tàu thuyền
        <form:checkbox path="phuongTien" value="ô tô"/>ô tô
        <form:checkbox path="phuongTien" value="khác"/>khác(ghi rõ)
    </div>
    <div>
        Số hiệu phương tiện <form:input type="text" path="soHieuPhuongTien" value="${medical.soHieuPhuongTien}"/>
    </div>
    <div>
        Số ghế <form:input type="text" path="soGhe" value="${medical.soGhe}"/>
    </div>
    <div>
        ngày khởi hành: <form:input type="date" path="ngayKhoiHanh" value="${medical.ngayKhoiHanh}"/>
    </div>
    <div>
        ngày kết thúc: <form:input type="date" path="ngayKetThuc" value="${medical.ngayKetThuc}"/>
    </div>
    <div>
        trong vòng 40 ngày qua, đã đi dến thành phố lào ?
        <form:textarea path="diaDiem" value="${medical.diaDiem}"/>
    </div>
    <div>
        <input type="submit" value="gửi lời khai">
    </div>
</form:form>
</body>
</html>
