import EmployeeComponent from "./components/EmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import "./App.css"; // 确保引入了样式文件

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <div className="main-content">
          <Routes>
            {/* http://localhost:5173/ */}
            <Route path="/" element={<ListEmployeeComponent />} />
            {/* // http://localhost:5173/employees */}
            <Route
              path="/employees"
              element={<ListEmployeeComponent />}
            ></Route>
            <Route path="/add-employee" element={<EmployeeComponent />}></Route>
            <Route
              path="/edit-employee/:id"
              element={<EmployeeComponent />}
            ></Route>
          </Routes>
        </div>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
