import { useState } from "react";
import { Link } from "react-router-dom";
import { ScreenFrame } from "../components/ScreenFrame";

export function GameLibraryPage() {
  const [showDetails, setShowDetails] = useState(false);
  return (
    <ScreenFrame>
      <section>
        <div>
          <div>
            <p>Available Games</p>
            <h1>Game Library</h1>
          </div>
          <Link to="/dashboard">Back</Link>
        </div>
        <article>
          {/* dont announce a pencil for screen-readers */}
          <div aria-hidden="true">✎</div>
          <div>
            <h2>Draw; Guess</h2>
            {showDetails && <p>One Draw One Guess Hidden Info</p>}
          </div>
          <button
            type="button"
            aria-expanded={showDetails}
            onClick={() => setShowDetails((current) => !current)}
          >
            {showDetails ? "Hide Details" : "View Details"}
          </button>
        </article>
      </section>
    </ScreenFrame>
  );
}
