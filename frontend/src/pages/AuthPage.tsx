import type { FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import { ScreenFrame } from "../components/ScreenFrame";

type AuthPageProps = {
  mode: "login" | "register";
};

export function AuthPage({ mode }: AuthPageProps) {
  const navigate = useNavigate();
  const isLogin = mode === "login";

  function submit_form(event: FormEvent<HTMLFormElement>) {
    // page refresh prevention
    event.preventDefault();
    navigate("/dashboard");
  }

  return (
    <ScreenFrame>
      <section>
        <p>Player Access</p>
        <h1>{isLogin ? "Login" : "Register"}</h1>
        <form onSubmit={submit_form}>
          {!isLogin && (
            <label>
              Name
              <input name="name" autoComplete="name" required />
            </label>
          )}
          <label>
            Email
            <input name="email" type="email" required />
          </label>
          <label>
            Password
            <input name="password" type="password" minLength={8} required />
          </label>
          <button type="submit">Continue</button>
        </form>
        <Link to={isLogin ? "/register" : "/login"}>
          {isLogin ? "New Player? Register" : "Already Registered? Login"}
        </Link>
      </section>
    </ScreenFrame>
  );
}
