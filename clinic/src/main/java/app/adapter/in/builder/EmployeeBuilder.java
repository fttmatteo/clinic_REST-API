package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.Employee;
import app.domain.model.enums.Role;

public class EmployeeBuilder {
    private String fullName;
    private Integer document;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private String address;
    private Role role;
    private String userName;
    private String password;

    public EmployeeBuilder withFullName(String v){ this.fullName = v; return this; }
    public EmployeeBuilder withDocument(Integer v){ this.document = v; return this; }
    public EmployeeBuilder withEmail(String v){ this.email = v; return this; }
    public EmployeeBuilder withPhoneNumber(String v){ this.phoneNumber = v; return this; }
    public EmployeeBuilder withBirthDate(Date v){ this.birthDate = v; return this; }
    public EmployeeBuilder withAddress(String v){ this.address = v; return this; }
    public EmployeeBuilder withRole(Role v){ this.role = v; return this; }
    public EmployeeBuilder withUserName(String v){ this.userName = v; return this; }
    public EmployeeBuilder withPassword(String v){ this.password = v; return this; }

    public Employee build(){
        Employee x = new Employee();
        x.setFullName(fullName);
        x.setDocument(document);
        x.setEmail(email);
        x.setPhoneNumber(phoneNumber);
        x.setBirthDate(birthDate);
        x.setAddress(address);
        x.setRole(role);
        x.setUserName(userName);
        x.setPassword(password);
        return x;
    }
}
