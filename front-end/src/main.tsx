import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import Provider from "@/components/Provider/index.tsx";
import App from "./App.tsx";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <Provider>
      <App />
    </Provider>
  </StrictMode>
);
