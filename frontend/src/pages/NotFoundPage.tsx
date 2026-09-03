import { Link } from "react-router-dom";

export function NotFoundPage() {
  return (
    <section>
      <p className="eyebrow">Error Code: 404</p>
      <h1>Page not found</h1>
      <Link to="/">Return Home</Link>
    </section>
  );
}
