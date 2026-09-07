import { Link } from "react-router-dom";
import { ScreenFrame } from "../components/ScreenFrame";

export function DashboardPage() {
  return (
    <ScreenFrame>
      <section>
        <p>Welcome</p>
        <h1>H'artist</h1>
        <nav aria-label="Dashboard Options">
          <button type="button">
            <strong>View Organisation</strong>
            <b>›</b>
          </button>
          <Link to="/games">
            <strong>View Gamed</strong>
            <b>›</b>
          </Link>
        </nav>
      </section>
    </ScreenFrame>
  );
}
