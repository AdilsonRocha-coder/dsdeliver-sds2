import "./App.css";
import Home from "./Home";
import Navbar from "./Navbar";
/* a função no react retorna um ou mais componentes. */
function App() {
  return (
    <div>
      <Navbar />
      <Home />
    </div>
  );
}

export default App;
