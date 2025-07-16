import React, { useEffect, useState } from "react";
import { listEmployees, deleteEmployee } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate(); // ✅ 在组件顶层调用

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function addNewEmployee() {
    navigate("/add-employee"); // ✅ 使用 navigate 函数
  }

  function editEmployee(id) {
    navigate(`/edit-employee/${id}`); // 导航到编辑页面
  }

  function removeEmployee(id) {
    // 二次确认对话框
    const isConfirmed = window.confirm('Are you sure you want to delete this employee?');
    
    if (isConfirmed) {
      deleteEmployee(id)
        .then(() => {
          console.log('Employee deleted successfully');
          // 删除成功后重新获取员工列表
          listEmployees()
            .then((response) => {
              setEmployees(response.data);
            })
            .catch((error) => {
              console.error('Error refreshing employee list:', error);
            });
        })
        .catch((error) => {
          console.error('Error deleting employee:', error);
          alert('Failed to delete employee. Please try again.');
        });
    }
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>
                <button className="btn btn-info me-2" onClick={() => editEmployee(employee.id)}>Edit</button>
                <button className="btn btn-danger" onClick={() => removeEmployee(employee.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
