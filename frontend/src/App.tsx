import { Route, Routes } from "react-router-dom";
import { DashboardPage } from "./pages/Dashboard";
import { HomePage } from "./pages/HomePage";
import { LoginPage } from "./pages/LoginPage";
import { NotFoundPage } from "./pages/NotFoundPage";
import { AppLayout } from "./app/AppLayout";
import "./App.css";

function App() {
  return (
    <Routes>
      <Route element={<AppLayout />}>
        {/* home page at / */}
        <Route index element={<HomePage />} />
        {/* open LoginPage at /page */}
        <Route path="login" element={<LoginPage />} />
        <Route path="dashboard" element={<DashboardPage />} />
        {/* wildcard route - matches any location not in the earlier routes */}
        <Route path="*" element={<NotFoundPage />} />
      </Route>
    </Routes>
  );
}

export default App;
