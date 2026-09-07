import { Link } from "react-router-dom";
import { ScreenFrame } from "../components/ScreenFrame";

export function LandingPage() {
  return (
    <ScreenFrame>
      <section>
        <p>Draw ur h'art out</p>
        <h1>
          DRAW <span>/</span> GUESS <span>/</span> REPEAT <span>/</span>
        </h1>
        <div>
          <Link to="/login">Login</Link>
          <Link to="/register">Register</Link>
        </div>
      </section>
    </ScreenFrame>
  );
}
