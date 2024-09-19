import logo from './logo.svg';
import './App.css';
// import { FcApproval } from "react-icons/fc";
import Hello from './01/Hello';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Hello />
      </header>
    </div>
  );
}

export default App;
