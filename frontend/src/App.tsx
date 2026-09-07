import { Route, Routes } from "react-router-dom";
import { DashboardPage } from "./pages/Dashboard";
import { LandingPage } from "./pages/LandingPage";
import { AuthPage } from "./pages/AuthPage";
import { NotFoundPage } from "./pages/NotFoundPage";
import { GameLibraryPage } from "./pages/GameLibraryPage";
// import { AppLayout } from "./app/AppLayout";
import "./App.css";

function App() {
  return (
    <Routes>
      {/* <Route element={<AppLayout />}> */}
      {/* home page at / */}
      <Route index element={<LandingPage />} />

      <Route path="/login" element={<AuthPage mode="login" />} />
      <Route path="/register" element={<AuthPage mode="register" />} />

      <Route path="dashboard" element={<DashboardPage />} />
      <Route path="games" element={<GameLibraryPage />} />
      {/* wildcard route - matches any location not in the earlier routes */}
      <Route path="*" element={<NotFoundPage />} />
    </Routes>
  );
}

export default App;
