function App() {
  const name = "Shrayank";
  const flag = false;

  return (
    <div className="container">
      <h1> Hello From React </h1>
      <h2> Hello {name} </h2>
      <h2>Ternary Operator {flag ? "Yes" : "No"} </h2>
    </div>
  );
}

export default App;
