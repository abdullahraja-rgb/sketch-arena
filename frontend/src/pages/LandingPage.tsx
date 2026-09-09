import { Link } from "react-router-dom";
import { ScreenFrame } from "../components/ScreenFrame";

export function LandingPage() {
  return (
    <ScreenFrame>
      <section className="landing-content">
        <p className="system-label">Draw ur h'art out</p>
        <h1>
          DRAW <span>/</span> GUESS <span>/</span> REPEAT <span>/</span>
        </h1>
        <div className="landing-actions">
          <Link className="action action-primary" to="/login">
            Login
          </Link>
          <Link className="action" to="/register">
            Register
          </Link>
        </div>
      </section>
    </ScreenFrame>
  );
}
