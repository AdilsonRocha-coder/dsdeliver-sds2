import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./App.css";
import Routes from "./Routes";
/* a função no react retorna um ou mais componentes. */
function App() {
  return (
    <>
      <Routes />
      <ToastContainer />
    </>
  );
}

export default App;
