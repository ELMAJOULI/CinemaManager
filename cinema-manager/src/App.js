import React from "react";
import "./App.css";
import Header from "./Header/Header";
import { Footer } from "./Footer/Footer";
import Home from "./Home/Home";
import { Switch, Route } from "react-router-dom";
import Cinema from "./Cinema/Cinema";

import { Error404 } from "./Error/Error404";
function App() {
  return (
    <div className="App">
      <Header />
      <main>
        <Switch>  
          <Route exact path="/" component={Home} />
          <Route exact path="/cities/:id/cinema" component={Cinema} />
          <Route path="/" component={Error404} />
        </Switch>
      </main>
      <Footer />
    </div>
  );
}

export default App;
