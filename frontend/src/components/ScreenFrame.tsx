import type { ReactNode } from "react";
import { Branding } from "./Branding";
import { Footer } from "./Footer";
import { ProfileButton } from "./ProfileButton";

type ScreenFrameProps = {
  children: ReactNode;
  showProfile?: boolean;
};

export function ScreenFrame({
  children,
  showProfile = false,
}: ScreenFrameProps) {
  return (
    <div className="screen-frame">
      <header className="top-bar">
        <Branding />
        {showProfile && <ProfileButton />}
      </header>
      <main className="screen-content">{children}</main>
      <Footer />
    </div>
  );
}
