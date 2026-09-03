import { Link } from "react-router-dom";

export function HomePage() {
  return (
    <section>
      <p className="eyebrow">Home Page</p>
      <p>Welcome to sketch arena. Coming Soon...</p>
      <Link className="primary-link" to="/login"></Link>
    </section>
  );
}
