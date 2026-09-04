import { NavLink, Outlet } from "react-router-dom";

export function AppLayout() {
  return (
    <div>
      <header>
        <NavLink to="/">Sketch Arena</NavLink>
        <nav aria-label="Primary Navigation">
          <NavLink to="/">Home</NavLink>
          <NavLink to="/dashboard">Dashboard</NavLink>
          <NavLink to="/login">Login</NavLink>
        </nav>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}
